import math

# Create character sets
upperCase = [chr(i) for i in range(65, 91)]
lowerCase = [chr(j) for j in range(97, 123)]

def encryptMessage(plainText, key):
    cipherText = ''
    keylen = math.ceil(len(plainText) / len(key))
    key = (key * keylen)[:len(plainText)]
    
    for i, letter in enumerate(plainText):
        if letter in lowerCase:
            index = lowerCase.index(letter)
            shifter = lowerCase.index(key[i].lower())
            shiftedIndex = (index + shifter) % 26
            cipherText += lowerCase[shiftedIndex]
        elif letter in upperCase:
            index = upperCase.index(letter)
            shifter = lowerCase.index(key[i].lower())
            shiftedIndex = (index + shifter) % 26
            cipherText += upperCase[shiftedIndex]
        else:
            cipherText += letter
    
    return cipherText

def decryptMessage(cipherText, key):
    plainText = ''
    keylen = math.ceil(len(cipherText) / len(key))
    key = (key * keylen)[:len(cipherText)]
    
    for i, letter in enumerate(cipherText):
        if letter in lowerCase:
            index = lowerCase.index(letter)
            shifter = lowerCase.index(key[i].lower())
            shiftedIndex = (index - shifter) % 26
            plainText += lowerCase[shiftedIndex]
        elif letter in upperCase:
            index = upperCase.index(letter)
            shifter = lowerCase.index(key[i].lower())
            shiftedIndex = (index - shifter) % 26
            plainText += upperCase[shiftedIndex]
        else:
            plainText += letter
    
    return plainText

def main():
    # Get input from user
    message = input('Enter your Message: ')
    
    # Use predefined key or allow user input
    key = input('Enter encryption key (default is "mykey"): ') or 'mykey'
    
    # Encrypt message
    cipherText = encryptMessage(message, key)
    print(f'Your encrypted Message: {cipherText}')
    
    # Decrypt message
    key2 = input('Please enter the secret key to decrypt the message: ')
    plainText = decryptMessage(cipherText, key2)
    print(f'Your hidden message is: {plainText}')

# Run the main function
if __name__ == "__main__":
    main()