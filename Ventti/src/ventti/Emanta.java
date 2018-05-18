/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

/**
 *
 * @author s1800302
 */
public class Emanta {

    int summa;

    public Emanta() {
        this.summa = 0;
    }

    //nostetaan kortti, näytetään sen arvo ja lisätään arvo emännän käteen
    public void emantaOtaKortti(Kortti nostettu) {
        int nostetunArvo = nostettu.getRank().getValue();

        //emäntä määrittelee ässän arvon summan perusteella:
        while (nostetunArvo == 14) {
            if (summa > 7) {
                nostetunArvo = 1;
            } else {
                break;
            }
        }

        summa = summa + nostetunArvo;

        System.out.println("Nostettu: " + nostettu + " | Korttien summa: " + summa);
    }

    //haetaan summa voittajan ratkaisemiseen
    public int emannanSumma() {
        return summa;
    }

    //summan nollaaminen uutta peliä varten
    public int resetSumma() {
        return this.summa = 0;
    }
}
