import java.util.ArrayList;
import java.util.List;

public class Instructor extends Personne {
    private Department dept;
    private double salary;
    private List<Section> sections;

    public Instructor(String ID, String name_p,
                      Department dept, double salary) {
        super(ID, name_p);
        this.dept = dept;
        this.salary = salary;
        this.sections = new ArrayList<>();
    }

    public Department getDept()        { return dept; }
    public double getSalary()          { return salary; }
    public List<Section> getSections() { return sections; }
    public void setSalary(double s)         { this.salary = s; }
    public void addSection(Section section) { sections.add(section); }

    public void augmenterSalaire(double pct) {
        this.salary = this.salary * (1 + pct / 100);
    }

    public int getNbSections() { return sections.size(); }

    public String getCategorieSalaire() {
        if (salary < 300000)      return "Junior";
        else if (salary < 600000) return "Intermediaire";
        else if (salary < 900000) return "Senior";
        else                      return "Expert";
    }

    @Override
    public String toString() {
        return "Instructor[" + ID + ", " + name_p +
                ", dept=" + dept.getDeptName() +
                ", salaire=" + Math.round(salary) + " FCFA" +
                ", categorie=" + getCategorieSalaire() +
                ", nbSections=" + getNbSections() + "]";
    }
}