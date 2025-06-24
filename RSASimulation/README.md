# RSA Simulation

This project is based on simulating RSA encryption and decryption in Java. It includes user-side key generation, message encryption, and decryption between two users using core RSA principles.

## RSA.java

- Implements modular exponentiation with `powerMod`.
- Provides `Encrypt` and `Decrypt` methods using RSA logic.

## RSAUser.java

- Represents an RSA user with `publicKey`, `privateKey`, and modulus `num`.
- Keys are generated using two provided prime numbers.
- Uses the Extended Euclidean Algorithm to compute the private key.
- Can send encrypted messages to another user and decrypt received ones.

## User.java

- Demonstrates interaction between two users: one encrypts and sends a message, the other decrypts it.
- Example:
  - `ram` and `sita` are RSA users.
  - `ram` sends an encrypted message to `sita`.
  - `sita` decrypts and displays the original message.

