import math

def additive_inverse(a, m):
    """Finds the additive inverse of 'a' under modulo 'm'"""
    return (-a) % m

def gcd_extended(a, b):
    """Extended Euclidean Algorithm to find gcd and multiplicative inverse"""
    if a == 0:
        return b, 0, 1
    else:
        gcd, x1, y1 = gcd_extended(b % a, a)
        x = y1 - (b // a) * x1
        y = x1
        return gcd, x, y

def multiplicative_inverse(a, m):
    """Finds the multiplicative inverse of 'a' under modulo 'm' if it exists"""
    gcd, x, _ = gcd_extended(a, m)
    if gcd != 1:
        return None  # No multiplicative inverse if gcd is not 1
    else:
        return x % m

def is_relatively_prime(a, b):
    """Checks if 'a' and 'b' are relatively prime"""
    return math.gcd(a, b) == 1

def main():
    # Test cases
    test_cases = [
        (3, 7),   # Relatively prime case
        (4, 10),  # Not relatively prime case
        (5, 11)   # Another relatively prime case
    ]

    for a, m in test_cases:
        print(f"\nTesting with a = {a}, m = {m}")
        print(f"Additive inverse of {a} mod {m}: {additive_inverse(a, m)}")
        
        mult_inv = multiplicative_inverse(a, m)
        print(f"Multiplicative inverse of {a} mod {m}: {mult_inv}")
        
        if mult_inv is not None:
            # Verify multiplicative inverse
            verify = (a * mult_inv) % m
            print(f"Verification: ({a} * {mult_inv}) mod {m} = {verify}")
        
        print(f"Are {a} and {m} relatively prime? {is_relatively_prime(a, m)}")

if __name__ == "__main__":
    main()