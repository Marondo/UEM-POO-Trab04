/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exer_4;

/**
 *
 * @author Marondo
 */
public class Exer_4_Ultima_Posicao {

    public static void main(String[] args) {
        String tx = "*";
        for (int i = 1; i < 2; i++) {
            tx +=tx;
            System.out.println( tx);
            i--;
        }
    }
}
