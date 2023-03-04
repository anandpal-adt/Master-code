package com.amazin.nayra.common;


import java.util.Random;

public class PasswordUtil {

    private String capAlphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String smallAlphabets = "abcdefghijklmnopqrstuvwxyz";
    private String numeric = "0123456789";
    private String spcChars = "!@#$&";

    /*
     * method to generate a random password
     */
    public String generatePassword(int passwordLength) {

        String passwordChars = capAlphabets + smallAlphabets + numeric + spcChars;

        Random random = new Random();
        String password = new String("");

        for (int i = 0; i < passwordLength; i++) {
            password += passwordChars.charAt(random.nextInt(passwordChars.length()));

        }

        return password;
    }

    public String generateSalt(int saltLength) {

        String passwordChars = capAlphabets + smallAlphabets + numeric + spcChars;

        Random random = new Random();
        String salt = new String("");

        for (int i = 0; i < saltLength; i++) {
            salt += passwordChars.charAt(random.nextInt(passwordChars.length()));

        }

        return salt;
    }

    public static void main(String[] args) {
        PasswordUtil util = new PasswordUtil();
        for (int i = 0; i < 10; i++) {
            System.out.println(util.generatePassword(8));
        }

    }

}
