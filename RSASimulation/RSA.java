package com.see.alr.nocap.RSASimulation;


public class RSA {

    private long powerMod(long num,long power,long modDivisor){
        long ans = 1L;
        num = num%modDivisor;
        for(int i = 0 ; i < power;++i){
            ans= (ans*num)%modDivisor;
        }
        return ans;
    }

    public long Encrypt(long plainText, long publicKey,long num){
        return powerMod(plainText,publicKey,num);
    }

    public long Decrypt(long cipherText,long privateKey,long num){
        return powerMod(cipherText,privateKey,num);
    }

}
