package com.github.zipcodewilmington.sample;

import java.util.Scanner;
public class Wordguess {
    public static void main(String[] args) {
        String[] letterList = {"ball", "code", "horse", "fish", "plane"};
        int numTries = 6;
        char userGuess;
        char randWord = 0;

        Scanner scan = new Scanner(System.in);

        while(true) {
            System.out.print("Let's Play Wordguess version 1.0\n" + "Current Guesses:\n" + "_ _ _\n" + "You have 3 tries left.\n" + "Enter a single character:\n");
            userGuess = Character.toUpperCase(scan.next().charAt(0));
            if(userGuess == randWord){
                System.out.printf("%d\n", userGuess);
                System.out.printf("%d _ _ _ ", userGuess);
                System.out.printf("You have %d tries left", numTries);
            } else if(userGuess > randWord){
                System.out.printf("%d\n", userGuess);
                System.out.printf("%_ _ _ _", userGuess);
                System.out.printf("You have %d tries left", numTries);
            }

        }
    }




}
