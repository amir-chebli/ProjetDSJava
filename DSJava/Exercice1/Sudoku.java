import java.util.Scanner;

public class Sudoku {
  
  private static final int TAILLE = 9;  //constante
  
  public static void main(String[] args) {
      
    Scanner clavier = new Scanner(System.in); //pour l'input
    int [][] grille = new int[TAILLE][TAILLE]; //creation du matrice grille de sudoku
    
    do{ //la saisie du puzzle par l'utilisateur
        System.out.println("Veuiller introduire la grille Sudoku a resoudre : ");
        for(int ligne = 0; ligne < TAILLE; ligne++){
            for(int colonne = 0; colonne < TAILLE; colonne++){
                int x;
                do{
                    System.out.print("grille[" + ligne + "][" + colonne + "]: ");
                    x = clavier.nextInt();
                }while(verifierNombre(x) == true);
                grille[ligne][colonne] = x;
            }
        }
        afficherGrille(grille); //affichage de grille saisie par l'utilisateur
        if (solution(grille)) {
          System.out.println("Résolu avec succés !");
        }
        else {
          System.out.println("Grille ne peut pas être résolu");
        }
    }while(solution(grille)); //pour forcer l'utilisateur a saisir une grille correcte
    
    
    afficherGrille(grille); //affichage de grille aprés solution
  }
  
  private static boolean verifierNombre(int nombre){
      return !(nombre >= 0 && nombre < 10); //pour verifier que le nombre saisie par l'utilisateur est entre 1 et 9
  }
  
  private static void afficherGrille(int[][] grille) {  //creation de la fonction d'affichage de grille
    for (int ligne = 0; ligne < TAILLE; ligne++) {   //la plus part des if internes est principalement pour achever un bon affichage
      if (ligne % 3 == 0 && ligne != 0) {
        System.out.println("-----------");
      }
      for (int colonne = 0; colonne < TAILLE; colonne++) {
        if (colonne % 3 == 0 && colonne != 0) {
          System.out.print("|");
        }
        System.out.print(grille[ligne][colonne]);
      }
      System.out.println();
    }
  }


  private static boolean dansLigne(int[][] grille, int nombre, int ligne) { //verifier si le nombre existe dans la ligne
    for (int i = 0; i < TAILLE; i++) {
      if (grille[ligne][i] == nombre) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean dansColonne(int[][] grille, int nombre, int colonne) {  //verifier si le nombre existe dans la colonne
    for (int i = 0; i < TAILLE; i++) {
      if (grille[i][colonne] == nombre) {
        return true;
      }
    }
    return false;
  }
  
  private static boolean dansBox(int[][] grille, int nombre, int ligne, int colonne) { //verifier si le nombre existe dans la petite matrice 3*3
    int boxLigne = ligne - ligne % 3;            //pour trouver la ligne et
    int boxColonne = colonne - colonne % 3;      //la colonne de depart de la petite matrice (Box)
    
    for (int i = boxLigne; i < boxLigne + 3; i++) {
      for (int j = boxColonne; j < boxColonne + 3; j++) {
        if (grille[i][j] == nombre) {
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean emplacementValide(int[][] grille, int nombre, int ligne, int colonne) { //combiner les trois fonctions precedentes 
    return !dansLigne(grille, nombre, ligne) &&                                                  //pour verifier que l'emplacement est valide ou non
        !dansColonne(grille, nombre, colonne) &&
        !dansBox(grille, nombre, ligne, colonne);
  }
  
  private static boolean solution(int[][] grille) { //la fonction pour resoudre la grille sudoku
    for (int ligne = 0; ligne < TAILLE; ligne++) {                              //j'ai utilisé des for imbrique pour parcourir les cases
      for (int colonne = 0; colonne < TAILLE; colonne++) {                      //de la grille
        if (grille[ligne][colonne] == 0) {                                      //si la case est vide on teste recursivement si le nombre
          for (int nombreEssai = 1; nombreEssai <= TAILLE; nombreEssai++) {     //choisit par le program conduit a une solution correcte
            if (emplacementValide(grille, nombreEssai, ligne, colonne)) {       //de la grille sudoku
              grille[ligne][colonne] = nombreEssai;
              
              if (solution(grille)) {
                return true;
              }
              else {
                grille[ligne][colonne] = 0;
              }
            }
          }
          return false;
        }
      }
    }
    return true;
  }
  
  
  
}


