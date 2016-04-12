package yagotome.testepraticomobile.domain;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Classe de modelo para usuário.
 */
public class User implements Serializable {
    private long id;
    private String nome;
    private String job;
    @Nullable private Company company;
    private Picture picture;

    public String getJob() {
        return job;
    }

    public User setJob(String job) {
        this.job = job;
        return this;
    }

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public User setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Nullable
    public Company getCompany() {
        return company;
    }

    public User setCompany(@Nullable Company company) {
        this.company = company;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public User setPicture(Picture picture) {
        this.picture = picture;
        return this;
    }
}
