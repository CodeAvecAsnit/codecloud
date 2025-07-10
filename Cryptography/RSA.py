import math
import random

def is_prime(n):
    """Check if a number is prime"""
    if n < 2:
        return False
    for i in range(2, int(math.sqrt(n)) + 1):
        if n % i == 0:
            return False
    return True

def gcd(a, b):
    """Compute Greatest Common Divisor"""
    while b:
        a, b = b, a % b
    return a

def generate_keypair(p, q):
    """
    Generate public and private keys
    
    Args:
    p, q (int): Two distinct prime numbers
    
    Returns:
    tuple: ((public_key, n), (private_key, n))
    """
    if not (is_prime(p) and is_prime(q)):
        raise ValueError("Both numbers must be prime")
    
    n = p * q
    phi = (p - 1) * (q - 1)
    
    # Choose e (public key)
    e = random.randint(1, phi)
    while gcd(e, phi) != 1:
        e = random.randint(1, phi)
    
    # Compute private key d
    d = pow(e, -1, phi)
    
    return ((e, n), (d, n))

def encrypt(pk, plaintext):

    key, n = pk
    cipher = [pow(ord(char), key, n) for char in plaintext]
    return cipher

def decrypt(pk, ciphertext):
    """
    Decrypt message using private key
    
    Args:
    pk (tuple): Private key (d, n)
    ciphertext (list): Encrypted message
    
    Returns:
    str: Decrypted message
    """
    key, n = pk
    plain = [chr(pow(char, key, n)) for char in ciphertext]
    return ''.join(plain)

def main_rsa():
    print("\nRSA Encryption Demonstration:")
    # Choose two prime numbers
    p, q = 17, 19
    
    # Generate keys
    public_key, private_key = generate_keypair(p, q)
    
    # Message to encrypt
    message = "RSA ENCRYPTION"
    print(f"Original Message: {message}")
    
    # Encrypt
    encrypted_msg = encrypt(public_key, message)
    print(f"Encrypted Message: {encrypted_msg}")
    
    # Decrypt
    decrypted_msg = decrypt(private_key, encrypted_msg)
    print(f"Decrypted Message: {decrypted_msg}")

  
main_rsa()