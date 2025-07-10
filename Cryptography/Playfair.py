def find_index(matrix, letter):
    """Find the row and column of a letter in the matrix"""
    for r, row in enumerate(matrix):
        for c, element in enumerate(row):
            if letter in element:
                return r, c
    return None, None

def generate_matrix(key):
    """Generate the Playfair cipher key matrix"""
    letters = [chr(i) for i in range(65, 91) if chr(i) != 'J']
    
    matrix = [[None for _ in range(5)] for _ in range(5)]
    
    used_letters = []
    
    key = key.upper().replace('J', 'I')
    for char in key:
        if char not in used_letters and char in letters:
            used_letters.append(char)
    
    for char in letters:
        if char not in used_letters:
            used_letters.append(char)
    

    count = 0
    for r in range(5):
        for c in range(5):
            matrix[r][c] = used_letters[count]
            count += 1
    
    return matrix

def prepare_message(message):
    """Prepare message for Playfair encryption"""
    # Remove spaces and convert to uppercase
    message = message.upper().replace(' ', '').replace('J', 'I')
    
    # Pair the letters
    pairs = []
    i = 0
    while i < len(message):
        if i == len(message) - 1:
            # If odd number of letters, add 'X'
            pairs.append(message[i] + 'X')
            break
        
        # If two consecutive letters are the same, insert 'X'
        if message[i] == message[i+1]:
            pairs.append(message[i] + 'X')
            i += 1
        else:
            pairs.append(message[i:i+2])
            i += 2
    
    return pairs

def encrypt_message(message, key):
    """Encrypt message using Playfair Cipher"""
    # Generate key matrix
    key_matrix = generate_matrix(key)
    
    # Prepare message
    message_pairs = prepare_message(message)
    
    # Encryption
    cipher_text = ''
    for pair in message_pairs:
        # Find indices of letters
        r1, c1 = find_index(key_matrix, pair[0])
        r2, c2 = find_index(key_matrix, pair[1])
        
        # Same row
        if r1 == r2:
            cipher_text += key_matrix[r1][(c1 + 1) % 5]
            cipher_text += key_matrix[r2][(c2 + 1) % 5]
        
        # Same column
        elif c1 == c2:
            cipher_text += key_matrix[(r1 + 1) % 5][c1]
            cipher_text += key_matrix[(r2 + 1) % 5][c2]
        
        # Rectangle case
        else:
            cipher_text += key_matrix[r1][c2]
            cipher_text += key_matrix[r2][c1]
    
    return cipher_text

def decrypt_message(cipher_text, key):
    """Decrypt message using Playfair Cipher"""
    # Generate key matrix
    key_matrix = generate_matrix(key)
    
    # Prepare cipher text into pairs
    cipher_pairs = [cipher_text[i:i+2] for i in range(0, len(cipher_text), 2)]
    
    # Decryption
    plain_text = ''
    for pair in cipher_pairs:
        # Find indices of letters
        r1, c1 = find_index(key_matrix, pair[0])
        r2, c2 = find_index(key_matrix, pair[1])
        
        # Same row
        if r1 == r2:
            plain_text += key_matrix[r1][(c1 - 1) % 5]
            plain_text += key_matrix[r2][(c2 - 1) % 5]
        
        # Same column
        elif c1 == c2:
            plain_text += key_matrix[(r1 - 1) % 5][c1]
            plain_text += key_matrix[(r2 - 1) % 5][c2]
        
        # Rectangle case
        else:
            plain_text += key_matrix[r1][c2]
            plain_text += key_matrix[r2][c1]
    
    return plain_text

def main():
    # Example usage
    message = "CRYPTOGRAPHY"
    key = "ACHS"
    
    # Encrypt
    encrypted = encrypt_message(message, key)
    print(f"Original Message: {message}")
    print(f"Encrypted Message: {encrypted}")
    
    # Decrypt
    decrypted = decrypt_message(encrypted, key)
    print(f"Decrypted Message: {decrypted}")

if __name__ == "__main__":
    main()