package yagotome.testepraticomobile.domain;

import java.io.Serializable;

/**
 * Classe de modelo de Empresa que um usuário pode trabalhar.
 */
public class Empresa implements Serializable {
    private String nome;

    public Empresa() {
    }

    public Empresa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Empresa setNome(String nome) {
        this.nome = nome;
        return this;
    }
}
