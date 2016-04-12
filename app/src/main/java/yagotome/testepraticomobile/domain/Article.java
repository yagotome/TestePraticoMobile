package yagotome.testepraticomobile.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Classe de modelo de artigo.
 */
public class Article extends Project {
    private String texto;

    public Article(){}

    public Article(Project project, String textoArtigo) {
        super(project.getTitulo(), project.getDescricao(), project.getTags(), project.getPicture()
                , project.getUsuario(), project.getLikes(), project.getViews()
                , project.getQtdComments(), project.getComments());
        this.texto = textoArtigo;
    }

    public Article(long id, String titulo, String descricao, List<String> tags, Picture picture
            , String texto, Usuario usuario, String likes, String views, String qtdComments, List<Comment> comments) {
        super(titulo, descricao, tags, picture, usuario, likes, views, qtdComments, comments);
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
