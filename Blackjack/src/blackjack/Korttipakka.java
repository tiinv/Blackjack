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

    //toistaiseksi kierrätyskoodia Ventistä:
    private ArrayList<Kortti> kortit;

    //luodaan kortit pakkaan:
    Korttipakka() {

        kortit = new ArrayList<>();

        for (Kortti.Suit s : Kortti.Suit.values()) {
            for (Kortti.Rank r : Kortti.Rank.values()) {
                kortit.add(new Kortti(r, s));
            }
        }
    }

    //sekoitetaan pakka:
    public void sekoitaPakka() {
        Collections.shuffle(this.kortit);
    }

    //nostetaan kortti ja poistetaan se pakasta:
    public Kortti nostaKortti() {
        Kortti nostettu = kortit.get(0);
        kortit.remove(0);
        {
            return nostettu;
        }
    }
}
