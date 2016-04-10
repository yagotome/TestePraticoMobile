package yagotome.testepraticomobile.domain;

import android.support.annotation.Nullable;

/**
 * Classe de modelo para Usuario.
 */
public class Usuario {
    private long id;
    private String nome;
    @Nullable private Empresa empresa;
    private Picture picture;

    public long getId() {
        return id;
    }

    public Usuario setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Usuario setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Nullable
    public Empresa getEmpresa() {
        return empresa;
    }

    public Usuario setEmpresa(@Nullable Empresa empresa) {
        this.empresa = empresa;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public Usuario setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
