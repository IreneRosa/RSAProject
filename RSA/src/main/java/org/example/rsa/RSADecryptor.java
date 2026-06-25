package org.example.rsa;

import java.math.BigInteger;

public class RSADecryptor {
    BigInteger plaintext;
    public RSADecryptor(BigInteger ciphertext, BigInteger d, BigInteger n) {
        this.plaintext = ciphertext.modPow(d, n);
    }
    public BigInteger getPlaintext() {
        return plaintext;
    }
    public String toString() {
        return "Ciphertext: " + getPlaintext().toString();
    }
}
