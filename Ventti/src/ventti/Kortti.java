/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

/**
 * Korttien luonti
 * @author s1800302
 */
public class Kortti {

    private Suit suit;
    private Rank rank;

    public enum Suit {
        PATA, HERTTA, RUUTU, RISTI 
    }

    public enum Rank {
        KAKSI(2), KOLME(3), NELJÄ(4), VIISI(5), KUUSI(6), SEITSEMÄN(7), KAHDEKSAN(8), YHDEKSÄN(9), KYMMENEN(10), JÄTKÄ(11), KUNINGATAR(12), KUNINGAS(13), ÄSSÄ(14);

        public final int value;

        Rank(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

    }

    Kortti(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    Rank getRank() {
        return rank;
    }

    Suit getSuit() {
        return suit;
    }

    public String toString() {
        return suit.name().toLowerCase() + rank.name().toLowerCase(); //enumit tapana nimetä CAPSILLA, vaihdetaan case 
    }
}
