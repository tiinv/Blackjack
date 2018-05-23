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
    int maara;

    //luodaan kortit pakkaan:
    Korttipakka(int maara) {
        this.maara = maara;

        int i = 0;
        while (i <= maara) {
            kortit = new ArrayList<>();

            for (Kortti.Suit s : Kortti.Suit.values()) {
                for (Kortti.Rank r : Kortti.Rank.values()) {
                    kortit.add(new Kortti(r, s));
                }
            }
            i++;
        }
    }

    //sekoitetaan pakka:
    public void sekoitaPakka() {
        Collections.shuffle(this.kortit);
    }

    //nostetaan kortti ja poistetaan se pakasta:
    public Kortti jaaKortti() {
        Kortti nostettu = kortit.get(0);
        kortit.remove(0);
        {
            return nostettu;
        }
    }

    @Override
    public String toString() {
        String result = kortit.size() + " cards:" + System.lineSeparator();
        for (Kortti card : kortit) {
            result = result.concat(card + System.lineSeparator());
        }

        return result;
    }
}
