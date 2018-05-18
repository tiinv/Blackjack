/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Korttipakan luonti ja sekoitus
 *
 * @author s1800302
 */
public class Pakka {

    private ArrayList<Kortti> cards;

    //luodaan kortit pakkaan:
    Pakka() {
        cards = new ArrayList<>();

        for (Kortti.Suit s : Kortti.Suit.values()) {
            for (Kortti.Rank r : Kortti.Rank.values()) {
                cards.add(new Kortti(r, s));
            }
        }

        //sekoitetaan pakka:
        Collections.shuffle(this.cards);

    }

    //nostetaan kortti ja poistetaan se pakasta:
    public Kortti nostaKortti() {
        
        if (cards.size() == 0) {
            System.out.println("Kortit loppuivat. Kiitos pelaamisesta :)");
            System.exit(0); //pakka on käytetty, ohjelma sulkeutuu
        }
        Kortti nostettu = cards.get(0);
        cards.remove(0);
        {
            return nostettu;
        } 
    }

}
