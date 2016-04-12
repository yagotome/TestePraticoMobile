package yagotome.testepraticomobile.domain;

import java.util.List;

/**
 * Classe de modelo de artigo.
 */
public class Article extends Project {
    private String text;

    public Article(){}

    public Article(Project project, String articleText) {
        super(project.getTitle(), project.getDescription(), project.getTags(), project.getPicture()
                , project.getUser(), project.getLikes(), project.getViews(), project.getComments());
        this.text = articleText;
    }

    public Article(long id, String titulo, String descricao, List<String> tags, Picture picture
            , String text, User user, String likes, String views, List<Comment> comments) {
        super(titulo, descricao, tags, picture, user, likes, views, comments);
        this.text = text;
    }


    public String getText() {
        return text;
    }

    public Article setText(String text) {
        this.text = text;
        return this;
    }
}
