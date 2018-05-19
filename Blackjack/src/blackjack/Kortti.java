/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author s1800453
 */
public class Kortti {
    
    private int arvo; 
    private String maa;
    
    //kääntä suomeksi
    private final String[] MAA = { "hearts", "spades", "diamonds", "clubs" };
    public final int[] ARVO = { 2, 3, 4, 5, 6, 7,
                                      8, 9, 10, 11, 12,13, 14 };

     Kortti (String maa, int arvo) {
        this.maa = maa;
        this.arvo = arvo;
    }
    
    public int getArvo() {
        return arvo;
    }
    public void setArvo(int arvo) {
        this.arvo = arvo;
    }
    
    public String getMaa() {
        return maa;
    }
    public void setMaa(String maa) {
         this.maa = maa;
    }
    
    public String toString() {
        return this.getMaa().toLowerCase() +", "+ this.getArvo();
    }
}
