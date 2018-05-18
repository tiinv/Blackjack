/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventti;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Pääohjelma
 *
 * @author s1800302
 */
public class Ventti {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //testing testing

        Scanner lukija = new Scanner(System.in);
        Pakka ventti = new Pakka();
        PelaajanKasi pelaaja = new PelaajanKasi();
        Emanta emanta = new Emanta();

        System.out.println("Pelataanko venttiä? Y aloittaa pelin.");
        String vastaus = lukija.nextLine();

        //muuttujat voittojen ja pelien tilastointiin:
        int voitot = 0;
        int pelit = 0;

        while (true) {
            //aloitetaan peli, jos vastaus on Y tai y:
            if (vastaus.equalsIgnoreCase("Y")) {

                pelaaja.otaKortti(ventti.nostaKortti());

                while (true) {
                    int pelaajanSumma = pelaaja.pelaajanSumma();

                    if (pelaajanSumma > 21) {
                        System.out.println("Hävisit pelin!");
                        break; //peli loppuu heti, jos summa on yli 21
                    }
                    
                    if (pelaajanSumma == 21) {
                        System.out.println("Ventti!");
                        break;
                    }

                    System.out.println("Nosta toinen? Y/N");
                    String uusiVastaus = lukija.nextLine();
                    if (uusiVastaus.equalsIgnoreCase("N")) {
                        System.out.println("Vuorosi loppui.");
                        pelaaja.pelaajanSumma();
                        break;
                    } else if (uusiVastaus.equalsIgnoreCase("Y")) {
                        pelaaja.otaKortti(ventti.nostaKortti());
                        pelaaja.pelaajanSumma();
                    } else {
                        System.out.println("Tunnistamaton vastaus. Vastaa Y tai N");
                        continue;
                    }
                }

                int pelaajanSumma = pelaaja.pelaajanSumma();

                //vuoro siirtyy, ellei pelaaja ole jo hävinnyt peliä
                if (pelaajanSumma <= 21) {
                    System.out.println("Vuoro siirtyy emännälle...");

                    while (true) {
                        int emannanSumma = emanta.emannanSumma();
                        if (emannanSumma == 21) {
                            break;
                        } else if (emannanSumma >= 18) { //emäntä ei nosta enempää kortteja, jos summa on 18 tai yli
                            break;
                        } else {
                            emanta.emantaOtaKortti(ventti.nostaKortti());
                        }
                    }

                    //Ratkaistaan voittaja: 
                    int emannanSumma = emanta.emannanSumma();

                    if (emannanSumma == 21) {
                        System.out.println("Emännän ventti, emäntä voittaa!");
                    } else if (pelaajanSumma == 21) {
                        System.out.println("Pelaajan ventti, pelaaja voittaa!");
                        voitot++;
                    } else if (pelaajanSumma == emannanSumma) {
                        System.out.println("Tasapeli!");
                    } else if (emannanSumma > 21) {
                        System.out.println("Voitat pelin summalla: " + pelaajanSumma);
                        voitot++;
                    } else if (pelaajanSumma < emannanSumma) {
                        System.out.println("Emäntä voittaa summalla " + emannanSumma);
                    } else {
                        System.out.println("Voitat summalla " + pelaajanSumma);
                        voitot++;
                    }

                }
                
                pelit++;

                //näytetään voitot & pelit, ja annetaan mahdollisuus aloittaa uusi peli:
                System.out.println("Voittoja: " + voitot + " Pelejä: " + pelit + "\nPelataanko uudestaan? Y/N");
                String uusiPeli = lukija.nextLine();

                if (uusiPeli.equalsIgnoreCase("N")) {
                    System.out.println("Kiitos ja näkemiin :)");
                    break;
                } else {
                    pelaaja.resetSumma(); // nollataan molempien pelaajien korttien summa.
                    emanta.resetSumma();
                }

            } else {
                System.out.println("Ei sitten pelata.");
                break;
            }

        }
    }
}
