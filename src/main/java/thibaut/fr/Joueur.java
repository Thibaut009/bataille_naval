package thibaut.fr;
import java.util.Scanner;

public class Joueur {
    String nom;
    char[][] grille = new char[5][5];
    int coordonneesX;
    int coordonneesY;
    char[][] positionNavire = new char[5][5];
    int nbNavireCouler;
    int coordonneesTir_X;
    int coordonneesTir_Y;
    char vide = '-';
    char navireToucher = 'X';
    char coupDansLeau = 'O';
    char navire = '@';

    Joueur (String nom) {
        this.nom = nom;
        creerGrille();
    }

    private void creerGrille() {
        for (int i = 0; i <5; i++) { 
            for (int j = 0; j < 5; j++) {
                if (i == 0 && j >= 0) {
                    char c = (char)(j+'0');
                    grille[i][j] = c;

                } else if (j == 0 && i > 0) {
                    char c = (char)(i+'0');
                    grille[i][j] = c;

                } else {
                    grille[i][j] = vide;
                }
            } 
        } 
    }

    public void addNavire() {
        for (int i = 1; i < 5; i++) {
            String msg = "Entrez les coordonnées du navire " + i + " : ";
            System.out.print(msg);
            Scanner coordonnees = new Scanner(System.in);
            this.coordonneesX = coordonnees.nextInt();
            this.coordonneesY = coordonnees.nextInt();

            if (this.coordonneesX > 4 | this.coordonneesY > 4 | this.coordonneesX == 0 | this.coordonneesY == 0) {
                System.out.println("\n Coordonnées invalides. Veuillez réessayer.");
                i = i-1;
            } else {
                grille[coordonneesX][coordonneesY] = navire;
            }
        }  
    }

    public void grilleHiden() {
        for (int i = 0; i <5; i++) { 
            for (int j = 0; j < 5; j++) {
                if (i == 0 && j >= 0) {
                    char c = (char)(j+'0');
                    grille[i][j] = c;
                } else if (j == 0 && i > 0) {
                    char c = (char)(i+'0');
                    grille[i][j] = c;
                } else {
                    if (grille[i][j] == navire) {
                        this.positionNavire[i][j] = navire;
                    }  else {
                        this.positionNavire[i][j] = vide;
                    }
                    grille[i][j] = vide;
                }
            } 
        } 
    }

    public void ecrireTir() {
        System.out.print(nom + " entrez les coordonnées de votre tir : ");
        Scanner coordonnees1 = new Scanner(System.in);
        this.coordonneesTir_X = coordonnees1.nextInt();
        this.coordonneesTir_Y = coordonnees1.nextInt();
        verifTir();
    }

    public void verifTir() {
        if (this.coordonneesTir_X > 4 | this.coordonneesTir_Y > 4 | this.coordonneesTir_X == 0 | this.coordonneesTir_Y == 0) {
            System.out.println("\n Coordonnées invalides. Veuillez réessayer.");
            ecrireTir();
            
        } else if (this.positionNavire[this.coordonneesTir_X][this.coordonneesTir_Y] == navireToucher | 
                   this.positionNavire[this.coordonneesTir_X][this.coordonneesTir_Y] == coupDansLeau) {
            System.out.println("\n Vous avez déjà ciblé cet endroit. Choisissez des coordonnées différentes.");
            ecrireTir();
        } else {
            addTir();
        }
    }

    public void addTir() {
        if (this.positionNavire[this.coordonneesTir_X][this.coordonneesTir_Y] == navire) {
            grille[this.coordonneesTir_X][this.coordonneesTir_Y] = navireToucher;
            this.positionNavire[this.coordonneesTir_X][this.coordonneesTir_Y] = navireToucher;
            System.out.println("\n navire couler !!!");
            this.nbNavireCouler++;

        } else if(this.positionNavire[this.coordonneesTir_X][this.coordonneesTir_Y] == vide) {
            grille[this.coordonneesTir_X][this.coordonneesTir_Y] = coupDansLeau;
            this.positionNavire[this.coordonneesTir_X][this.coordonneesTir_Y] = coupDansLeau;
            System.out.println("\n coup dans l'eau !!!");

        }
    }

    public void partieFini() {
        if (nbNavireCouler == 4) {
            System.out.println(nom + " A GAGNER !");
            System.exit(1);
        }
    }


    public String toString() {
        String res = "\n";
        
         for (int i = 0; i <5; i++) { 
             for (int j = 0; j < 5; j++) {
                 if (i == 0 && j >= 0 | j == 0 && i > 0) {
                     res += grille[i][j] + " ";

                 } else {
                     res += grille[i][j] + " ";
                 }
             } 
             res += "\n";
         } 
        return res;
    }
}
