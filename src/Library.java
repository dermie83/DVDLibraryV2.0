import java.util.ArrayList;

public class Library {

    private ArrayList<DVD> dvds;

    public Library(){
        dvds = new ArrayList<DVD>();
    }

    public void add(DVD dvd){

        dvds.add (dvd);
    }

    public ArrayList<DVD> getDVDs()
    {
        return dvds;
    }

    public String listDVDs(){
        if (dvds.size() == 0){
            return "No dvds in library";
        }
        else{
            String listOfDVDs = "";
            for (int i = 0; i < dvds.size(); i++){
                listOfDVDs = listOfDVDs + i + ": " + dvds.get(i) + "\n";
            }
            return listOfDVDs;
        }
    }
}
