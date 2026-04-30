public class Supervisor {
    private String s_id;
    private Instructor instructeur;

    public Supervisor(String s_id, Instructor instructeur) {
        this.s_id = s_id;
        this.instructeur = instructeur;
    }

    public String getSId()             { return s_id; }
    public Instructor getInstructeur() { return instructeur; }

    public String getInfoSuperviseur() {
        return "Superviseur : " + instructeur.getName() +
                " Salaire : " + Math.round(instructeur.getSalary()) + " FCFA" +
                " Dept : " + instructeur.getDept().getDeptName();
    }

    @Override
    public String toString() {
        return "Supervisor[" + s_id + ", " + getInfoSuperviseur() + "]";
    }
}