package main.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    private int counterErrors;
    private static final int MAX_ERRORS = 6;
    private String secretWord;
    private String secretWordForConsole;

    public void start() {
        List<String> missingLetters = new ArrayList<>();
        List<String> guessedLetters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        makeWord();
        //       System.out.println(secretWord);                                       //Для теста.
        while (counterErrors < MAX_ERRORS) {
            System.out.println(Scaffold.draw(counterErrors));
            printInConsole(secretWordForConsole, missingLetters);

            String letter = scanner.next();
            boolean secretWordContainsLetter = secretWord.contains(String.valueOf(letter));
            boolean missingLettersContainsLetter = missingLetters.contains(letter);
            boolean wordContainsLetter = guessedLetters.contains(letter);

            if (Validator.isValid(String.valueOf(letter))) {

                if (secretWordContainsLetter || missingLettersContainsLetter) {
                    if (missingLettersContainsLetter || wordContainsLetter) {
                        System.out.println("*****************************************");
                        System.out.println("Такая буква уже есть.Будьте внимательнее!");
                        System.out.println("*****************************************");
                    }
                    decipherLetters(letter);
                    guessedLetters.add(letter);
                } else if (!missingLettersContainsLetter) {
                    counterErrors++;
                    missingLetters.add(letter);
                }

                if (secretWordForConsole.equals(secretWord)) {
                    printWin();
                    break;
                }

                if (counterErrors == MAX_ERRORS) {
                    printGameOver();
                    break;
                }
            }
        }
        counterErrors = 0;
    }


    public void makeWord() {
        Word word = new Word();
        secretWord = word.randomWords();
        secretWordForConsole = "*".repeat(secretWord.length());
    }


    public void printInConsole(String secretWordConsol, List<String> listMissingLetters) {
        System.out.println("Загаданное слово: " + secretWordConsol);
        System.out.println("Ошибки: " + counterErrors + " " + listMissingLetters);
        System.out.println("Введите букву: ");
    }


    public void printWin() {
        System.out.println("***************************************************");
        System.out.println("Вы выйграли!" + "\n" +
                "Загаданное слово: " + secretWord + "\n" +
                "Количество ошибок, допущеных во время игры: " + counterErrors);
        System.out.println("***************************************************");
    }


    public void printGameOver() {
        System.out.println(Scaffold.SIX);
        System.out.println("***************************************************");
        System.out.println("Вы допустили слишком много  ошибок. GAME OVER!!!" + "\n"
                + "Загаданное слово: " + secretWord);
        System.out.println("***************************************************");
    }


    public void decipherLetters(String letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (letter.indexOf(secretWord.charAt(i)) != -1) {
                secretWordForConsole = secretWordForConsole.substring(0, i) +
                        secretWord.charAt(i) + secretWordForConsole.substring(i + 1);
            }
        }
    }
}
