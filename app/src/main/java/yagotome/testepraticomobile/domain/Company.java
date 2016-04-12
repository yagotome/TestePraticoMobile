package yagotome.testepraticomobile.domain;

import java.io.Serializable;

/**
 * Classe de modelo de Company que um usuário pode trabalhar.
 */
public class Company implements Serializable {
    private String name;

    public Company() {
    }

    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }
}
