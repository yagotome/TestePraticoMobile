package yagotome.testepraticomobile.adapter;

import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.test.AndroidTestCase;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Comment;
import yagotome.testepraticomobile.domain.Company;
import yagotome.testepraticomobile.domain.Picture;
import yagotome.testepraticomobile.domain.Project;
import yagotome.testepraticomobile.domain.User;
import yagotome.testepraticomobile.fragment.ProjectsFragment;

/**
 * Teste para adapter ProjectAdapter.
 */
public class ProjectAdapterTest extends AndroidTestCase {
    private static final String TAG = "ProjectAdapterTest";
    private ProjectAdapter adapter;
    private FragmentManager fm;
    private ProjectsFragment fragment;
    private List<Project> projects;
    private ViewGroup viewParent;
    private ProjectAdapter.ProjectsViewHolder holder;
    @Override
    protected void setUp() throws Exception {
        fragment = new ProjectsFragment();
        fm = fragment.getChildFragmentManager();
        projects = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Project project = new Project();
            project.setTitle("Project " + i);
            project.setDescription("Descrição do project " + i);
            String url = "http://imagens.canaltech.com.br/91951.148999-Melhores-jogos-para-Facebook.jpg";
            project.setPicture(new Picture(url, "Imagem do projeto de teste"));
            url = "http://3.bp.blogspot.com/-I0K7gS_96s0/Tf0YAbogMDI/AAAAAAAABP8/lUzhIG8AQ2g/s1600/lorem_ipsum.jpg";
            project.setUser(new User()
                    .setNome("User " + i)
                    .setPicture(new Picture(url, "Imagem do usuário de teste"))
                    .setCompany(new Company("Storm")));
            project.setLikes(i + "k");
            project.setViews(i*i + "k");

            //adicionando comentários
            List<Comment> comments = new ArrayList<>();
            int n = new Random().nextInt(15)+1;
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    comments.add(new Comment(projects.get(new Random().nextInt(i)).getUser()
                            , "Muito bom! Cometário de teste " + j));
                }
            }
            project.setComments(comments);

            projects.add(project);
        }
        adapter = new ProjectAdapter(getContext(), projects, null);
        viewParent = new LinearLayout(getContext());
        holder = adapter.onCreateViewHolder(viewParent, 0);
    }
    public void testOnCreateViewHolder() {
        assertEquals(LayoutInflater.from(getContext()).inflate(R.layout.adapter_projeto, viewParent, false).getId(), holder.itemView.getId());
    }
    public void testGetItemCount() {
        assertEquals(projects.size(), adapter.getItemCount());
    }
    public void testOnBindViewHolder() throws InterruptedException {
        final int position = 2;
        Handler handler = new Handler(getContext().getMainLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {
                    adapter.onBindViewHolder(holder, position);
            }
        });
        Thread.sleep(3000);
        Project p = projects.get(position);
        assertEquals(p.getUser().getNome(), holder.userName.getText().toString());
        //noinspection ConstantConditions
        assertEquals(p.getUser().getJob() + " at " + p.getUser().getCompany().getName()
                , holder.userDesc.getText().toString());
        assertEquals(p.getTitle(), holder.projectTitle.getText().toString());
        assertEquals(p.getDescription(), holder.projectDesc.getText().toString());
        assertEquals(p.getLikes(), holder.likes.getText().toString());
        assertEquals(p.getViews(), holder.views.getText().toString());
        assertEquals(p.getCommentsAmount(), holder.comments.getText().toString());
    }
}
