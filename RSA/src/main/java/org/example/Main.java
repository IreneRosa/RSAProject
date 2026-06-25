package org.example;

import org.example.rsa.PrivateKey;
import org.example.rsa.RSAKeyGenerator;
import org.example.utils.RSAMath;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {
    public static void main(String[] args) {
        System.out.println("RSA Simulation!");
        SecureRandom random = new SecureRandom();
        BigInteger p,q;
        do{
            p = BigInteger.probablePrime(RSAMath.BITLENGTH, random);
            q = BigInteger.probablePrime(RSAMath.BITLENGTH, random);
        }while( !p.isProbablePrime(RSAMath.CERTAINTY) || !q.isProbablePrime(RSAMath.CERTAINTY) || p.equals(q));

        RSAKeyGenerator Key = new RSAKeyGenerator(p,q);

        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println(Key.getPrivateKey());
        System.out.println(Key.getPublicKey());



    }
}