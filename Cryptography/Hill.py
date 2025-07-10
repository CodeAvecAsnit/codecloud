class HillCipher:
    def __init__(self, key_matrix):
        self.key_matrix = key_matrix
        self.n = len(key_matrix)
        self.det = self.calculate_determinant()
        self.det_inv = self.modular_inverse(self.det, 26)

    def calculate_determinant(self):
        # For 2x2 matrix
        if self.n == 2:
            return (self.key_matrix[0][0] * self.key_matrix[1][1] - 
                    self.key_matrix[0][1] * self.key_matrix[1][0])
        return 0

    def modular_inverse(self, a, m):
        """Calculate modular multiplicative inverse"""
        for x in range(1, m):
            if (a * x) % m == 1:
                return x
        return 1

    def matrix_multiply(self, matrix1, matrix2):
        """Multiply two matrices"""
        # Ensure matrix2 is a column vector
        if not isinstance(matrix2[0], list):
            matrix2 = [[x] for x in matrix2]
        
        # Perform matrix multiplication
        result = []
        for i in range(len(matrix1)):
            total = 0
            for j in range(len(matrix2[0])):
                sum_val = sum(matrix1[i][k] * matrix2[k][j] for k in range(len(matrix2)))
                result.append(sum_val % 26)
        return result

    def encrypt(self, message):
        """Encrypt the message using Hill Cipher"""
        # Prepare the message
        message = message.upper().replace(' ', '')
        
        # Pad message if needed
        while len(message) % self.n != 0:
            message += 'X'
        
        # Convert message to numbers
        nums = [ord(char) - ord('A') for char in message]
        
        # Split into vectors
        encrypted_nums = []
        for i in range(0, len(nums), self.n):
            # Take a slice of n characters
            vector = nums[i:i+self.n]
            
            # Multiply key matrix with vector
            encrypted_vector = self.matrix_multiply(self.key_matrix, vector)
            encrypted_nums.extend(encrypted_vector)
        
        # Convert back to letters
        return ''.join([chr(num + ord('A')) for num in encrypted_nums])

    def decrypt(self, ciphertext):
        """Decrypt the message using Hill Cipher"""
        # Calculate adjugate matrix for 2x2
        adj_matrix = [
            [self.key_matrix[1][1], -self.key_matrix[0][1]],
            [-self.key_matrix[1][0], self.key_matrix[0][0]]
        ]
        
        # Create decryption key
        decrypt_key = [
            [int((adj_matrix[i][j] * self.det_inv) % 26) for j in range(self.n)] 
            for i in range(self.n)
        ]
        
        # Prepare ciphertext
        ciphertext = ciphertext.upper()
        
        # Convert ciphertext to numbers
        nums = [ord(char) - ord('A') for char in ciphertext]
        
        # Decrypt
        decrypted_nums = []
        for i in range(0, len(nums), self.n):
            # Take a slice of n characters
            vector = nums[i:i+self.n]
            
            # Multiply decryption key with vector
            decrypted_vector = self.matrix_multiply(decrypt_key, vector)
            decrypted_nums.extend(decrypted_vector)
        
        # Convert back to letters
        return ''.join([chr(num + ord('A')) for num in decrypted_nums])

def main():
    # Example key matrix (2x2)
    key_matrix = [
        [3, 3],
        [2, 5]
    ]
    
    # Create Hill Cipher instance
    hill_cipher = HillCipher(key_matrix)
    
    # Example usage
    message = "HELLO WORLD"
    
    # Encrypt
    encrypted = hill_cipher.encrypt(message)
    print(f"Original Message: {message}")
    print(f"Encrypted Message: {encrypted}")
    
    # Decrypt
    decrypted = hill_cipher.decrypt(encrypted)
    print(f"Decrypted Message: {decrypted}")

if __name__ == "__main__":
    main()