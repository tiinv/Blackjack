/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

import java.util.Scanner;

/**
 * Pelaajan käsi, eli nostetut kortit ja niiden summa
 *
 * @author s1800302
 */
public class PelaajanKasi {

    //pelaajan käsi -luokka
    //wiffkefihwefifj
    Scanner assanArvo = new Scanner(System.in);

    int summa;

    public PelaajanKasi() {
        this.summa = 0;
    }

    //nostetaan kortti, näytetään sen arvo ja lisätään arvo pelaajan käteen
    public void otaKortti(Kortti nostettu) {
        int nostetunArvo = nostettu.getRank().getValue();

        //annetaan pelaajan määritellä ässän arvo:
        while (nostetunArvo == 14) {
            System.out.println(nostettu + " - valitse ässän arvoksi 1 tai 14.");
            String assa = assanArvo.nextLine();
            if (assa.equals("1")) {
                nostetunArvo = 1;
            } else if (assa.equals("14")) {
                break; //arvona pysyy 14, katkaistaan looppi
            } else {
                System.out.println("Tunnistamaton vastaus. Kokeile uudestaan:");
            }
        }

        summa = summa + nostetunArvo;

        System.out.println("Nostettu: " + nostettu + " | Korttien summa: " + summa);
    }

    //haetaan summa voittajan ratkaisemiseen
    public int pelaajanSumma() {
        return summa;
    }

    //summan nollaaminen uutta peliä varten
    public int resetSumma() {
        return this.summa = 0;
    }
}
