def totient(n):

    result = n
    p = 2
    while p * p <= n:
        if n % p == 0:
            while n % p == 0:
                n //= p
            result *= (1 - 1/p)
        p += 1
    
    if n > 1:
        result *= (1 - 1/n)
    
    return int(result)
def gcd(a, b):
    """Compute Greatest Common Divisor using Euclidean algorithm"""
    while b:
        a, b = b, a % b
    return a

def find_primitive_root(n):
    """
    Find a primitive root modulo n
    
    Args:
    n (int): Modulus to find primitive root for
    
    Returns:
    int: A primitive root, or None if no primitive root exists
    """
    if n <= 1:
        return None
    
    # Compute totient of n
    phi = totient(n)
    
    # Find prime factors of φ(n)
    factors = []
    temp_phi = phi
    p = 2
    while p * p <= temp_phi:
        if temp_phi % p == 0:
            factors.append(p)
            while temp_phi % p == 0:
                temp_phi //= p
        p += 1
    if temp_phi > 1:
        factors.append(temp_phi)
    
    # Test potential primitive roots
    for g in range(2, n):
        if all(pow(g, phi // factor, n) != 1 for factor in factors):
            return g
    
    return None

print("\nPrimitive Root Finding:")
primitive_root_moduli = [15,17,19,331]
for modulus in primitive_root_moduli:
  root = find_primitive_root(modulus)
  print(f"Primitive root of {modulus}: {root}")