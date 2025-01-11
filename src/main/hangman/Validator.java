package main.hangman;

import java.util.regex.Pattern;

public class Validator {
    public static boolean isValid(String letter) {
        if (!Pattern.matches("^[а-я]$", letter)) {
            System.out.println("****************************************************");
            System.out.println("Необходимо ввести только одну строчную русскую букву");
            System.out.println("****************************************************");
            return false;
        }
        return true;
    }
}
