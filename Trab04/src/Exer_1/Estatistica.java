/**
 *Pacote para exercicio estatistico,
 * Medidas de tendencia central
 */
package Exer_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 * Classe unica de calculos estatisticos
 *
 * @author Marondo
 */
public class Estatistica {

    /**
     * Retorna a mediana de um vector
     *
     * @param v
     * @return
     */
    public static String mediana(Vector<Integer> v) {
        if (v != null) {
            int c1 = v.size() / 2, c2 = (v.size() + 1) / 2;//c=centro
            if (v.size() % 2 == 1) {
                return "Mediana = " + v.elementAt(c2);
            } else {
                return "Mediana = " + v.elementAt((c1 + c2) / 2);
            }
        }
        return "-1";
    }

    /**
     * Retorna a media aritmetica dos elementos de um vector dado.
     *
     * @param v
     * @return
     */
    public static String media(Vector<Integer> v) {
        int media = 0;
        if (v != null) {
            for (Integer i : v) {
                media += i;
            }
            media = media / v.size();
            return "Media = " + media;
        }
        return "-1";
    }

    /**
     * Identifica o tipo de moda
     *
     * @param v, vector
     * @return
     */
    public static String moda(Vector<Integer> v) {
        if (v != null) {
            int i = 0, j = 1, k = 0, e = 1;
            int esq = v.elementAt(0);
            String[] modaStr = new String[v.size()];
            /**
             * Token permite contar o numero de vezes que se repete um valor
             */
            String txt = "", token = ";", tipo = "", nr = "", mod = "0";
            int leng = 1;

            for (Integer dir : v) {
                /**
                 * Percore o vetor extraindo repeticoe
                 */
                if (esq == dir && k != 0) {
                    txt = txt + token + dir;
                    /**
                     * Acumula valores semelhantes
                     */
                    modaStr[i] = txt;
                    j++;
                    /**
                     * Controla o avanco das iteracoe
                     */
                } else {
                    e++;
                    if (j != 1) {
                        i++;
                        /**
                         * avanca o i
                         */
                        j = 1;
                    }
                    txt = "";
                    txt = txt + dir;
                }
                esq = dir;
                k = 1;
                leng++;
            }
            txt = "";
            if (e == leng) {
                return "TIPO:  AMODAL";
            }
            leng = 1;
            /**
             * Eh uma auxiliar que armazena valores repetidos
             */
            Vector<String> v_aux = new Vector();
            for (i = 0; i < modaStr.length; i++) {
                if (modaStr[i] != null) {
                    v_aux.add(modaStr[i]);
                }
            }
            /**
             * Redefinindo o tamanho do array anterior Para guardar elementos
             * repetidos
             */
            modaStr = new String[v_aux.size()];
            /**
             * moadInt para guardar n repeticoes elementos repetidos
             */
            int[] modaInt = new int[v_aux.size()];
            nr = "";
            k = 0;
            /**
             * Extracao e separacao dos valores repetidos e o n_vezes suas
             * frequencias
             */
            for (String s : v_aux) {
                j = 0;
                for (i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (c == ';') {
                        leng++;
                        j = 1;
                    } else {
                        if (j == 0) {
                            nr += "" + c;
                        }
                    }
                }
                modaInt[k] = leng;
                modaStr[k] = nr;
                nr = "";
                leng = 1;
                k++;
            }
            /**
             * maior moda
             */
            int maior = modaInt[0];
            int dir = 0, bimod = 1;
            k = 0;
            /**
             * Identicica o tipo de moda
             */
            for (i = 0; i < modaStr.length; i++) {
                dir = modaInt[i];
                // JOptionPane.showMessageDialog(null, "k"+k+ " bi(" + bimod + ") m: " + maior + " (1) dir: " + dir);
                if (maior < dir && i != 0) {
                    maior = dir;
                    k = i;
                    bimod = 1;
                } else if (maior == dir && i != 0) {
                    bimod++;
                }
            }
            if (bimod == 1) {
                mod = modaStr[k] + "  = TIPO:  UNIMODAL - frequencias = " + modaInt[k];
            } else if (bimod == 2) {
                mod = "TIPO:  BIMODAL";
            } else if (bimod == 3) {
                mod = "TIPO:  TRIMODAL";
            } else {
                mod = "TIPO:  MULTIMODAL";
            }
            for (i = 0; i < modaStr.length; i++) {
                txt += modaStr[i] + " - frequencias = " + modaInt[i] + "\n";
            }
            txt += mod;
            return "_____Modas_____\n" + txt;
            //   return modaStr[k];
        }

        return "Vazio";
    }

    static int maior = 0, i = 0, pos = 0;
    static Vector<Integer> aux = new Vector<>();

    public static Vector acumulos(Vector<Integer> v) {
        maior = 0;
        for (Integer a : v) {
            for (Integer b : v) {
                if (a == b) {
                    aux.add(a);
                }
            }
        }
        return aux;
    }

    public static String modas(Vector<Integer> v) {
        int cont = 0;
        String txt = ".";
        if (v.size() > 0) {
            Vector<Integer> n = new Vector<>(), t = new Vector<>();
            for (Integer a : v) {
                for (Integer b : v) {
                    if (a == b) {
                        cont++;
                    }
                }
                t.add(a);
                n.add(cont);
                if (cont > maior) {
                    maior = cont;
                    pos = i;
                }
                i++;
                cont = 0;
            }

            cont = 1;
            i = 0;
            for (Integer a : n) {
                if (maior > a) {
                    txt = "[MODAL: " + v.elementAt(pos) + " - Repeticoe: " + maior + "]";
                    cont = 1;
                } else if (maior == a) {
                    cont++;
                    txt += "Elemento: " + t.elementAt(i) + " - Repeticoe: " + n.elementAt(i) + "\n";
                }
                i++;
            }
            if (cont == 1) {
                return txt;
            } else if (cont == 2) {
                return "BIMODAL\n" + txt;
            } else if (cont == 3) {
                return "TRIMODAL\n" + txt;
            } else {
                return "MULTIMODAL\n" + txt;
            }
        } else {
            return "Tipo: Amodal!";
        }
    }

    public static int geraInt() {
        return (15 + (int) (Math.random() * 2));
    }

    public static Vector geraV() {
        Vector<Integer> v = new Vector<>();
        int m = geraInt();
        for (int i = 0; i < m; i++) {
            v.add((17 + (int) (Math.random() * 75)));
        }
        Collections.sort(v);
        return v;
    }

    /**
     * Main da classe.
     *
     * @param args
     */
    public static void main(String[] args) {

        // JOptionPane.showMessageDialog(null, "FREQUENCIAS\n" + v + "" + moda(v));
        boolean sim = true, sim2 = true;
        do {
            Vector<Integer> v = geraV();
            String vet = "VECTOR\n" + v + "\n\n";
            sim = true;
            sim2 = true;
            do {
                try {
                    switch (JOptionPane.showInputDialog(vet + ""
                            + "O QUE DESEJA VER?\n1. Media\n2. "
                            + "Mediana\n3. Moda\n4. Novo vector\n0. Sair")) {
                        case "1": {
                            JOptionPane.showMessageDialog(null, vet + media(v));
                        }
                        break;
                        case "2": {
                            JOptionPane.showMessageDialog(null, vet + mediana(v));
                        }
                        break;
                        case "3": {
                            JOptionPane.showMessageDialog(null, vet + moda(v));
                           // JOptionPane.showMessageDialog(null, vet + modas(acumulos(v)));
                        }
                        break;
                        case "0": {
                            sim = false;
                            sim2 = false;
                        }
                        break;
                        case "4": {
                            sim = false;
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
