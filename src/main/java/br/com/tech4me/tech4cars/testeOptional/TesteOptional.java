package br.com.tech4me.tech4cars.testeOptional;

import java.util.Optional;

public class TesteOptional {

    public static void main(String[] args) {
        Optional<String> teste= Optional.of("tenho um texto aqui");
        System.out.println(teste.orElse("Não tinha texto ooriginalmente"));
    }
    
}
