import java.util.Scanner;

public class Driver {
    private Scanner input = new Scanner(System.in);

    private Library library;

    public Driver(){
        library = new Library();
    }

    private void addDVD(){
        //dummy read of String to clear the buffer - bug in Scanner class.
        input.nextLine();
        System.out.print("Enter the DVD title:  ");
        String dvdTitle = input.nextLine();

        library.add(new DVD(dvdTitle));

    }

    private int mainMenu(){
        System.out.println("DVD Library Menu");
        System.out.println("---------");
        System.out.println("  1) Add a DVD to library");
        System.out.println("  2) List all DVDs in library");
        System.out.println("  0) Exit");
        System.out.print("==>> ");
        int option = input.nextInt();
        return option;
    }

    private void run()
    {
        int option = mainMenu();
        while (option != 0)
        {
            switch (option)
            {
                case 1:
                    addDVD();
                    break;
                case 2:
                    System.out.println(library.listDVDs());
                    break;
                default:
                    System.out.println("Invalid option selected.");
                    break;
            }

            //display the main menu again
            System.out.println("");
            option = mainMenu();
        }
        System.out.println("Exiting... bye");
    }


    public static void main(String[] args) {

        Driver app = new Driver();
        app.run();

    }
}