package yagotome.testepraticomobile.domain;

import java.io.Serializable;

/**
 * Classe de modelo de comentário.
 */
public class Comment implements Serializable {
    private User user;
    private String comment;

    public Comment() {
    }

    public Comment(User user, String comment) {
        this.user = user;
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public Comment setUser(User user) {
        this.user = user;
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
