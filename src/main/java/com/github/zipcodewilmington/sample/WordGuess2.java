package com.github.zipcodewilmington.sample;

import java.util.Random;
import java.util.Scanner;

public class WordGuess2 {
    public static Scanner scan = new Scanner(System.in);
    public static Random random = new Random();
    public static int maxNumberOfTries = 6;
    public static int numberOfTries = 0;
    public static String[] randomWords = {"code", "java", "line", "wordguess", "maven"};
    public static String codingWord = randomWords[random.nextInt(randomWords.length)];
    public static char[] solution = codingWord.toCharArray();
    public static char[] playerGuesses = new char[solution.length];
    public static int currentNumberOfTries;
    public static char letter;
    public static boolean found = false;



    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        while (true) {
            if (playSelect().equals("no")) {
                endGame();
                break;
            }
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" + "Let's Play Fishing WordGuess version 1.0!\n" + "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.print("You have a maximum of [" + maxNumberOfTries + "] guesses!\n");     //tells user maximum tries.
            while (numberOfTries < maxNumberOfTries) {

                randomWordSpaces();
                gameDisplay();

                correctGuess();
                wrongGuess();
                winningGame();
                outOfTries();

                quitingTheGame();
            }
            break;
        }
    }

    public static String playSelect() {
        System.out.println("Would you like to play WordGuess 2.0? [Yes/No]");
        return scan.next().toLowerCase();
    }

    public static void randomWordSpaces() {
            for (int i = 0; i < playerGuesses.length; i++) {    //Puts a _ for every letter in "fishingWord".
                playerGuesses[i] = '_';

        }
    }

    public static void gameDisplay() {
        System.out.println("\nYour word has [" + playerGuesses.length + "] letters: ");

        for (char userGuess : playerGuesses) {
            System.out.print(userGuess + " ");
        }

        currentNumberOfTries = maxNumberOfTries - numberOfTries;

        System.out.println("\nYou have [" + currentNumberOfTries + "] tries left.");    //tells user how many tries they have left.

        System.out.print("Enter a letter or '-' to end the program: ");

        letter = scan.next().charAt(0);     //user input guess.
    }

    public static void correctGuess() {
        found = false;
        for (int i = 0; i < solution.length; i++) {
            if (solution[i] == letter) {    //if users attempt is correct.
                playerGuesses[i] = letter;
                found = true;
            }
        }
        if (found) {
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
                    "Correct guess! '" + letter + "' is in the word.\n" +
                    "-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        }
    }

    public static void wrongGuess() {
        if (!found) {   //if users attempt is incorrect.
            System.out.println("\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n\nThat letter was Incorrect.");
            numberOfTries++;
        }
    }

    public static void winningGame() {
        if (String.valueOf(playerGuesses).equals(codingWord)) {    //if user guesses the word.
            System.out.println("Congratulations! You've guessed the word: " + codingWord + "\n-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
        }
    }

    public static void quitingTheGame() {
        if (letter == '-') {     //Option for user to quit the game.
            System.out.print("Quitting the game... Thanks for playing.\n");
            endGame();
        }
    }

    public static void outOfTries() {
        if (numberOfTries == maxNumberOfTries) {     //if user runs out of guesses.
            System.out.println("You Lost! You ran out of guesses!\n" + "The word was: " + codingWord);
        }
    }

    public static void playAgain() {
        playSelect();
    }

    public static void endGame() {
        System.out.println("Thank you for playing!\n");
    }

}
