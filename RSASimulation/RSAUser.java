package com.see.alr.nocap.RSASimulation;

import java.util.Random;

public class RSAUser {
    private final long privateKey;
    public long num;
    public long message;
    public long publicKey;
    RSA rsa;


    static class Result{
        long gcd;
        long x;
        long y;

        public Result(long gcd,long x,long y){
            this.gcd=gcd;
            this.x=x;
            this.y=y;
        }
    }


    public RSAUser(long prime1,long prime2){
        this.num=prime1*prime2;
        long phi = (prime1-1)*(prime2-1);
        this.publicKey=generatePublicKey(phi);
        this.privateKey=generatePrivateKey(phi);
        this.rsa= new RSA();
        System.out.println("Public key of user : "+ publicKey);
        System.out.println("Private Key of User : "+ privateKey);
    }

    private long GCD(long a, long b){
        return (a%b==0)?b:GCD(b,a%b);
    }

    private long generatePublicKey(long phi){
        Random random = new Random();
        int counter=0;
        while(true){
            long n = 2L + Math.abs(random.nextLong()) % (phi - 2L);
            if(GCD(phi,n)==1){
                return n;
            }
            ++counter;
            if(counter>1000){
                return -1;
            }
        }
    }


    public void setMessage(long message){
        this.message=message;
    }


    public void sendMessage(RSAUser rsaUser,long message){
        Long mess = rsa.Encrypt(message,rsaUser.publicKey,rsaUser.num);
        System.out.println("Message sent"+mess);
        rsaUser.setMessage(mess);
    }


    public long getReceivedMessage(){
        System.out.println(this.message);
        return rsa.Decrypt(this.message,this.privateKey,this.num);
    }

    private Result extendedGCD(long a,long b){
        if(b==0){
            return new Result(a,1,0);
        }
        Result next = extendedGCD(b,a%b);
        long x1=next.x;
        long y1=next.y;
        long x=y1;
        long y = x1-(a/b)*y1;
        return new Result(next.gcd,x,y);
    }


    private long generatePrivateKey(long phi){
        Result result = extendedGCD(phi,this.publicKey);
        if(result.y>0){
            return result.y;
        }else return (phi+result.y);
    }
}
