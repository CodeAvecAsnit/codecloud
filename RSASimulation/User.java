package com.see.alr.nocap.RSASimulation;



public class User {

    public static void main(String[] args) {
        RSAUser ram = new RSAUser(69427, 11293); // public keys generated
        RSAUser sita = new RSAUser(14143, 12497);

        long message = 299908; // plaintext
        ram.sendMessage(sita, message); // Ram encrypts for Sita

        long decrypted = sita.getReceivedMessage(); // Sita decrypts
        System.out.println("Decrypted Message: " + decrypted);
    }


}


