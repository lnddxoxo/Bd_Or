import java.util.ArrayList;
import java.util.List;

public class Student extends Personne {
    private Department dept;
    private double tot_credit;
    private List<TakeNote> inscriptions;

    public Student(String ID, String name_p,
                   Department dept, double tot_credit) {
        super(ID, name_p);
        this.dept = dept;
        this.tot_credit = tot_credit;
        this.inscriptions = new ArrayList<>();
    }

    public Department getDept()             { return dept; }
    public double getTotCredit()            { return tot_credit; }
    public List<TakeNote> getInscriptions() { return inscriptions; }
    public void setTotCredit(double c)      { this.tot_credit = c; }
    public void addInscription(TakeNote n)  { inscriptions.add(n); }

    public String getNiveau() {
        if (tot_credit >= 240)      return "M2";
        else if (tot_credit >= 180) return "M1";
        else if (tot_credit >= 120) return "L3";
        else if (tot_credit >= 60)  return "L2";
        else                        return "L1";
    }

    public boolean estSansEchec() {
        for (TakeNote note : inscriptions)
            if (note.getGrade().equals("F")) return false;
        return true;
    }

    public double calculerMoyenne() {
        if (inscriptions.isEmpty()) return 0;
        double total = 0;
        for (TakeNote note : inscriptions) {
            switch (note.getGrade()) {
                case "A": total += 20; break;
                case "B": total += 16; break;
                case "C": total += 13; break;
                case "D": total += 10; break;
                default:  total += 0;  break;
            }
        }
        return Math.round((total / inscriptions.size()) * 100.0) / 100.0;
    }

    public static int compterEleves(List<Student> etudiants) {
        return etudiants.size();
    }

    @Override
    public String toString() {
        return "Student[" + ID + ", " + name_p +
                ", dept=" + dept.getDeptName() +
                ", credits=" + tot_credit +
                ", niveau=" + getNiveau() +
                ", moyenne=" + calculerMoyenne() +
                ", sansEchec=" + estSansEchec() + "]";
    }
}