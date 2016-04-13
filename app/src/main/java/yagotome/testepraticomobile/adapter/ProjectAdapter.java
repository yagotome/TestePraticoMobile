package yagotome.testepraticomobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import static yagotome.testepraticomobile.util.Utils.loadImage;

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
        loadImage(holder.userImg, p.getUser().getPicture().getUrl(), holder.progressBar, context);
        holder.userImg.setContentDescription(p.getUser().getPicture().getDescription());
        holder.userName.setText(p.getUser().getNome());
        holder.userDesc.setText(
                p.getUser().getJob()
                        + (p.getUser().getCompany() != null ? " at " + p.getUser().getCompany().getName() : "")
        );
        loadImage(holder.projectImg, p.getPicture().getUrl(), holder.progressBar, context);
        holder.projectImg.setContentDescription(p.getPicture().getDescription());
        holder.projectTitle.setText(p.getTitle());
        holder.projectDesc.setText(p.getDescription());
        holder.likes.setText(p.getLikes());
        holder.likes.setContentDescription(p.getLikes() + " " + context.getString(R.string.likes));
        holder.views.setText(p.getViews());
        holder.views.setContentDescription(p.getViews() + " " + context.getString(R.string.views));
        holder.comments.setText(p.getCommentsAmount());
        holder.comments.setContentDescription(p.getCommentsAmount() + " " + context.getString(R.string.comments));
        if (projectOnClickListener != null) {
            holder.projectImg.setOnClickListener(new View.OnClickListener() {
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
        protected ImageView userImg;
        protected TextView userName;
        protected TextView userDesc;
        protected ImageView projectImg;
        protected TextView projectTitle;
        protected TextView projectDesc;
        protected TextView likes;
        protected TextView views;
        protected TextView comments;
        protected ProgressBar progressBar;
        protected View layoutContent;
        public ProjectsViewHolder(View view) {
            super(view);
            userImg = (ImageView) view.findViewById(R.id.user_img);
            userName = (TextView) view.findViewById(R.id.user_name);
            userDesc = (TextView) view.findViewById(R.id.user_desc);
            projectImg = (ImageView) view.findViewById(R.id.article_img);
            projectTitle = (TextView) view.findViewById(R.id.project_title);
            projectDesc = (TextView) view.findViewById(R.id.project_desc);
            progressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
            likes = (TextView) view.findViewById(R.id.likes);
            views = (TextView) view.findViewById(R.id.views);
            comments = (TextView) view.findViewById(R.id.comments_amount);
            layoutContent = view.findViewById(R.id.layout_content);
        }
    }


}
