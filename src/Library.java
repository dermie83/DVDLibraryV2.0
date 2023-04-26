import java.util.ArrayList;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

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

    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());

        // ------------------ PREVENT SECURITY WARNINGS-----------------------------
        // The Product class is what we are reading in.
        // Modify to include others if needed by modifying the next line,
        // add additional classes inside the braces, comma separated

        Class<?>[] classes = new Class[] { DVD.class };

        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("dvds.xml"));
        dvds = (ArrayList<DVD>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());

        // ------------------ PREVENT SECURITY WARNINGS-----------------------------
        // The Product class is what we are reading in.
        // Modify to include others if needed by modifying the next line,
        // add additional classes inside the braces, comma separated

        Class<?>[] classes = new Class[] { DVD.class };

        XStream.setupDefaultSecurity(xstream);
        xstream.allowTypes(classes);
        // -------------------------------------------------------------------------

        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("dvds.xml"));
        out.writeObject(dvds);
        out.close();
    }
}
