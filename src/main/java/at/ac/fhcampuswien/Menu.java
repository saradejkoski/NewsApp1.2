package at.ac.fhcampuswien;

public class Menu {

    private AppController controller;
    private static final String INVALID_INPUT_MESSAGE = "Invalid input !";
    private static final String EXIT_MESSAGE = "Bye Bye";

    
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

        public void start() {
            Menu.printMenu();
        }

        private void getTopHeadlinesAustria(AppController ctrl) {

        }

}
