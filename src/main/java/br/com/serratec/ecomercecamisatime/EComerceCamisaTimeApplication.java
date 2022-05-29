package br.com.serratec.ecomercecamisatime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.Date;


@SpringBootApplication
public class EComerceCamisaTimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EComerceCamisaTimeApplication.class, args);

        saudacao();
        LocalDateTime myObj = LocalDateTime.now();
        System.out.println(myObj);

    }

    public static void saudacao(){
        Integer h = new Date().getHours();

        if (h <= 5 || h == 0) {
            System.out.println("Boa Madrugada");
        }
        else if (h < 12) {
            System.out.println("Bom Dia");
        }
        else if (h < 18) {
            System.out.println("Boa Tarde");
        }
        else if (h >= 18) {
            System.out.println("Boa Noite");
        }
    }
}

