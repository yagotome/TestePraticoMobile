package yagotome.testepraticomobile.domain;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

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
            project.setViews(i*i + "k");
            project.setComments(100*i + i*i + "");
            projects.add(project);
        }
        return projects;
    }
}
