package Main_da_Ficha_5;


import Exer_1.Estatistica;
import Exer_2.Exer_2_Main;
import Exer_3.Vector_de_Bool;
import Exer_4.Exer_4_Ultima_Posicao;
import javax.swing.JOptionPane;

/**Contem o menu geral da ficha 5
 *Importamos das classes executorras
 * 
 * @see Estatistica
 * @see Exer_2_Main
 * @see  Vector_de_Bool
 * @see Exer_4_Ultima_Posicao
 * 
 * 
 * @author Marondo
 */
public class ClasseMain {

    public static void main(String[] args) {
        Estatistica ex1 = new Estatistica();
        Exer_2_Main ex2 = new Exer_2_Main();
        Vector_de_Bool ex3 = new Vector_de_Bool();
        boolean sim = true, sim2 = true;
            do {
                try {
                    switch (JOptionPane.showInputDialog("MENU DO TEMA 5\n"
                            + "\n1. Exer1 - Medidas de tendencia central"
                            + "\n2. Exer2 - Estudante, comparacao de medias"
                            + "\n3. Exer3 - Vector comparacao booleana"
                            + "\n4. Exer"
                            + "4 - Ultima posicao do vector"
                            + "\n0. Sair")) {
                        case "1": {
                           ex1.main(args);
                        }
                        break;
                        case "2": {
                           ex2.main(args);
                        }
                        break;
                        case "3": {
                           ex3.main(args);
                        }
                        break;
                        case "4": {
                            JOptionPane.showMessageDialog(null, "Ainda sem implementacao!");
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

    }
}
