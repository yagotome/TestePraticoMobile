package yagotome.testepraticomobile.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Classe de modelo para projeto.
 */
public class Project implements Serializable {
    private long id;
    private String titulo;
    private String descricao;
    private List<String> tags;
    private Picture picture;
    private Usuario usuario;
    private String likes;
    private String views;
    private String qtdComments;
    private List<Comment> comments;

    public Project() {}

    public Project(String titulo, String descricao, List<String> tags, Picture picture
            , Usuario usuario, String likes, String views, String qtdComments, List<Comment> comments) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.tags = tags;
        this.picture = picture;
        this.usuario = usuario;
        this.likes = likes;
        this.views = views;
        this.qtdComments = qtdComments;
        this.comments = comments;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getQtdComments() {
        return qtdComments;
    }

    public void setQtdComments(String qtdComments) {
        this.qtdComments = qtdComments;
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
