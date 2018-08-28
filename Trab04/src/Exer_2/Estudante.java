/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exer_2;

import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author Marondo
 */
public class Estudante {

    String nome;
    public double[] notas = new double[3];
    double media;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getNotas() {
        return notas;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    /**
     * Retorna a media aritmetica dos elementos de um vector dado.
     *
     * @param notas
     * @return
     */
    public double media(double[] a) {
        int soma = 0;
        if (notas != null) {
            for (int i = 0; i < a.length; i++) {
                soma += a[i];
            }
            return soma / a.length;
        }
        return -1;
    }

    public double addNotas(int i) {
        try {
            double nota = Double.parseDouble(
                    JOptionPane.showInputDialog("Digite a " + i + "° nota!"));
            if (nota >= 0 && nota <= 20) {
                return nota;
            } else {
                JOptionPane.showMessageDialog(null, "Nota fora de limites. [0-20]!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro de digitacao!");
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Estudante: " + nome + " | Media: " + media + '}';
    }

}
