package yagotome.testepraticomobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import static yagotome.testepraticomobile.util.Utils.carregaImagem;

import java.util.List;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Project;

/**
 * Adapter para projeto.
 */
public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ProjectsViewHolder> {
    private final Context context;
    private final List<Project> projects;
    private ProjectOnClickListener projectOnClickListener;
    private static final String TAG = "ProjectAdapter";

    public ProjectAdapter(Context context, List<Project> projects, ProjectOnClickListener projectOnClickListener) {
        this.context = context;
        this. projects = projects;
        this.projectOnClickListener = projectOnClickListener;
    }

    @Override
    public ProjectsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_projeto, parent, false);
        return new ProjectsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProjectsViewHolder holder, final int position) {
        Project p = projects.get(position);
        carregaImagem(holder.imgUsuario, p.getUsuario().getPicture().getUrl(), holder.progressBar, context, TAG);
        holder.nomeUsuario.setText(p.getUsuario().getNome());
        holder.descricaoUsuario.setText(
                p.getUsuario().getProfissao()
                + (p.getUsuario().getEmpresa() != null ? " at " + p.getUsuario().getEmpresa().getNome() : "")
        );
        carregaImagem(holder.imgProjeto, p.getPicture().getUrl(), holder.progressBar, context, TAG);
        holder.tituloProjeto.setText(p.getTitulo());
        holder.descricaoProjeto.setText(p.getDescricao());
        holder.likes.setText(p.getLikes());
        holder.views.setText(p.getViews());
        holder.comments.setText(p.getQtdComments());
        if (projectOnClickListener != null) {
            holder.imgProjeto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    projectOnClickListener.projectImageOnClick(view, position);
                }
            });
            holder.likes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    projectOnClickListener.likesOnClick(view, position);
                }
            });
            holder.comments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    projectOnClickListener.commentsOnClick(view, position);
                }
            });
        }
        holder.layoutContent.setVisibility(View.VISIBLE);
        holder.progressBar.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return projects != null ? projects.size() : 0;
    }

    public interface ProjectOnClickListener {
        void projectImageOnClick(View view, int position);
        void likesOnClick(View view, int position);
        void commentsOnClick(View view, int position);
    }

    static class ProjectsViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imgUsuario;
        protected TextView nomeUsuario;
        protected TextView descricaoUsuario;
        protected ImageView imgProjeto;
        protected TextView tituloProjeto;
        protected TextView descricaoProjeto;
        protected TextView likes;
        protected TextView views;
        protected TextView comments;
        protected ProgressBar progressBar;
        protected View layoutContent;
        public ProjectsViewHolder(View view) {
            super(view);
            imgUsuario = (ImageView) view.findViewById(R.id.img_usuario);
            nomeUsuario = (TextView) view.findViewById(R.id.nome_usuario);
            descricaoUsuario = (TextView) view.findViewById(R.id.descricao_usuario);
            imgProjeto = (ImageView) view.findViewById(R.id.img_artigo);
            tituloProjeto = (TextView) view.findViewById(R.id.titulo_projeto);
            descricaoProjeto = (TextView) view.findViewById(R.id.descricao_projeto);
            progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
            likes = (TextView) view.findViewById(R.id.likes);
            views = (TextView) view.findViewById(R.id.views);
            comments = (TextView) view.findViewById(R.id.qtdComments);
            layoutContent = view.findViewById(R.id.layout_content);
        }
    }


}
