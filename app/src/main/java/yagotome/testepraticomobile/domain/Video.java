package yagotome.testepraticomobile.domain;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Classe de modelo de vídeo.
 */
public class Video extends Project {
    @Nullable private List<Video> related;

    public Video() {
    }

    public Video(Project project, @Nullable List<Video> related) {
        super(project.getTitle(), project.getDescription(), project.getTags(), project.getPicture()
                , project.getUser(), project.getLikes(), project.getViews(), project.getComments());
        this.related = related;
    }

    public Video(long id, String titulo, String descricao, List<String> tags, Picture picture
            , @Nullable List<Video> related, User user, String likes, String views, List<Comment> comments) {
        super(titulo, descricao, tags, picture, user, likes, views, comments);
        this.related = related;
    }

}
