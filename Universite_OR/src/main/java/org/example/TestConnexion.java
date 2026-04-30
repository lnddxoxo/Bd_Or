package org.example;

import java.sql.Connection;

public class TestConnexion {
    public static void main(String[] args) {
        try {
            Connection conn = ConnectionManager.getConnection();
            System.out.println("Connexion OK ! " + conn);
            conn.close();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}