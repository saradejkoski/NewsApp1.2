package at.ac.fhcampuswien;

import java.util.Scanner;

public class Menu {

    private AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "Invalid input !";
    private static final String EXIT_MESSAGE = "Bye Bye";


    public void start() {
        printMenu();                               // printed das Menu
        Scanner scan = new Scanner(System.in);     // initialisiert scanner
        String input = scan.nextLine();            // wartet auf den input

        while (true) {                             // Endlosschleife
            if (input.equals("q")){                // checkt ob input q ist
                handleInputString(input);          // führt case für q aus
                break;                             // beendet die Endlosschleife
            }
            handleInputString(input);              // führt case für alles aus, was nicht q ist, bsp: a
            start();                               // führt die startmethode erneut aus (rekursion) --> Menu wird wieder geprinted
            break;                                 // beendet die Endlosschleife
        }
    }


    private void handleInputString(String input) {

        switch (input) {

            case "a":
                getTopHeadlinesAustria(controller);
                break;
            case "b":
                getAllNewsBitcoin(controller);
                break;
            case "y":
                getArticleCount(controller);
                break;
            case "q":
                printExitMessage();
                break;
            default:
                printInvalidInputMessage();
        }
    }

    private void getArticleCount(AppController ctrl) {
        System.out.println(controller.getArticleCount());
    }

    private void getTopHeadlinesAustria(AppController ctrl) {
        System.out.println(controller.getTopHeadlinesAustria().toString());
    }

    private void getAllNewsBitcoin(AppController ctrl) {
        System.out.println(controller.getAllNewsBitcoin().toString());
    }

    private static void printMenu() {
        System.out.println("*****************************");
        System.out.println("*  Welcome to NewsApp    *   ");
        System.out.println("*****************************");
        System.out.println("Enter what you wanna do:");
        System.out.println("a: Get top headlines austria");
        System.out.println("b: Get all news about bitcoin");
        System.out.println("y: Count articles");
        System.out.println("q: Quit program");
    }

    private static void printInvalidInputMessage() {
        System.out.println(INVALID_INPUT_MESSAGE);
    }

    private static void printExitMessage() {
        System.out.println(EXIT_MESSAGE);
    }
}
