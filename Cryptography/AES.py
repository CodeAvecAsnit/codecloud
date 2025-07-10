from Crypto.Cipher import AES
import binascii
import os

def pad(text):
    """
    Pad the input text to ensure it's a multiple of 16 bytes.
    Uses PKCS7 padding for more secure padding method.
    """
    # Calculate the number of padding bytes needed
    padding_length = 16 - (len(text) % 16)
    # Create padding bytes with the value of padding length
    padding = bytes([padding_length] * padding_length)
    return text.encode() + padding

def unpad(text):
    """
    Remove PKCS7 padding from decrypted text.
    """
    # Last byte indicates the padding length
    padding_length = text[-1]
    return text[:-padding_length]

def aes_encrypt(plaintext, key):
    """
    Encrypt plaintext using AES in CBC mode.
    
    :param plaintext: Text to encrypt (string)
    :param key: Encryption key (bytes or string)
    :return: Hex-encoded string of IV + encrypted text
    """
    # Ensure key is bytes and exactly 16 bytes long
    if isinstance(key, str):
        key = key.encode()
    key = key.ljust(16, b'\0')[:16]
    
    # Generate a random 16-byte Initialization Vector (IV)
    iv = os.urandom(16)
    
    # Create AES cipher object in CBC mode
    cipher = AES.new(key, AES.MODE_CBC, iv)
    
    # Pad and encrypt the text
    padded_text = pad(plaintext)
    encrypted_text = cipher.encrypt(padded_text)
    
    # Return IV + encrypted text as hex-encoded string
    return binascii.hexlify(iv + encrypted_text).decode()

def aes_decrypt(ciphertext, key):
    """
    Decrypt ciphertext using AES in CBC mode.
    
    :param ciphertext: Hex-encoded string of IV + encrypted text
    :param key: Decryption key (bytes or string)
    :return: Decrypted plaintext
    """
    # Ensure key is bytes and exactly 16 bytes long
    if isinstance(key, str):
        key = key.encode()
    key = key.ljust(16, b'\0')[:16]
    
    # Convert hex-encoded ciphertext back to bytes
    ciphertext = binascii.unhexlify(ciphertext)
    
    # Extract IV and encrypted text
    iv, encrypted_text = ciphertext[:16], ciphertext[16:]
    
    # Create AES cipher object in CBC mode
    cipher = AES.new(key, AES.MODE_CBC, iv)
    
    # Decrypt and unpad the text
    decrypted_text = cipher.decrypt(encrypted_text)
    return unpad(decrypted_text).decode()

def main():
    # Example usage
    # Note: In a real-world scenario, use a truly random and secure key
    key = "MySecretKey12345"  # 16-byte key
    
    # Example messages to encrypt
    messages = [
        "Hello, AES Encryption!",
        "This is a secret message.",
        "Secure communication rocks!"
    ]
    
    for plaintext in messages:
        print(f"\nOriginal message: {plaintext}")
        
        # Encrypt the message
        ciphertext = aes_encrypt(plaintext, key)
        print(f"Ciphertext: {ciphertext}")
        
        # Decrypt the message
        decrypted_text = aes_decrypt(ciphertext, key)
        print(f"Decrypted text: {decrypted_text}")
        
        # Verify encryption/decryption
        assert plaintext == decrypted_text, "Decryption failed!"

if __name__ == "__main__":
    main()