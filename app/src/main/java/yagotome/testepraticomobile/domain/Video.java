package yagotome.testepraticomobile.domain;

import android.support.annotation.Nullable;

import java.util.List;

/**
 * Classe de modelo de vídeo.
 */
public class Video extends Project {
    @Nullable private List<Video> relacionados;

    public Video() {
    }

    public Video(Project project, @Nullable List<Video> relacionados) {
        super(project.getTitulo(), project.getDescricao(), project.getTags(), project.getPicture()
                , project.getUsuario(), project.getLikes(), project.getViews()
                , project.getQtdComments(), project.getComments());
        this.relacionados = relacionados;
    }

    public Video(long id, String titulo, String descricao, List<String> tags, Picture picture
            , @Nullable List<Video> relacionados, Usuario usuario, String likes, String views, String qtdComments, List<Comment> comments) {
        super(titulo, descricao, tags, picture, usuario, likes, views, qtdComments, comments);
        this.relacionados = relacionados;
    }

}
