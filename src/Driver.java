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
        System.out.println("New DVD added to library.");

    }

    private void updateDVD(){
        System.out.println(library.listDVDs());
        if (library.getDVDs().size() > 0)
            System.out.print("Enter the index of the DVD to edit >>>:  ");
            int index = input.nextInt();
            if((index >= 0) && (index <= library.getDVDs().size())) {

            // gather new details of DVD by user
            input.nextLine();
            System.out.print("Enter the new DVD title:  ");
            String dvdTitle = input.nextLine();

            DVD dvd = library.getDVDs().get(index);
            dvd.setDVDTitle(dvdTitle);

        }
        else {
            System.out.println("There is no DVD for this index number");
        }
    }

    private void deleteDVD(){
        // list the DVDs and ask the user to delete the DVD from the array list
        System.out.println(library.listDVDs());
        if (library.getDVDs().size() > 0){
            System.out.print("Enter the index of the DVD to delete >>>:  ");
            int index = input.nextInt();
            if((index >= 0) && (index <= library.getDVDs().size())){
                library.getDVDs().remove(index);
                System.out.println("DVD deleted!");
            }
            else{
                System.out.println("There is no DVD for this index number");
            }
        }

    }

    private int mainMenu(){
        System.out.println("DVD Library Menu");
        System.out.println("---------");
        System.out.println("  1) Add a DVD to library");
        System.out.println("  2) List all DVDs in library");
        System.out.println("  3) Update a DVD in library");
        System.out.println("  4) Delete a DVD from library");
        System.out.println("  5) Save DVD");
        System.out.println("  6) Load DVD");
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
                case 3:
                    updateDVD();
                    break;
                case 4:
                    deleteDVD();
                    break;
                case 5:
                    saveDVDs();
                    break;
                case 6:
                    loadDVDs();
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

    private void saveDVDs(){
        try{
            library.save();
            System.out.println("DVD save to library");

        }catch(Exception e) {
            System.out.println("Error reading file "+e);

        }
    }

    private void loadDVDs(){
        try{
            library.load();
            System.out.println("DVDs successfully loaded from library");

        }catch(Exception e) {
            System.out.println("Error reading file "+e);

        }
    }


    public static void main(String[] args) {

        Driver app = new Driver();
        app.run();

    }
}