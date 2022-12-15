package thibaut.fr;
import java.util.Scanner;

public class Joueur {
    String nom;
    int tailleGrille;
    char[][] grille;
    int coordonneesX;
    int coordonneesY;
    char[][] positionNavire;
    int nbNavireCouler;
    int coordonneesTir_X;
    int coordonneesTir_Y;
    char vide = '-';
    char navireToucher = 'X';
    char coupDansLeau = 'O';
    char navire = '@';

    Joueur (String nom, int tailleGrille) {
        this.nom = nom;
        this.tailleGrille = tailleGrille;
        grille = new char[tailleGrille+1][tailleGrille+1];
        positionNavire = new char[tailleGrille+1][tailleGrille+1];
        creerGrille();
    }

    private void creerGrille() {
        for (int i = 1; i <= tailleGrille; i++) {
            for (int j = 1; j <= tailleGrille; j++) {
                grille[i][j] = vide;
            }
        } 
    }

    public void addNavire() {
        for (int i = 1; i <= tailleGrille; i++) {
            String msg = "Entrez les coordonnées du navire " + i + " : ";
            System.out.print(msg);
            Scanner coordonnees = new Scanner(System.in);
            this.coordonneesX = coordonnees.nextInt();
            this.coordonneesY = coordonnees.nextInt();

            if (this.coordonneesX > tailleGrille | this.coordonneesY > tailleGrille | this.coordonneesX == 0 | this.coordonneesY == 0) {
                System.out.println("\n Coordonnées invalides. Veuillez réessayer.");
                i = i-1;
            } else if (grille[this.coordonneesX][this.coordonneesY] == navire) {
                System.out.println("\n vous avez déja un navire à cet endroit. Choisissez des coordonnées différentes.");
                i = i-1;
            } else {
                grille[coordonneesX][coordonneesY] = navire;
            }
        }  
    }

    public void grilleHiden() {
        for (int i = 1; i <= tailleGrille; i++) { 
            for (int j = 1; j <= tailleGrille; j++) {
                if (grille[i][j] == navire) {
                    this.positionNavire[i][j] = navire;
                }  else {
                    this.positionNavire[i][j] = vide;
                }
                grille[i][j] = vide;
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
        if (this.coordonneesTir_X > tailleGrille | this.coordonneesTir_Y > tailleGrille | this.coordonneesTir_X == 0 | this.coordonneesTir_Y == 0) {
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
        if (nbNavireCouler == tailleGrille) {
            System.out.println(nom + " A GAGNER !");
            System.exit(1);
        }
    }


    public String toString() {
        String res = "\n";

        for (int i = 0; i <= tailleGrille; i++) {
            if (i >= 10) {
                res += i + " ";
            } else {
                res += i + "  ";
            }
        }
        res += "\n";
        for (int i = 1; i <= tailleGrille; i++) {
            if (i >= 10) {
                res += i + " ";
            } else {
                res += i + "  ";
            }
            for (int j = 1; j <= tailleGrille; j++) {
                res += grille[i][j] + "  ";
            } 
            res += "\n";
        } 
        return res;
    }
}
