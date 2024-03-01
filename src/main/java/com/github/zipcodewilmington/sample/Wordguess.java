package com.github.zipcodewilmington.sample;

import java.util.Scanner;
public class Wordguess {
    public static void main(String[] args) {
        String[] wordList = {"code", "ball", "horse", "fish", "plane"};
        int numTries;
        String userGuess;
        String randWord;
        char hiddenWord;

        Scanner scan = new Scanner(System.in);

        randWord = wordList[ (int)(Math.random() * wordList.length) ];

    }




}
