package yagotome.testepraticomobile.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static yagotome.testepraticomobile.util.Utils.carregaImagem;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Comment;

/**
 *
 */
public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentsViewHolder> {
    private static final String TAG = "CommentAdapter";
    private Context context;
    private List<Comment> comments;

    public CommentAdapter(Context context, List<Comment> comments) {
        this.context = context;
        this.comments = comments;
    }

    @Override
    public CommentsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_comment, parent, false);
        return new CommentsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(CommentsViewHolder holder, int position) {
        Comment comment = comments.get(position);
        carregaImagem(holder.imgUsuario, comment.getUsuario().getPicture().getUrl(), context, TAG);
        holder.nomeUsuario.setText(comment.getUsuario().getNome());
        holder.comment.setText(comment.getComment());
    }

    @Override
    public int getItemCount() {
        return comments != null ? comments.size() : 0;
    }

    static class CommentsViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imgUsuario;
        protected TextView nomeUsuario;
        protected TextView comment;
        public CommentsViewHolder(View itemView) {
            super(itemView);
            imgUsuario = (ImageView)itemView.findViewById(R.id.comment_img_usuario);
            nomeUsuario = (TextView)itemView.findViewById(R.id.comment_nome_usuario);
            comment = (TextView)itemView.findViewById(R.id.comment);
        }
    }
}
