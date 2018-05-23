/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;

/**
 *
 * @author s1800302
 */
public class PelaajanKasi {

    int summa;
    int nostetunArvo = 0;

    private ArrayList<Kortti> kortit;

    public PelaajanKasi() {
        this.summa = 0;
    }

    public void otaKortti(Kortti nostettu) {
        kortit.add(nostettu);
        int nostetunArvo = nostettu.getRank().getValue();

    }

    public void selvitaSumma() {

        if (nostetunArvo == 14) {
            summa = summa + 11;
        } else if (nostetunArvo >= 2 || nostetunArvo <= 10) {
            summa = summa + nostetunArvo;
        } else {
            summa = summa + 10;
        }

        if (summa == 21) {
            summa = summa - 10;
        }
    }

    public int pelaajanSumma;

    {
        this.summa = pelaajanSumma;
    }

    public boolean onkoBlackjack;

    public void onkoBlackjack() {

        if (kortit.contains("jätkä") || kortit.contains("kuningatar") || kortit.contains("kuningas") && kortit.contains("ässä")) {
            boolean onkoBlackjack = true;
            System.out.println("Blackjack!");
        }
    }

}
