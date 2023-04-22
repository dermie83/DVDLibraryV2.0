public class DVD {

    private String title;

    public DVD(){
    // empty constructor
    }

    public DVD(String title){

        this.title = title;

    }

    //-------
    //getters
    //-------
    /**
     * Returns the title
     */
    public String getDVDTitle(){
        return title;
    }

    //-------
    //setters
    //-------
    /**
     * Updates the DVD title
     * @param title The new DVD title
     */
    public void setDVDTitle(String title) {
        this.title = title;
    }


    public String toString()
    {
        return "DVD Title: " + title;

    }


}
