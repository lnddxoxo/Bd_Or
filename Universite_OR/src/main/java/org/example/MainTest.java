package org.example;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {

        System.out.println("=== TEST BD OBJET-RELATIONNELLE ===\n");

        Department info = new Department("INFO", "Informatique", 5000);
        Department math = new Department("MATH", "Mathematiques", 4000);
        Department bio  = new Department("BIO",  "Biologie", 3500);

        System.out.println("── Departments ──");
        System.out.println(info);
        System.out.println(math);
        info.augmenterBudget(500);
        System.out.println("Apres augmentation : " + info);

        Classroom c1 = new Classroom("BatA", "S101", 30);
        Classroom c2 = new Classroom("BatA", "S102", 100);

        System.out.println("\n── Classrooms ──");
        System.out.println(c1);
        System.out.println(c2);

        TimeSlot ts1 = new TimeSlot("TS1","Lundi","08:00","10:00");
        TimeSlot ts2 = new TimeSlot("TS2","Mardi","10:00","12:00");

        System.out.println("\n── TimeSlots ──");
        System.out.println(ts1);
        System.out.println(ts2);

        Course cs101   = new Course("CS101","Bases de Donnees",info,6);
        Course cs102   = new Course("CS102","Programmation Java",info,4);
        Course math101 = new Course("MATH101","Algebre Lineaire",math,4);
        cs102.addPrereq(cs101);

        System.out.println("\n── Courses ──");
        System.out.println(cs101);
        System.out.println(cs102);
        System.out.println("CS102 a prereqs : " + cs102.aPrerequis());
        System.out.println("Nb prereqs : " + cs102.getNbPrerequis());

        Section s1 = new Section("S1","Fall",2024,cs101,c1,ts1);
        Section s2 = new Section("S2","Fall",2024,cs102,c2,ts2);
        Section s3 = new Section("S3","Spring",2023,math101,c1,ts1);

        System.out.println("\n── Sections ──");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("S1 passee : " + s1.estPassee());
        System.out.println("S1 info salle : " + s1.getInfoSalle());

        TakeNote tn1 = new TakeNote(s1, "A");
        TakeNote tn2 = new TakeNote(s2, "B");
        TakeNote tn3 = new TakeNote(s3, "F");

        System.out.println("\n── TakeNotes ──");
        System.out.println(tn1);
        System.out.println(tn3);
        System.out.println("tn1 reussi : " + tn1.estReussi());
        System.out.println("tn3 reussi : " + tn3.estReussi());
        System.out.println("tn1 info : " + tn1.getInfoSection());

        Student st1 = new Student("S001","Diallo Fatoumata",info,130);
        st1.addInscription(tn1);
        st1.addInscription(tn2);

        Student st2 = new Student("S002","Kouassi Adjoua",math,60);
        st2.addInscription(tn3);

        Student st3 = new Student("S003","Mensah Kwame",bio,240);

        System.out.println("\n── Students ──");
        System.out.println(st1);
        System.out.println(st2);
        System.out.println(st3);

        System.out.println("\nNiveaux :");
        System.out.println(st1.getName() + " → " + st1.getNiveau());
        System.out.println(st2.getName() + " → " + st2.getNiveau());
        System.out.println(st3.getName() + " → " + st3.getNiveau());

        System.out.println("\nMoyennes :");
        System.out.println(st1.getName() + " → " + st1.calculerMoyenne());
        System.out.println(st2.getName() + " → " + st2.calculerMoyenne());

        System.out.println("\nSans echec :");
        System.out.println(st1.getName() + " → " + st1.estSansEchec());
        System.out.println(st2.getName() + " → " + st2.estSansEchec());

        List<Student> tous = new ArrayList<>();
        tous.add(st1); tous.add(st2); tous.add(st3);
        System.out.println("\nNb etudiants : " + Student.compterEleves(tous));

        Instructor i1 = new Instructor("I001","Toure Mamadou",info,5000);
        Instructor i2 = new Instructor("I002","Bamba Aminata",math,3500);
        i1.addSection(s1);
        i2.addSection(s3);

        System.out.println("\n── Instructors ──");
        System.out.println(i1);
        System.out.println(i2);

        System.out.println("\nApres augmentation 10% :");
        i2.augmenterSalaire(10);
        System.out.println(i2.getName() + " → " + i2.getSalary());
        System.out.println(i2.getName() + " → " + i2.getCategorieSalaire());

        Supervisor sup = new Supervisor("S001", i1);
        System.out.println("\n── Supervisors ──");
        System.out.println(sup);
        System.out.println(sup.getInfoSuperviseur());

        System.out.println("\n── NiveauJava ──");
        System.out.println("130 credits → " + NiveauJava.getNiveau(130));
        System.out.println("240 credits → " + NiveauJava.getNiveau(240));
        System.out.println("5000 salaire → " + NiveauJava.getCategorieSalaire(5000));
        System.out.println("1500 salaire → " + NiveauJava.getCategorieSalaire(1500));

        System.out.println("\n=== FIN DES TESTS ===");
    }
}