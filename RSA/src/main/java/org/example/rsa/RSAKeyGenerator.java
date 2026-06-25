package org.example.rsa;

import org.example.utils.RSAMath;

import java.math.BigInteger;


/**
 * p and q prime numbers
 * n = p * q
 * eulerFunction = (p-1)*(q-1)
 * e = prime number && gcd(e, euler)==1
 * d = e^-1 mod(euler)
 * **/
public class RSAKeyGenerator {
     private PublicKey publicKey;
     private PrivateKey privateKey;

     public RSAKeyGenerator(BigInteger p, BigInteger q){
         BigInteger n =  p.multiply(q);
         BigInteger euler = RSAMath.eulerFunction(p,q);
         BigInteger e = RSAMath.chooseE(euler);
         publicKey = new PublicKey(e, n);

         BigInteger d = RSAMath.calculateD(euler, e);
         privateKey = new PrivateKey(d, n);
     }

     public PrivateKey getPrivateKey(){
         return privateKey;
     }
     public PublicKey getPublicKey(){
         return publicKey;
     }

}
