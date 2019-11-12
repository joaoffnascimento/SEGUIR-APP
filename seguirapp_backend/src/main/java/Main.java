import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        int aux = Integer.parseInt(JOptionPane.showInputDialog("Nº Primeiro arquivo"));
        int aux2 = Integer.parseInt(JOptionPane.showInputDialog("Nº Ultimo Arquivo"));
        int parada = aux2;
        String pasta = JOptionPane.showInputDialog("Pasta 1");
        String protocolo = JOptionPane.showInputDialog("Pasta 2");

        File file;
        File file2;

        int status = 0;
        do {
            file = new File("S:\\Siscart\\Programas\\Dig-doc\\Imagens\\DOC\\" + pasta + "\\" + protocolo + "." + aux);
            file2 = new File("S:\\Siscart\\Programas\\Dig-doc\\Imagens\\DOC\\" + pasta + "\\" + protocolo + "." + aux2);
            boolean success = file.renameTo(file2);

            status++;
            JOptionPane.showMessageDialog(null, status + "%");

            aux++;
            aux2++;
        } while (aux <= parada);


    }
}
