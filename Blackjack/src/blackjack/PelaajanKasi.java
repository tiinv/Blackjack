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
    int summa = 0;
    int assat = 0;

    public PelaajanKasi() {
        this.kortit = new ArrayList<Kortti>();
        this.summa = summa;
    }

    public void otaKortti(Kortti kortti) {
        kortit.add(kortti);
        System.out.println("Nostettu: " + kortti);

        if (kortti.getArvo() == 14) {
            assat++;
        }
    }

    public void tarkistaAssat() {
        if (assat == 2) {
            summa = 11;
        }
    }

    public int selvitaSumma() {

        if (kortit.size() == 0) {
            System.out.println("Pelaajalla ei ole vielä kortteja, ota kortti!");
        } else {
            summa = 0;
            for (Kortti kortti : kortit) {
                int kortinArvo = kortti.getArvo();

                if (kortinArvo > 1 && kortinArvo <= 10) {
                    summa = summa + kortinArvo;
                } else if (kortinArvo >= 11 && kortinArvo <= 13) {
                    summa = summa + 10;
                } else {
                    summa = summa + 11;
                }
                if (kortinArvo == 14 && summa > 21) {
                    summa = summa - 10;
                }
            }

        }

        return summa;
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
