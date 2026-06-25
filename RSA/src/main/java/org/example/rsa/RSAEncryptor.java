package org.example.rsa;

import java.math.BigInteger;
/**
 * msg = original message; it's plaintext and BigInteger number
 * ciphertext = encrypted message
 * **/
public class RSAEncryptor {
    BigInteger ciphertext;
    public RSAEncryptor(BigInteger msg, BigInteger e, BigInteger n) {
        this.ciphertext = msg.modPow(e, n);
    }
    public BigInteger getCiphertext() {
        return ciphertext;
    }
    public String toString() {
        return "Ciphertext: " + getCiphertext().toString();
    }
}
