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
    
    
    
    
    public void otaKortti(Kortti kortti){
        kortit.add(kortti);
    }
    public int selvitaSumma(){
        int pelajansumma = 0;
        
        if(kortit.size() == 0){
            System.out.println("Pelajalla ei ole vielä korteja, ota kortti!"); 
        }
        else{
            for (Kortti kortti : kortit) {
                int kortinArvo = kortti.getArvo();
                if (kortinArvo > 1 && kortinArvo <= 10){
                    pelajansumma =+ kortinArvo;
                }else if(kortinArvo >= 11 && kortinArvo <= 13){
                    pelajansumma =+10;
                }else{
                    pelajansumma =+11;
                }
            }
            
            if (pelajansumma > 21){
                pelajansumma =-10;
            }
        }
        
        return pelajansumma; 
    }
    //metodi joka tarkista onko kätenä blackjack
    public boolean onkoBlackjack () {
        boolean onkoBlackjack = false;
        if (kortit.size() == 2) {
            int kortin1Arvo = kortit.get(0).getArvo();
            int kortin2Arvo = kortit.get(1).getArvo();
            boolean tarkastusEhto = (kortin1Arvo == 1 && (kortin2Arvo >= 10 && kortin2Arvo <= 13)) || 
                                    (kortin2Arvo == 1 && (kortin1Arvo >= 10 && kortin1Arvo <= 13));
            if(tarkastusEhto){
                onkoBlackjack = true;
            }
        }
        return onkoBlackjack; 
    }
}
