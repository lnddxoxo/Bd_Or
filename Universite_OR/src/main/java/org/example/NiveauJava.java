package org.example;

public class NiveauJava {

    public static String getNiveau(double tot_credit) {
        if (tot_credit >= 240)      return "M2";
        else if (tot_credit >= 180) return "M1";
        else if (tot_credit >= 120) return "L3";
        else if (tot_credit >= 60)  return "L2";
        else                        return "L1";
    }

    public static String getCategorieSalaire(double salary) {
        if (salary < 2000)      return "Junior";
        else if (salary < 4000) return "Intermediaire";
        else if (salary < 7000) return "Senior";
        else                    return "Expert";
    }
}