import random

PC1 = [
    57, 49, 41, 33, 25, 17, 9,  
    1, 58, 50, 42, 34, 26, 18,  
    10, 2, 59, 51, 43, 35, 27,  
    19, 11, 3, 60, 52, 44, 36,  
    63, 55, 47, 39, 31, 23, 15,  
    7, 62, 54, 46, 38, 30, 22,  
    14, 6, 61, 53, 45, 37, 29,  
    21, 13, 5, 28, 20, 12, 4
]

PC2 = [
    14, 17, 11, 24, 1, 5,
    3, 28, 15, 6, 21, 10,
    23, 19, 12, 4, 26, 8,
    16, 7, 27, 20, 13, 2,
    41, 52, 31, 37, 47, 55,
    30, 40, 51, 45, 33, 48,
    44, 49, 39, 56, 34, 53,
    46, 42, 50, 36, 29, 32
]

EXPANSION_TABLE = [
    32, 1, 2, 3, 4, 5,
    4, 5, 6, 7, 8, 9,
    8, 9, 10, 11, 12, 13,
    12, 13, 14, 15, 16, 17,
    16, 17, 18, 19, 20, 21,
    20, 21, 22, 23, 24, 25,
    24, 25, 26, 27, 28, 29,
    28, 29, 30, 31, 32, 1
]

SHIFTS = [1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1]

S_BOXES = [
    [  
        [14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7],
        [0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8],
        [4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0],
        [15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13]
    ]
]


def permute(data, table):
    return [data[i-1] for i in table]


def left_shift(key_half, shifts):
    return key_half[shifts:] + key_half[:shifts]


def generate_keys(initial_key):
    key = permute(initial_key, PC1)
    C, D = key[:28], key[28:]
    keys = []

    for shift in SHIFTS:
        C = left_shift(C, shift)
        D = left_shift(D, shift)
        keys.append(permute(C + D, PC2))

    return keys


def sbox_substitution(block, sbox):
    row = int(f"{block[0]}{block[5]}", 2)
    col = int(f"{''.join(map(str, block[1:5]))}", 2)
    return format(sbox[row][col], '04b')


def generate_random_key():
    return [random.randint(0, 1) for _ in range(64)]


def expand_block(block):
    return permute(block, EXPANSION_TABLE)


def feistel_function(R, round_key):
    expanded_R = expand_block(R)
    xored = [expanded_R[i] ^ round_key[i] for i in range(len(expanded_R))]
    substituted = []
    
    for i in range(0, len(xored), 6):
        substituted.extend([int(b) for b in sbox_substitution(xored[i:i+6], S_BOXES[0])])
    
    return substituted


def des_encrypt_block(block, round_keys):
    L, R = block[:32], block[32:]
    
    for i in range(16):
        new_R = feistel_function(R, round_keys[i])
        new_R = [new_R[j] ^ L[j] for j in range(32)]
        L, R = R, new_R
        print(f"Round {i+1}: L={''.join(map(str, L))}, R={''.join(map(str, R))}")
    
    return R + L


def pad_message(message):
    binary_message = ''.join(format(ord(c), '08b') for c in message)
    
    while len(binary_message) < 64:
        binary_message += '0'
    
    return [int(bit) for bit in binary_message[:64]]


def encrypt_message(message):
    key = generate_random_key()
    round_keys = generate_keys(key)
    binary_message = pad_message(message)
    encrypted_block = des_encrypt_block(binary_message, round_keys)
    
    return ''.join(map(str, encrypted_block))


if __name__ == "__main__":
    message = input("Enter the message : ")
    encrypted_message = encrypt_message(message)
    print(f"Encrypted Message: {encrypted_message}")