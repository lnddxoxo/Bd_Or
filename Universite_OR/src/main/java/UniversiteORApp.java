
import org.example.*;
import java.sql.*;
import java.util.Scanner;

public class UniversiteORApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            afficherMenu();
            System.out.print("Votre choix : ");
            int choix = scanner.nextInt();

            switch (choix) {
                case 1: listerEtudiants();     break;
                case 2: afficherNiveaux();     break;
                case 3: afficherMoyennes();    break;
                case 4: listerInstructeurs();  break;
                case 5: afficherSections();    break;
                case 6: testerDangling();      break;
                case 7: afficherCollections(); break;
                case 8: afficherSuperviseurs();break;
                case 0:
                    continuer = false;
                    System.out.println("\nAu revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
            }
        }
        scanner.close();
    }

    static void afficherMenu() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║     UNIVERSITE OR — Vraies requetes Oracle   ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.println("║  1. Etudiants + departement  (REF)           ║");
        System.out.println("║  2. Niveau des etudiants     (MEMBER)        ║");
        System.out.println("║  3. Moyennes des etudiants   (MEMBER)        ║");
        System.out.println("║  4. Instructeurs + categorie (MEMBER)        ║");
        System.out.println("║  5. Sections + salle + cours (REF chaine)    ║");
        System.out.println("║  6. Tester IS DANGLING       (REF)           ║");
        System.out.println("║  7. Notes par etudiant       (Nested Table)  ║");
        System.out.println("║  8. Info superviseurs        (REF chaine)    ║");
        System.out.println("║  0. Quitter                                  ║");
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    // ── 1. Navigation REF simple ──────────────────────────
    static void listerEtudiants() {
        System.out.println("\n── Navigation REF : s.dept_ref.dept_name ──");
        String sql = "SELECT s.name_p, s.dept_ref.dept_name, s.tot_credit " +
                "FROM Students s ORDER BY s.name_p";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-22s %-15s %s%n", "Etudiant", "Departement", "Credits");
            System.out.println("─".repeat(50));
            while (rs.next()) {
                System.out.printf("%-22s %-15s %s FCFA%n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ── 2. Appel MEMBER FUNCTION getNiveau ────────────────
    static void afficherNiveaux() {
        System.out.println("\n── MEMBER FUNCTION : s.getNiveau() ──");
        String sql = "SELECT s.name_p, s.tot_credit, s.getNiveau() " +
                "FROM Students s ORDER BY s.tot_credit DESC";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-22s %-10s %s%n", "Etudiant", "Credits", "Niveau");
            System.out.println("─".repeat(45));
            while (rs.next()) {
                System.out.printf("%-22s %-10s %s%n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ── 3. Appel MEMBER FUNCTION calculerMoyenne ──────────
    static void afficherMoyennes() {
        System.out.println("\n── MEMBER FUNCTION : s.calculerMoyenne() ──");
        String sql = "SELECT s.name_p, s.calculerMoyenne(), s.estSansEchec() " +
                "FROM Students s ORDER BY s.name_p";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-22s %-10s %s%n", "Etudiant", "Moyenne", "Sans echec");
            System.out.println("─".repeat(45));
            while (rs.next()) {
                System.out.printf("%-22s %-10s %s%n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3).equals("1") ? "Oui" : "Non");
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ── 4. Appel MEMBER FUNCTION getCategorieSalaire ──────
    static void listerInstructeurs() {
        System.out.println("\n── MEMBER FUNCTION : i.getCategorieSalaire() ──");
        String sql = "SELECT i.name_p, i.salary, i.getCategorieSalaire(), " +
                "i.getNbSections() FROM Instructors i ORDER BY i.salary DESC";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-22s %-12s %-15s %s%n",
                    "Instructeur", "Salaire FCFA", "Categorie", "Nb Sections");
            System.out.println("─".repeat(60));
            while (rs.next()) {
                System.out.printf("%-22s %-12s %-15s %s%n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ── 5. Navigation REF chaînée ─────────────────────────
    static void afficherSections() {
        System.out.println("\n── REF chainee : s.getTitreCours() + s.getInfoSalle() ──");
        String sql = "SELECT s.sec_id, s.semester, s.year_sec, " +
                "s.getTitreCours(), s.getInfoSalle(), s.estPassee() " +
                "FROM Sections s ORDER BY s.year_sec DESC";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("─".repeat(70));
            while (rs.next()) {
                System.out.println("Section  : " + rs.getString(1) +
                        " | " + rs.getString(2) +
                        " " + rs.getString(3));
                System.out.println("Cours    : " + rs.getString(4));
                System.out.println("Salle    : " + rs.getString(5));
                System.out.println("Passee   : " + (rs.getString(6).equals("1") ? "Oui" : "Non"));
                System.out.println("─".repeat(70));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ── 6. IS DANGLING ────────────────────────────────────
    static void testerDangling() {
        System.out.println("\n── IS DANGLING : verification integrite REF ──");
        String sql = "SELECT s.name_p, " +
                "CASE WHEN s.dept_ref IS DANGLING " +
                "THEN 'REF INVALIDE' ELSE 'REF OK' END " +
                "FROM Students s";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-22s %s%n", "Etudiant", "Statut REF");
            System.out.println("─".repeat(40));
            while (rs.next()) {
                System.out.printf("%-22s %s%n",
                        rs.getString(1),
                        rs.getString(2));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ── 7. Nested Table ───────────────────────────────────
    static void afficherCollections() {
        System.out.println("\n── Nested Table : TABLE(s.takenote) ──");
        String sql = "SELECT s.name_p, t.grade, t.estReussi() " +
                "FROM Students s, TABLE(s.takenote) t " +
                "ORDER BY s.name_p, t.grade";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.printf("%-22s %-8s %s%n", "Etudiant", "Note", "Reussi");
            System.out.println("─".repeat(40));
            while (rs.next()) {
                System.out.printf("%-22s %-8s %s%n",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3).equals("1") ? "Oui" : "Non");
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    // ── 8. REF chaînée Supervisor ─────────────────────────
    static void afficherSuperviseurs() {
        System.out.println("\n── REF chainee : s.getInfoSuperviseur() ──");
        String sql = "SELECT s.s_id, s.getInfoSuperviseur() " +
                "FROM Supervisors s";
        try (Connection conn = ConnectionManager.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("─".repeat(60));
            while (rs.next()) {
                System.out.println("ID : " + rs.getString(1));
                System.out.println("    " + rs.getString(2));
                System.out.println("─".repeat(60));
            }
        } catch (SQLException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}