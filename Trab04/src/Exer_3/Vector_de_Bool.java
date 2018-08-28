/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exer_3;

import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Marondo
 */
public class Vector_de_Bool {

    public static Boolean geraVector() {
        boolean v = false;
        if ((1 + (int) (Math.random() * 2)) == 1) {
            return true;
        }
        return v;
    }

    public static int geraTamanho() {
        return (2 + (int) (Math.random() * 16));
    }

    public static String comparaVectore(Vector v1, Vector v2) {
        if (v1 != null && v2 != null) {
            if (v1.size() == v2.size()) {
                int i = 0;
                String resp = "";
                for (Object o : v1) {
                    if (o == v2.elementAt(i)) {
                        resp = "VETORES IDENTICOS\n\nPela disposicao e  pelo tamanho: Vet1.lenght = " + v1.size() + ""
                                + "| Vet2.lenght = " + v2.size();
                    } else {
                        return "VETORES NAO IDENTICOS\nPela disposicao dos elementos.";
                    }
                    i++;
                }
                return resp;
            } else {
                return "DIFEREM NO TAMANHO\nVect1" + v1.size() + " | Vect2" + v2.size();
            }
        }
        return "Vazio";
    }

    /**
     * Main da classe.
     *
     * @param args
     */
    public static void main(String[] args) {
        Vector<Boolean> v1;
        Vector<Boolean> v2;
        // JOptionPane.showMessageDialog(null, "FREQUENCIAS\n" + v + "" + moda(v));
        boolean sim = true, sim2 = true;
        do {
            v1 = new Vector<>();
            v2 = new Vector<>();
            int tam = geraTamanho();
            for (int i = 0; i < tam; i++) {
                v1.add(geraVector());
            }
            tam = geraTamanho();
            for (int i = 0; i < tam; i++) {
                v2.add(geraVector());
            }

            String vet = "VECTORES GERADOS\n\nVect1: " + v1 + "\nVect2: " + v2 + "\n\n";
            sim = true;
            sim2 = true;
            do {
                try {
                    switch (JOptionPane.showInputDialog(vet + ""
                            + "MENU?\n1. Comparar\n2. "
                            + "Novo vector\n0. Sair")) {
                        case "1": {
                            JOptionPane.showMessageDialog(null, vet + comparaVectore(v1, v2));
                        }
                        break;
                        case "2": {
                            sim = false;
                        }
                        break;
                        case "0": {
                            sim = false;
                            sim2 = false;
                        }
                        break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opcao invalida!");
                    }

                } catch (Exception e) {
                }
            } while (sim);
        } while (sim2);
    }
}
