public class Personne {
    protected String ID;
    protected String name_p;

    public Personne(String ID, String name_p) {
        this.ID = ID;
        this.name_p = name_p;
    }

    public String getID()   { return ID; }
    public String getName() { return name_p; }
    public void setID(String ID)       { this.ID = ID; }
    public void setName(String name_p) { this.name_p = name_p; }

    @Override
    public String toString() {
        return "Personne[" + ID + ", " + name_p + "]";
    }
}