package yagotome.testepraticomobile.domain;

import java.util.List;

/**
 * Classe de modelo de artigo.
 */
public class Article extends Project {
    private String texto;

    public Article(){}

    public Article(long id, String titulo, String descricao, List<String> tags, Picture picture
            , String texto, Usuario usuario, String likes, String views, String comments) {
        super(titulo, descricao, tags, picture, usuario, likes, views, comments);
        this.texto = texto;
    }


    public String getTexto() {
        return texto;
    }

    public Article setTexto(String texto) {
        this.texto = texto;
        return this;
    }
}
