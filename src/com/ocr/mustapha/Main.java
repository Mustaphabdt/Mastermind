package com.ocr.mustapha;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static int generateRandomIntIntRange(int b, int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }




    static String getAlphaNumericString(int n)
    {

        // chose a Character random from this String
        String AlphaNumericString = "0123456789";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }// la méthode ci dessus permet de générer un string aléatoire de la longeur que l'on veut.


    public static void main(String[] args) {

        String solution = null, proposition = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Attaquant : Veuillez entrer une combinaison de chiffres !");
        solution = sc.nextLine();
        System.out.println("la combinaison secrete : " + solution);
        int chance = 10;
        boolean gagner = false;

        System.out.println(" Défenseur: Vous avez  " + chance + "chances  pour trouver la combinaison de " + solution.length() + " chiffres c'est à vous !");

        proposition = getAlphaNumericString(solution.length());  // proposition est défini par l'ordinateur .
        //System.out.println(proposition);
        while (chance >= 0 && gagner == false) {
            chance--;




            System.out.println("Faites une proposition il vous reste " + chance + " chances");  //
            if (proposition.length() != solution.length()) {
                System.out.println(" Votre proposition ne comporte pas le même nombre que dans la solution veuillez recommancer");
                // Si Longueur  de la solution n'est pas respecter
            }
            String prochaineProposition = "";
            System.out.println(proposition);
            for (int i = 0; i < solution.length(); i++) {
                if (Character.getNumericValue(solution.charAt(i)) == Character.getNumericValue(proposition.charAt(i))) {// recupère la valeur charAt(i)
                    // string en in correspondant a la valeur du tableau ASCII getNumericValue permet de le convertir dans le tableau  ASCII
                    System.out.print("=");
                    prochaineProposition = prochaineProposition + Character.getNumericValue(proposition.charAt(i));

                }
                if (Character.getNumericValue(solution.charAt(i)) > Character.getNumericValue(proposition.charAt(i))) {
                    System.out.print("+");
                    //System.out.print(Character.getNumericValue(proposition.charAt(i)));
                    char a = proposition.charAt(i);
                    int j = Character.getNumericValue(a);
                    prochaineProposition = prochaineProposition + generateRandomIntIntRange(j, j, 9);// generation d'un nombre aléatoire pour la prochaine position qui est superieur non egale a la valeur presedente

                }
                if (Character.getNumericValue(solution.charAt(i)) < Character.getNumericValue(proposition.charAt(i))) {
                    System.out.print("-");
                    char a = proposition.charAt(i);
                    int j = Character.getNumericValue(a);
                    prochaineProposition = prochaineProposition + generateRandomIntIntRange(j, 0, j); // generation d'un nombre aléatoire pour la prochaine position qui est inferieur non egale a la valeur presedente
                }

            }

            System.out.println();


            if (proposition.equals(solution)) {
                gagner = true;
                System.out.println(" Vous avez trouvé la solution en " + (10 - chance) + " essais ");


            } else {
                proposition = prochaineProposition;
            }

            if (chance == 0) {
                System.out.println("Vous n'avez plus de chance!");
            }


        }
    }
}
// améliorer}