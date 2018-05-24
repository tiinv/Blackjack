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

    private ArrayList<Kortti> kortit;
    int pelaajanSumma = 0;

    public PelaajanKasi() {
        this.kortit = new ArrayList<Kortti>();
    }

    public void otaKortti(Kortti kortti) {
        kortit.add(kortti);
    }

    public int selvitaSumma() {

        if (kortit.size() == 0) {
            System.out.println("Pelajalla ei ole vielä korteja, ota kortti!");
        } else {
            for (Kortti kortti : kortit) {
                int kortinArvo = kortti.getArvo();
                if (kortinArvo > 1 && kortinArvo <= 10) {
                    pelaajanSumma =+ kortinArvo;
                } else if (kortinArvo >= 11 && kortinArvo <= 13) {
                    pelaajanSumma =+ 10;
                } else {
                    pelaajanSumma =+ 11;
                }
            }

            if (pelaajanSumma > 21) {
                pelaajanSumma = -10;
            }
        }

        return pelaajanSumma;
    }
    
    public int naytaSumma() {
        return pelaajanSumma;
    }

    //metodi joka tarkista onko kätenä blackjack
    public boolean onkoBlackjack() {
        boolean onkoBlackjack = false;
        if (kortit.size() == 2) {
            int kortin1Arvo = kortit.get(0).getArvo();
            int kortin2Arvo = kortit.get(1).getArvo();
            boolean tarkastusEhto = (kortin1Arvo == 1 && (kortin2Arvo >= 10 && kortin2Arvo <= 13))
                    || (kortin2Arvo == 1 && (kortin1Arvo >= 10 && kortin1Arvo <= 13));
            if (tarkastusEhto) {
                onkoBlackjack = true;
            }
        }
        return onkoBlackjack;
    }
}
