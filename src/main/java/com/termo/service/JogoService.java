package com.termo.service;

import com.termo.model.CharacterStatus;
import com.termo.model.Tentativa;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class JogoService {
    private List<String> palavras;
    private String palavraSecreta;

    @PostConstruct
    public void carregarPalavras() throws IOException{
        palavras = Files.readAllLines(Paths.get("src/main/resources/palavras.txt"));
        Random random = new Random();
        palavraSecreta = palavras.get(random.nextInt(palavras.size()));
    }

    public Tentativa verificarPalavra(String tentativa){

        List<CharacterStatus> resultado = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            char letra = tentativa.charAt(i);
            char letraDigitada = palavraSecreta.charAt(i);

            if(letra == letraDigitada){
                resultado.add(CharacterStatus.CORRETO);
            }
            else if(palavraSecreta.contains(String.valueOf(letra))){
                resultado.add(CharacterStatus.POSICAO_ERRADA);
            }
            else {
                resultado.add(CharacterStatus.INCORRETO);
            }
        }
        return new Tentativa(tentativa, resultado);
    }
}
