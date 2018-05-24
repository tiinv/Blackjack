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

        int pelaajanSumma = pelaaja.pelaajanSumma;
        int tietokoneenSumma = tietokone.pelaajanSumma;
        
        testipakka.sekoitaPakka();
        pelaaja.otaKortti(testipakka.jaaKortti());
        pelaaja.otaKortti(testipakka.jaaKortti());
        pelaaja.selvitaSumma();
        // pelaaja.onkoBlackjack();

        while (pelaajanSumma <= 21) {
            System.out.println("Nosta kortti? Y/N");
            String vastaus = lukija.nextLine();
            if (vastaus.equalsIgnoreCase("Y")) {
                pelaaja.otaKortti(testipakka.jaaKortti());
                break;
            } else if (vastaus.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Tunnistamaton vastaus. Kirjoita Y tai N.");
            }

        }

        System.out.println("Summa: " + pelaajanSumma);
        System.out.println("Vuoro siirtyy...");

        while (tietokoneenSumma <= 21) {
            if (tietokoneenSumma < 15) {
                tietokone.otaKortti(testipakka.jaaKortti());
            } else {
                break;
            }

        }

        // Ratkaistaan voittaja:
        if (tietokoneenSumma == 21 && pelaajanSumma == 21) {
            System.out.println("Tasapeli!");
        } else if (pelaajanSumma != 21 && tietokoneenSumma == 21) {
            System.out.println("Blackjack, tietokone voittaa!");
        } else if (pelaajanSumma == 21 && tietokoneenSumma != 21) {
            System.out.println("Blackjack, voitit!");
        } else if (pelaajanSumma > 21 && tietokoneenSumma < 21) {
            System.out.println("Tietokone voittaa!");
        } else if (pelaajanSumma < 21 && tietokoneenSumma > 21) {
            System.out.println("Voitit!");
        } else if (pelaajanSumma > tietokoneenSumma) {
            System.out.println("Voitit!");
        } else {
            System.out.println("Hävisit pelin!");
        }

    }

}
