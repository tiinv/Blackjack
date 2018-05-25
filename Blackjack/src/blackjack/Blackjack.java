/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author s1800453
 */
public class Blackjack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Korttipakka testipakka = new Korttipakka();
        PelaajanKasi pelaaja = new PelaajanKasi();
        PelaajanKasi tietokone = new PelaajanKasi();

        testipakka.sekoitaPakka();

        pelaaja.otaKortti(testipakka.jaaKortti());
        pelaaja.otaKortti(testipakka.jaaKortti());
        pelaaja.tarkistaAssat();
        pelaaja.selvitaSumma();
        System.out.println(pelaaja.summa);
        pelaaja.onkoBlackjack();

        while (true) {

            if (pelaaja.summa > 21) {
                System.out.println(pelaaja.summa + " Hävisit pelin!");
                break; //pelaaja häviää samantien, peli päättyy.
            }

            System.out.println("Summa: " + pelaaja.summa + " Nosta kortti? Y/N");
            String vastaus = lukija.nextLine();
            if (vastaus.equalsIgnoreCase("Y")) {
                pelaaja.otaKortti(testipakka.jaaKortti());
                pelaaja.selvitaSumma();
            } else if (vastaus.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Tunnistamaton vastaus. Kirjoita Y tai N.");
            }
        }
        if (pelaaja.summa <= 21) {
            System.out.println("Summa: " + pelaaja.summa);
            System.out.println("Vuoro siirtyy...");

            tietokone.otaKortti(testipakka.jaaKortti());
            tietokone.otaKortti(testipakka.jaaKortti());
            tietokone.selvitaSumma();
            tietokone.onkoBlackjack();

            while (true) {
                if (tietokone.summa >= 21) {
                    break;
                } else if (tietokone.summa < 15) {
                    tietokone.otaKortti(testipakka.jaaKortti());
                    tietokone.selvitaSumma();
                } else {
                    System.out.println("Jakajan summa: " + tietokone.summa);
                    break;
                }

            }

            // Ratkaistaan voittaja:
            if (tietokone.summa == 21 && pelaaja.summa == 21) {
                System.out.println("Tasapeli!");
            } else if (pelaaja.summa != 21 && tietokone.summa == 21) {
                System.out.println("Blackjack, tietokone voittaa!");
            } else if (pelaaja.summa == 21 && tietokone.summa != 21) {
                System.out.println("Blackjack, voitit!");
            } else if (pelaaja.summa < 21 && tietokone.summa > 21) {
                System.out.println("Voitit!");
            } else if (pelaaja.summa > tietokone.summa) {
                System.out.println("Voitit!");
            } else {
                System.out.println("Hävisit pelin!");
            }

        }
    }
}
