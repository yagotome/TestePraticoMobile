package yagotome.testepraticomobile.domain;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Classe de modelo de vídeo.
 */
public class Video extends Project {
    @Nullable private List<Video> related;
    private String uri;

    public Video() {
    }

    public Video(Project project, @Nullable List<Video> related, String uri) {
        super(project.getTitle(), project.getDescription(), project.getTags(), project.getPicture()
                , project.getUser(), project.getLikes(), project.getViews(), project.getComments());
        this.related = related;
        this.uri = uri;
    }

    public Video(long id, String titulo, String descricao, List<String> tags, Picture picture
            , @Nullable List<Video> related, String videoUri, User user, String likes, String views, List<Comment> comments) {
        super(titulo, descricao, tags, picture, user, likes, views, comments);
        this.related = related;
        this.uri = videoUri;
    }


    @Nullable
    public List<Video> getRelated() {
        return related;
    }

    public Video setRelated(@Nullable List<Video> related) {
        this.related = related;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public Video setUri(String uri) {
        this.uri = uri;
        return this;
    }
}
