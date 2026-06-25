package org.example.utils;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAMath {
    public static final int BITLENGTH = 1024;
    public static final int CERTAINTY = 100;
    /**
     * Euler function = (p-1)*(q-1)
     * **/
    public static BigInteger eulerFunction(BigInteger p, BigInteger q){
         return p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
    }

    /**
     * n = p * q
     * e = prime number && gcd(e, eulerFunction(n))=1
     * e < eulerFunction(n)
     * **/
    public static BigInteger chooseE(BigInteger euler) {
        SecureRandom random = new SecureRandom();
        BigInteger e;
        do {
            e = BigInteger.probablePrime(BITLENGTH, random);
        }
        while (!e.gcd(euler).equals(BigInteger.ONE) || e.compareTo(euler) >= 0);
        return e;
    }

    /**
     * d = e^-1 mod(eulerFunction(n)
     * **/
    public static BigInteger calculateD(BigInteger euler, BigInteger e) {
        return e.modInverse(euler);
    }
}
