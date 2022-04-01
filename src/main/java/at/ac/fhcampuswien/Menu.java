package at.ac.fhcampuswien;

import java.sql.SQLOutput;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class Menu {

    private AppController controller = new AppController();
    private static final String INVALID_INPUT_MESSAGE = "Invalid input !";
    private static final String EXIT_MESSAGE = "Bye Bye";


    // prints Menu and lets you put in your option
    public void start() {

        Scanner scan = new Scanner(System.in);
        printMenu();

        //String input = scan.next();
        handleInputString(scan.next());
    }

    Scanner scanner = new Scanner(System.in);


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
