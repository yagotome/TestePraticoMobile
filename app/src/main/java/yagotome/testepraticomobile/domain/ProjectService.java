package yagotome.testepraticomobile.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import yagotome.testepraticomobile.R;

/**
 * Classe que vai ter serviços relacionados ao projeto.
 */
public class ProjectService {
    public static List<Project> getProjetos(Context context) {
        List<Project> projects = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Project project = new Project();
            project.setTitle("Project " + i);
            project.setDescription("Descrição do project " + i);
            String url = "http://imagens.canaltech.com.br/91951.148999-Melhores-jogos-para-Facebook.jpg";
            project.setPicture(new Picture(url, "Imagem do projeto de teste"));
            url = "http://3.bp.blogspot.com/-I0K7gS_96s0/Tf0YAbogMDI/AAAAAAAABP8/lUzhIG8AQ2g/s1600/lorem_ipsum.jpg";
            project.setUser(new User()
                            .setNome("User " + i)
                            .setJob("Developer")
                            .setPicture(new Picture(url, "Imagem do usuário de teste"))
            );
            if (i % 4 == 0) {
                project.getUser().setCompany(new Company("Storm"));
            }
            project.setLikes(i + "k");
            project.setViews(i * i + "k");

            //adicionando comentários
            List<Comment> comments = new ArrayList<>();
            int n = new Random().nextInt(21460)+1;
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    comments.add(new Comment(projects.get(new Random().nextInt(i)).getUser()
                            , "Muito bom! Cometário de teste " + j));
                }
            }
            project.setComments(comments);


            if (i % 2 == 0) {
                project = new Article(project, context.getString(R.string.project_service_test_article_text));
            } else {
                project = new Video(project, null);
            }
            projects.add(project);
        }
        return projects;
    }
    public static void like(Project project) {
        //Faz request de like ao back-end e atualiza like.
    }
    public static void dislike(Project project) {
        //Faz request de dislike ao back-end e atualiza like.
    }
}
