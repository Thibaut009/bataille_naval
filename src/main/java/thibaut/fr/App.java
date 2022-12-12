package thibaut.fr;

/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) {
        lancerJeu();
    }

    public static void lancerJeu() {

        System.out.println("Bienvenue dans Guerre Marine !");

        Joueur joueur1 = new Joueur("Joueur 2");
        System.out.println("JOUEUR 1, entrez les coordonnées de vos navires, sous la forme [L C] (L représente la ligne entre 0 et 4 et C la colonne entre 0 et 4).");

        joueur1.addNavire();
        
        System.out.println("\n" + joueur1.toString());
        for (int y = 0; y < 20; y++) {
            System.out.println("");
        }


        Joueur joueur2 = new Joueur("Joueur 1");
        System.out.println("JOUEUR 2, entrez les coordonnées de vos navires, sous la forme [L C] (L représente la ligne entre 0 et 4 et C la colonne entre 0 et 4).");

        joueur2.addNavire();
        
        System.out.println("\n" + joueur2.toString());
        for (int y = 0; y < 20; y++) {
            System.out.println("");
        }


        joueur1.grilleHiden();
        joueur2.grilleHiden();

        for (int i = 0; i < 20; i++) {
            joueur1.ecrireTir();
            System.out.println("\n" + joueur1.toString());
            joueur1.partieFini();
    
    
            joueur2.ecrireTir();
            System.out.println("\n" + joueur2.toString());
            joueur2.partieFini();
        }
    }
}
