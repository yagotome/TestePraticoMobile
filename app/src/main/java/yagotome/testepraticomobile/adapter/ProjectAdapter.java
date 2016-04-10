package yagotome.testepraticomobile.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

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
        carregaImagem(p.getUsuario().getPicture().getUrl(), holder.imgUsuario, holder.progressBar);
        holder.nomeUsuario.setText(p.getUsuario().getNome());
        holder.descricaoUsuario.setText(p.getUsuario().getNome());
        carregaImagem(p.getPicture().getUrl(), holder.imgProjeto, holder.progressBar);
        holder.tituloProjeto.setText(p.getTitulo());
        holder.descricaoProjeto.setText(p.getDescricao());
        holder.likes.setText(p.getLikes());
        holder.views.setText(p.getViews());
        holder.comments.setText(p.getComments());
        if (projectOnClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    projectOnClickListener.onClick(holder.itemView, position);
                }
            });
        }
    }

    private void carregaImagem (String url, ImageView img, final ProgressBar progress) {
        progress.setVisibility(View.VISIBLE);
        Picasso.with(context).load(url).fit().into(img,
            new Callback() {
                @Override
                public void onSuccess() {
                    progress.setVisibility(View.GONE);
                }
                @Override
                public void onError() {
                    progress.setVisibility(View.GONE);
                }
            });
    }

    @Override
    public int getItemCount() {
        return projects != null ? projects.size() : 0;
    }

    public interface ProjectOnClickListener {
        void onClick(View view, int position);
    }

    public static class ProjectsViewHolder extends RecyclerView.ViewHolder {
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
        protected CardView cardView;
        public ProjectsViewHolder(View view) {
            super(view);
            imgUsuario = (ImageView) view.findViewById(R.id.img_usuario);
            nomeUsuario = (TextView) view.findViewById(R.id.nome_usuario);
            descricaoUsuario = (TextView) view.findViewById(R.id.descricao_usuario);
            imgProjeto = (ImageView) view.findViewById(R.id.img_artigo);
            tituloProjeto = (TextView) view.findViewById(R.id.titulo_projeto);
            descricaoProjeto = (TextView) view.findViewById(R.id.descricao_projeto);
            progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
            cardView = (CardView) view.findViewById(R.id.card_view);
            likes = (TextView) view.findViewById(R.id.likes);
            views = (TextView) view.findViewById(R.id.views);
            comments = (TextView) view.findViewById(R.id.comments);
        }
    }


}
