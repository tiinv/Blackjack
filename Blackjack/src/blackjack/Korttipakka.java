/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Korttipakan luonti ja sekoitus
 *
 * @author s1800302
 */
public class Korttipakka {

    private final ArrayList<Kortti> kortit;

    Korttipakka() {
        kortit = new ArrayList<>();

        for (String maa : Kortti.MAA) {
            for (int arvo : Kortti.ARVO) {
                kortit.add(new Kortti(maa, arvo));
            }
        }
    }

    public void sekoitaPakka() {
        Collections.shuffle(this.kortit);

    }

    public Kortti jaaKortti() {

        if (kortit.size() == 0) {
            System.out.println("Kortit loppuivat!");
            System.exit(0); //pakka on käytetty, ohjelma sulkeutuu
        }
        Kortti nostettu = kortit.get(0);
        kortit.remove(0);
        {
            return nostettu;
        }
    }

}