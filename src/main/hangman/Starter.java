package main.hangman;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        Scanner scanner2 = new Scanner(System.in);
        Service game = new Service();

        while (true) {
            System.out.println("Введите" + "'" + "с" + "'" + ",чтобы начать игру или введите" + "'" + "в" + "'" + ",чтобы выйти из приложения.");
            String userInput = scanner2.nextLine();
            if (Validator.isValid(userInput)) {

                if (userInput.equals("с")) {
                    System.out.println("Поехали!");
                    game.start();
                }
                if (userInput.equals("в")) {
                    System.out.println("До свидания!");
                    System.exit(0);
                }
            }
        }
    }
}
