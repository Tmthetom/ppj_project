package cz.tul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) throws Exception {
        // Running at http://localhost:8080/
        SpringApplication.run(Main.class, args);
    }
}