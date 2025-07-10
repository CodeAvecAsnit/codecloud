import random

def is_prime(n):
    """Check if a number is prime"""
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def find_primitive_root(p):
    """Find a primitive root modulo p"""
    if not is_prime(p):
        raise ValueError("p must be prime")
    
    # Find prime factors of p-1
    factors = []
    phi = p - 1
    d = 2
    while d * d <= phi:
        if phi % d == 0:
            factors.append(d)
            while phi % d == 0:
                phi //= d
        d += 1
    if phi > 1:
        factors.append(phi)
    
    # Test potential primitive roots
    for g in range(2, p):
        is_primitive_root = all(pow(g, (p-1)//factor, p) != 1 for factor in factors)
        if is_primitive_root:
            return g
    
    return None

def elgamal_keygen(p=None):
    """
    Generate Elgamal public and private keys
    
    Args:
    p (int, optional): Prime number. If None, a prime will be generated.
    
    Returns:
    tuple: ((private_key, public_key), public_key)
    """
    # If no prime is provided, use a default prime
    if p is None:
        p = 23
    
    # Ensure p is prime
    if not is_prime(p):
        raise ValueError("p must be prime")
    
    # Find primitive root
    g = find_primitive_root(p)
    if g is None:
        raise ValueError("Could not find primitive root")
    
    # Private key (randomly chosen)
    x = random.randint(2, p - 2)
    
    # Public key
    h = pow(g, x, p)
    
    return (x, (p, g, h)), (p, g, h)

def elgamal_encrypt(public_key, message):
    """
    Encrypt message using Elgamal cryptosystem
    
    Args:
    public_key (tuple): (p, g, h)
    message (int): Message to encrypt
    
    Returns:
    tuple: Encrypted message components
    """
    p, g, h = public_key
    
    # Ensure message is within valid range
    if message < 0 or message >= p:
        raise ValueError("Message must be between 0 and p-1")
    
    # Random key
    k = random.randint(1, p - 2)
    
    # Encryption
    c1 = pow(g, k, p)  # First component
    c2 = (message * pow(h, k, p)) % p  # Second component
    
    return (c1, c2)

def elgamal_decrypt(private_key, public_key, ciphertext):
    """
    Decrypt Elgamal encrypted message
    
    Args:
    private_key (int): Private key x
    public_key (tuple): (p, g, h)
    ciphertext (tuple): (c1, c2)
    
    Returns:
    int: Decrypted message
    """
    p, g, h = public_key
    c1, c2 = ciphertext
    
    # Compute shared secret
    s = pow(c1, private_key, p)
    
    # Compute modular multiplicative inverse
    def mod_inverse(a, m):
        def egcd(a, b):
            if a == 0:
                return b, 0, 1
            else:
                gcd, x, y = egcd(b % a, a)
                return gcd, y - (b // a) * x, x
        
        gcd, x, _ = egcd(a, m)
        if gcd != 1:
            raise Exception('Modular inverse does not exist')
        else:
            return x % m
    
    # Decrypt
    s_inv = mod_inverse(s, p)
    message = (c2 * s_inv) % p
    
    return message

def main():
    print("Elgamal Cryptosystem Demonstration:")
    
    # Select a prime number
    p = 23
    
    try:
        # Generate key pair
        (private_key, full_public_key), public_key = elgamal_keygen(p)
        
        # Messages to test
        test_messages = [10, 15, 20]
        
        for message in test_messages:
            print(f"\nTesting with message: {message}")
            
            # Encrypt
            ciphertext = elgamal_encrypt(public_key, message)
            print(f"Encrypted Message: {ciphertext}")
            
            # Decrypt
            decrypted_msg = elgamal_decrypt(private_key, public_key, ciphertext)
            print(f"Decrypted Message: {decrypted_msg}")
            
            # Verify
            assert message == decrypted_msg, "Decryption failed!"
    
    except Exception as e:
        print(f"An error occurred: {e}")

if __name__ == "__main__":
    main()
