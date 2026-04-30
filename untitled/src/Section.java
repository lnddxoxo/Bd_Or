import java.util.Calendar;

public class Section {
    private String sec_id;
    private String semester;
    private int year_sec;
    private Course course;
    private Classroom classroom;
    private TimeSlot timeslot;

    public Section(String sec_id, String semester, int year_sec,
                   Course course, Classroom classroom, TimeSlot timeslot) {
        this.sec_id = sec_id;
        this.semester = semester;
        this.year_sec = year_sec;
        this.course = course;
        this.classroom = classroom;
        this.timeslot = timeslot;
    }

    public String getSecId()        { return sec_id; }
    public String getSemester()     { return semester; }
    public int getYearSec()         { return year_sec; }
    public Course getCourse()       { return course; }
    public Classroom getClassroom() { return classroom; }
    public TimeSlot getTimeslot()   { return timeslot; }

    public boolean estPassee() {
        int annee = Calendar.getInstance().get(Calendar.YEAR);
        return year_sec < annee;
    }

    public String getInfoSalle() {
        return "Batiment : " + classroom.getBuilding() +
                " Salle : " + classroom.getRoomNo() +
                " Capacite : " + classroom.getCapacity();
    }

    public String getTitreCours() { return course.getTitle(); }

    @Override
    public String toString() {
        return "Section[" + sec_id + ", " + semester +
                ", " + year_sec + ", " + getTitreCours() +
                ", passee=" + estPassee() + "]";
    }
}