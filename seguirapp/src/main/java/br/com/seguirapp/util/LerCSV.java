package br.com.seguirapp.util;

import br.com.seguirapp.model.Localizacao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class LerCSV {
    public static void main(String[] args) {

        LerCSV obj = new LerCSV();
        obj.run();

    }
    public void run() {

        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        String arquivoCSV = "C:\\github\\IFS-WEB\\seguirapp\\src\\main\\java\\br\\com\\seguirapp\\util\\csv.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        try {
            Localizacao loc = new Localizacao();

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {

                String[] localizacao = linha.split(csvDivisor);

                loc.setHorario((Date.parse(localizacao[0])), formato);
                loc.setLatitude(localizacao[1]);
                loc.setLongitude(localizacao[2]);
                loc.setVelocidade(localizacao[3]);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
