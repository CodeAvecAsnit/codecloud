# Define character sets
upperCase = [chr(i) for i in range(65, 91)]
lowerCase = [chr(j) for j in range(97, 123)]

def encryptMessage(plainText, key):
    cipherText = ''
    for letter in plainText:
        if letter in lowerCase:
            index = lowerCase.index(letter)
            shiftedIndex = (index + key) % 26
            cipherText += lowerCase[shiftedIndex]
        elif letter in upperCase:
            index = upperCase.index(letter)
            shiftedIndex = (index + key) % 26
            cipherText += upperCase[shiftedIndex]
        else:
            cipherText += letter
    return cipherText

def decryptMessage(ciphertext, key):
    plainText = ''
    for letter in ciphertext:
        if letter in lowerCase:
            index = lowerCase.index(letter)
            shiftedIndex = (index - key) % 26
            plainText += lowerCase[shiftedIndex]
        elif letter in upperCase:
            index = upperCase.index(letter)
            shiftedIndex = (index - key) % 26
            plainText += upperCase[shiftedIndex]
        else:
            plainText += letter
    return plainText

def main():
    # Get input from user
    message = input('Enter your message here: ')
    key = int(input('Enter your key here: '))
    
    # Encrypt message
    ciphertext = encryptMessage(message, key)
    print(f'Encrypted message: {ciphertext}')
    
    # Decrypt message
    plainText = decryptMessage(ciphertext, key)
    print(f'Decrypted message: {plainText}')

# Run the main function
if __name__ == "__main__":
    main()