import random

def diffie_hellman_key_exchange():
    """
    Simulate Diffie-Hellman Key Exchange
    
    Returns:
    tuple: Shared secret keys for Alice and Bob
    """
    # Public parameters (publicly known)
    p = 23  # Prime number
    g = 5   # Primitive root modulo p
    
    # Alice's private key (secret)
    a = random.randint(1, p-1)
    # Bob's private key (secret)
    b = random.randint(1, p-1)
    
    # Alice's public key
    A = pow(g, a, p)
    # Bob's public key
    B = pow(g, b, p)
    
    # Shared secrets
    alice_shared_secret = pow(B, a, p)
    bob_shared_secret = pow(A, b, p)
    
    return (a, A), (b, B), alice_shared_secret, bob_shared_secret

def main_diffie_hellman():
    print("Diffie-Hellman Key Exchange Demonstration:")
    (a, A), (b, B), alice_secret, bob_secret = diffie_hellman_key_exchange()
    
    print(f"Alice's Private Key: {a}")
    print(f"Alice's Public Key: {A}")
    print(f"Bob's Private Key: {b}")
    print(f"Bob's Public Key: {B}")
    print(f"Alice's Shared Secret: {alice_secret}")
    print(f"Bob's Shared Secret: {bob_secret}")
    print(f"Shared Secret Matches: {alice_secret == bob_secret}")

main_diffie_hellman()