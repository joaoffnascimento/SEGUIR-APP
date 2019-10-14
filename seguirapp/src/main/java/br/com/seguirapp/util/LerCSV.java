package br.com.seguirapp.util;

import br.com.seguirapp.controller.LocalizacaoController;
import br.com.seguirapp.model.Localizacao;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.logging.Logger;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

public class LerCSV {

    public Date converter(String data) {
        java.sql.Date sql = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            java.util.Date parsed = format.parse(data);
            sql = new java.sql.Date(parsed.getTime());

        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return sql;
    }

    //API PARA CONSUMIR O REST E INSERIR AS POSICOES

    public static void main(String[] args) throws Exception {

        LerCSV obj = new LerCSV();
        obj.run();

    }

    public JSONObject run() throws Exception {

        String arquivoCSV = "C:\\github\\IFS-WEB\\seguirapp\\src\\main\\java\\br\\com\\seguirapp\\util\\csv.csv";
        BufferedReader br = null;
        String linha = "";
        String csvDivisor = ";";
        LerCSV ler = new LerCSV();
        try {
            JSONObject loc = new JSONObject();

            br = new BufferedReader(new FileReader(arquivoCSV));
            while ((linha = br.readLine()) != null) {

                String[] localizacao = linha.split(csvDivisor);
                loc.put("latitude", (localizacao[0]));
                loc.put("longitude", ((localizacao[1])));
                loc.put("velocidade", ((localizacao[2])));
                String horario = localizacao[3];
                System.out.println(horario);
                loc.put("horario", horario);
                System.out.println(loc);
                Localizacao lac = new Localizacao(localizacao[0], localizacao[1], localizacao[2], ler.converter(localizacao[3]));
                System.out.println(lac);
                RestTemplate restTemplate = new RestTemplate();
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);

                HttpEntity<String> request = new HttpEntity<String>(loc.toString(), headers);
                Thread.sleep(1000);
                String insereKct = restTemplate.postForObject("http://localhost:8080/rest/localizacao/post/", request, String.class);

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
        return null;
    }
}
