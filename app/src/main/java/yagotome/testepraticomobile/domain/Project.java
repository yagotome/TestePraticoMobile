package yagotome.testepraticomobile.domain;

import java.util.List;

/**
 * Classe de modelo para projeto.
 */
public class Project {
    private long id;
    private String titulo;
    private String descricao;
    private List<String> tags;
    private Picture picture;
    private Usuario usuario;
    private String likes;
    private String views;
    private String comments;

    public Project() {}

    public Project(String titulo, String descricao, List<String> tags, Picture picture, Usuario usuario, String likes, String views, String comments) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tags = tags;
        this.picture = picture;
        this.usuario = usuario;
        this.likes = likes;
        this.views = views;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public Project setId(long id) {
        this.id = id;
        return this;
    }

    public String getLikes() {
        return likes;
    }

    public Project setLikes(String likes) {
        this.likes = likes;
        return this;
    }

    public String getViews() {
        return views;
    }

    public Project setViews(String views) {
        this.views = views;
        return this;
    }

    public String getComments() {
        return comments;
    }

    public Project setComments(String comments) {
        this.comments = comments;
        return this;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
