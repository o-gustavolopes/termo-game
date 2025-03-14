package com.termo.model;


import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tentativa {
    private String palavra;
    private List<CharacterStatus> resultado;

    public Tentativa(String palavra){
        this.palavra = palavra;
    }
}
