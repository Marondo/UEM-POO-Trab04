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
public class Exer_2_Main {

    Vector<Estudante> vectorEst = new Vector<>();
    Estudante est;

    private void addEst() {
        est = new Estudante();
        String nome = JOptionPane.showInputDialog("Nome do estudante:");
        if (nome != null) {
            try {
                est.setNome(nome);
                int i = 0;
                while (i < 3) {
                    double nota = est.addNotas((i + 1));
                    if (nota != -1) {
                        est.notas[i] = nota;
                        i++;
                    }
                }
                
                if (i == 3) {
                    est.setMedia(est.media(est.notas));
                    vectorEst.add(est);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Err: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nao inserido! Nome invalido.");
        }
    }

    public double mediaGeral() {
        int soma = 0;
        if (vectorEst
                != null) {
            for (Estudante e : vectorEst) {
                soma += e.getMedia();
            }
            return soma / vectorEst.size();
        }
        return -1;
    }

    private String melhor() {
        double dir = 0, maior = vectorEst.get(0).getMedia(), i = 0;
        for (Estudante e : vectorEst) {
            dir = e.getMedia();
            if (maior < dir && i != 0) {
                maior = dir;
            }
            i++;
        }
        i = 0;
        String bons = "", aux = "MELHOR";
        for (Estudante e : vectorEst) {
            if (e.getMedia() == maior) {
                bons += e.toString() + "\n";
                i++;
            }
        }
        if (i > 1) {
            aux = "MELHORS";
        }
        return aux + "\n" + bons;
    }

    public static void main(String[] args) {
        Exer_2_Main e = new Exer_2_Main();
        boolean sim = true, sim2 = true;
        sim = true;
        do {
            try {
                switch (JOptionPane.showInputDialog("O QUE DESEJA FAZER?"
                        + "\n1. Cadastrar Estudantes\n2. Ver Media geral da turma"
                        + "\n3. A melhor media da turma\n0. Sair")) {
                    case "1": {
                        e.addEst();
                    }
                    break;
                    case "2": {
                        JOptionPane.showMessageDialog(null, "Media geral = " + e.mediaGeral());
                    }
                    break;
                    case "3": {
                        JOptionPane.showMessageDialog(null, "Media geral = " + e.melhor());
                    }
                    break;
                    case "0": {
                        sim = false;
                    }
                    break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcao invalida!");
                }

            } catch (Exception ex) {
            }
        } while (sim);
    }
}
