package Exercice2;

import java.util.Scanner;

public class Main 
{
    static int saisie()
    {   
        //Controle de saisie, pour obliger l'utilisateur de donner soit 1 ou 0
        Scanner clavier = new Scanner(System.in);
        int x;
        do{
            System.out.print("Entrer 0 pour Non et 1 pour Oui : ");
            x = clavier.nextInt();
        }while(x < 0 || x > 1);
        return x;
    }
    static public void main(String[] args) 
    {
        String reponse = "";
        Set S1 = new Set(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31);
        Set S2 = new Set(2, 3, 6, 7, 10, 11, 14, 15, 18, 19, 22, 23, 26, 27, 30, 31);
        Set S3 = new Set(4, 5, 6, 7, 12, 13, 14, 15, 20, 21, 22, 23, 28, 29, 30, 31);
        Set S4 = new Set(8, 9, 10, 11, 12, 13, 14, 15, 24, 25, 26, 27, 28, 29, 30, 31);
        Set S5 = new Set(16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31);
        //Accepter la saisie de l'utilisateur et l'affecter au variable reponse 
        System.out.println("Le jour de naissance est dans Set 1?");
        S1.afficheSet();
        int r1 = saisie();
        reponse += r1;
        System.out.println("Le jour de naissance est dans Set 2?");
        S2.afficheSet();
        int r2 = saisie();
        reponse += r2;
        System.out.println("Le jour de naissance est dans Set 3?");
        S3.afficheSet();
        int r3 = saisie();
        reponse += r3;
        System.out.println("Le jour de naissance est dans Set 4?");
        S4.afficheSet();
        int r4 = saisie();
        reponse += r4;
        System.out.println("Le jour de naissance est dans Set 5?");
        S5.afficheSet();
        int r5 = saisie();
        reponse += r5;
        //separer chaque numero du string reponse en un int
        int binaire1 = Integer.parseInt(String.valueOf(reponse.charAt(0)));
        int binaire2 = Integer.parseInt(String.valueOf(reponse.charAt(1)));
        int binaire3 = Integer.parseInt(String.valueOf(reponse.charAt(2)));
        int binaire4 = Integer.parseInt(String.valueOf(reponse.charAt(3)));
        int binaire5 = Integer.parseInt(String.valueOf(reponse.charAt(4)));
        //convertir le resultat trouvé en un nombre decimale
        double dec = binaire1*Math.pow(2,0) + binaire2*Math.pow(2,1) + binaire3*Math.pow(2,2) + binaire4*Math.pow(2,3) + binaire5*Math.pow(2,4);
        int dec1 = (int) dec;
        System.out.println("Ton jour de naissance est le : " + dec1);
    }
}
