package yagotome.testepraticomobile.domain;

/**
 * Classe de modelo de comentário.
 */
public class Comment {
    private Usuario usuario;
    private String comment;

    public Comment() {
    }

    public Comment(Usuario usuario, String comment) {
        this.usuario = usuario;
        this.comment = comment;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Comment setUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Comment setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
