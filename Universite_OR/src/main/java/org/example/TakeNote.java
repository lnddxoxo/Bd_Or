package org.example;

public class TakeNote {
    private Section section;
    private String grade;

    public TakeNote(Section section, String grade) {
        this.section = section;
        this.grade = grade;
    }

    public Section getSection() { return section; }
    public String getGrade()    { return grade; }

    public boolean estReussi() { return !grade.equals("F"); }

    public String getInfoSection() {
        return "Section : " + section.getSecId() +
                " Semestre : " + section.getSemester() +
                " Cours : " + section.getTitreCours();
    }

    @Override
    public String toString() {
        return "TakeNote[" + section.getSecId() +
                ", grade=" + grade +
                ", reussi=" + estReussi() + "]";
    }
}