import hashlib

def generate_md5_hash(input_string):
    """
    Generate MD5 hash for a given input string
    
    Args:
    input_string (str): String to be hashed
    
    Returns:
    str: MD5 hash value in hexadecimal format
    """
    # Create MD5 hash object
    md5_hash = hashlib.md5()
    
    # Update hash object with input string encoded to bytes
    md5_hash.update(input_string.encode('utf-8'))
    
    # Return hexadecimal representation of hash
    return md5_hash.hexdigest()

def md5_hash_demo():
    """
    Demonstrate MD5 hash generation
    """
    print("MD5 Hash Algorithm Demonstration:")
    
    # Test strings
    test_strings = [
        "Hello, World!",
        "Cryptography",
        "Hash Function",
        "OpenAI"
    ]
    
    # Generate and print MD5 hashes
    for string in test_strings:
        hash_value = generate_md5_hash(string)
        print(f"Input: {string}")
        print(f"MD5 Hash: {hash_value}\n")


str = input("enter the message : ")
hashval = generate_md5_hash(str)
print(f"Input message:{str}")
print(f"Hash value :{hashval}")