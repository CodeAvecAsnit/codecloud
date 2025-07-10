import hashlib

def generate_sha_hash(input_string, algorithm='sha256'):
    """
    Generate SHA hash for a given input string
    
    Args:
    input_string (str): String to be hashed
    algorithm (str): SHA algorithm to use (sha1, sha256, sha512)
    
    Returns:
    str: SHA hash value in hexadecimal format
    """
    # Create hash object based on specified algorithm
    if algorithm == 'sha1':
        sha_hash = hashlib.sha1()
    elif algorithm == 'sha256':
        sha_hash = hashlib.sha256()
    elif algorithm == 'sha512':
        sha_hash = hashlib.sha512()
    else:
        raise ValueError("Unsupported SHA algorithm")
    
    # Update hash object with input string encoded to bytes
    sha_hash.update(input_string.encode('utf-8'))
    
    # Return hexadecimal representation of hash
    return sha_hash.hexdigest()

def sha_hash_demo():
    """
    Demonstrate SHA hash generation for different algorithms
    """
    print("SHA Hash Algorithm Demonstration:")
    
    # Test strings
    test_strings = [
        "Hello, World!",
        "Cryptography",
    ]
    
    # SHA algorithms to demonstrate
    sha_algorithms = ['sha1', 'sha256', 'sha512']
    
    # Generate and print SHA hashes
    for string in test_strings:
        print(f"Input: {string}")
        for algo in sha_algorithms:
            hash_value = generate_sha_hash(string, algo)
            print(f"{algo.upper()} Hash: {hash_value}")
        print()

sha_hash_demo()