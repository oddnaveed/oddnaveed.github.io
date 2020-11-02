---
title: Cybersecurity
date: 2020-08-03 12:47:35
tags: [linux]
categories: [software]
top:
visible:
---

# Lab1: Linux command

```bash 
^  // start of a file
$  // end of a file
. // any character in regex
.* any count of any characters
grep '^a.*c$' newfile   // start with a, end with c
```

<!--more>

# Lab2: Encrypt & Decrypt

```bash
openssl -h  // help page with cipher type information

```



# Lecture1

- C confidentiality
- I integrity
- A availability


# Lecture2
- plain text -> cipher text -> plain text
- symmetric key cipher: same key to encrypt and decrypt
- asymmetric key cipher: different keys to encrpt and decrypt
- principles of ciphers:
  - confusion: transposition/permutation -> change order
  - diffusion: substitution -> replace with ciphertext

## Classical Cipher
- usually uses either substitution (monoalphabetic and polyalphabetic) or transposition
- not safe enough due to limited key size and language characteristics

### Substitution Cipher

#### Caesar Cipher
- subsitution cipher
- monoalphabetic cipher
- replace each letter by the ith letter
- have the frequency analysis attact problem (might leak key info)

#### Vigenere Cipher
- substitution cipher
- polyalphabetic cipher
- hide frequency information
- possible to have repeated word encrpted in the same way

### Transposition Cipher

#### Rail Fence Cipher
- zigzag style

## Modern Ciphers
- both substitution and transposition(product ciphers)
- symmetric key:
  - block (64 bits, 128 bits etc)
  - stream (each bit)

### DES - Data Encryption Standard
- block cipher
- 64bits key(56 bits key + 8 bits parity)
- double DES, triple DES(safe but too slow)

### AES - Advanced Encryption Standard
- block cipher
- 10, 12, 14 rounds with key size 128, 192, 256 bits respectively

## Block Cipher Modes
- which mode does not require padding? CFB?

### ECB
- encrypted and decrypted independently
- message repetition problem, especially with graphics
- messeage changes little

### CBC
- linking encryption operations, next ciphertext depends on the previous ciphertext
- has an initialisation vector (IV)
- hide repeating information well

### CFB
- block can be arbitrary size
- don't have to use paddings
- has an initialisation vector (IV)
- similar with CBC, ciphertext depends on previous plaintext

### CBC vs CFB
- CBC performs XOR with plaintext before encryption
- CFB performs XOR with plaintext after encryption

### OFB
- message is treated as stream of bits