def encryptMessage(message, key):
    # Create the rail fence pattern
    rail = [['\n' for _ in range(len(message))] for _ in range(key)]
    
    # Track direction 
    direction = False
    row, col = 0, 0
    
    # Mark the rails
    for char in message:
        # Change direction at first and last row
        if row == 0 or row == key - 1:
            direction = not direction
        
        # Place character
        rail[row][col] = char
        col += 1
        
        # Move to next row
        if direction:
            row += 1
        else:
            row -= 1
    
    # Collect the cipher text
    cipherText = ''
    for r in range(key):
        for c in range(len(message)):
            if rail[r][c] != '\n':
                cipherText += rail[r][c]
    
    return cipherText

def main():
    # Get user input
    message ="UNforgettable"
    key = 7
    
    # Encrypt the message
    cipherText = encryptMessage(message, key)
    
    # Print results
    print(f"Original Message: {message}")
    print(f"Encrypted Message: {cipherText}")

# Run the main function
if __name__ == "__main__":
    main()