package yagotome.testepraticomobile.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Classe que vai ter serviços relacionados ao projeto.
 */
public class ProjectService {
    public static List<Project> getProjetos(Context context) {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Project project = new Project();
            project.setTitulo("Project " + i);
            project.setDescricao("Descrição do project " + i);
            String url = "http://imagens.canaltech.com.br/91951.148999-Melhores-jogos-para-Facebook.jpg";
            project.setPicture(new Picture(url, "Imagem do projeto de teste"));
            url = "http://3.bp.blogspot.com/-I0K7gS_96s0/Tf0YAbogMDI/AAAAAAAABP8/lUzhIG8AQ2g/s1600/lorem_ipsum.jpg";
            project.setUsuario(new Usuario().setNome("User " + i).setPicture(new Picture(url, "Imagem do usuário de teste")));
            project.setLikes(i + "k");
            project.setViews(i * i + "k");
            project.setQtdComments(100 * i + i * i + "");

            //adicionando comentários
            List<Comment> comments = new ArrayList<>();
            int n = new Random().nextInt(15)+1;
            for (int j = 0; j < n; j++) {
                comments.add(new Comment(projects.get(new Random().nextInt(i)).getUsuario()
                        , "Cometário de teste " + j));
            }
            project.setComments(comments);

            projects.add(project);
        }
        return projects;
    }
}
