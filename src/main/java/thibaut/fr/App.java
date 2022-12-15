package thibaut.fr;
import java.util.Scanner;
/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) {
        lancerJeu();
    }

    public static void lancerJeu() {

        System.out.println("Bienvenue dans Guerre Marine !");

        String msg = "entrez la taille des grilles : ";
        System.out.print(msg);
        Scanner scan = new Scanner(System.in);
        int taille = scan.nextInt();

        String msg1 = "Joueur 1 entrez votre nom : ";
        System.out.print(msg1);
        Scanner scan1 = new Scanner(System.in);
        String nomJoueur1 = scan1.next();

        String msg2 = "Joueur 2 entrez votre nom : ";
        System.out.print(msg2);
        Scanner scan2 = new Scanner(System.in);
        String nomJoueur2 = scan2.next();

        Joueur joueur1 = new Joueur(nomJoueur2, taille);
        System.out.println("\n" + nomJoueur1 + ", entrez les coordonnées de vos navires, sous la forme [L C] (L représente la ligne entre 0 et " + taille + " et C la colonne entre 0 et " + taille + ").");
        joueur1.addNavire();
        
        System.out.println("\n" + joueur1.toString());
        for (int y = 0; y < 50; y++) {
            System.out.println("");
        }

        Joueur joueur2 = new Joueur(nomJoueur1, taille);
        System.out.println(nomJoueur2 + ", entrez les coordonnées de vos navires, sous la forme [L C] (L représente la ligne entre 0 et " + taille + " et C la colonne entre 0 et " + taille + ").");
        joueur2.addNavire();
        
        System.out.println("\n" + joueur2.toString());
        for (int y = 0; y < 50; y++) {
            System.out.println("");
        }



        
        joueur1.grilleHiden();
        joueur2.grilleHiden();

        for (int i = 0; i < 1000; i++) {
            joueur1.ecrireTir();
            System.out.println("\n" + joueur1.toString());
            joueur1.partieFini();
    
            joueur2.ecrireTir();
            System.out.println("\n" + joueur2.toString());
            joueur2.partieFini();
        }
    }
}
