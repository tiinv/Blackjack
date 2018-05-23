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
        Korttipakka testipakka = new Korttipakka(1);
        PelaajanKasi pelaaja = new PelaajanKasi();
        testipakka.sekoitaPakka();
        pelaaja.otaKortti(testipakka.jaaKortti());
        pelaaja.otaKortti(testipakka.jaaKortti());
        pelaaja.selvitaSumma();
        pelaaja.onkoBlackjack();

        while (pelaaja.pelaajanSumma < 21) {
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

    }

}
