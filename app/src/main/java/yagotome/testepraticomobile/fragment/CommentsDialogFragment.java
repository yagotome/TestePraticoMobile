package yagotome.testepraticomobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.List;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.adapter.CommentAdapter;
import yagotome.testepraticomobile.domain.Comment;

/**
 * Fragment para mostrar os comentários de um projeto.
 */
public class CommentsDialogFragment extends DialogFragment {
    private static final String TAG = "CommentsDialogFragment";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private List<Comment> comments;
    public static CommentsDialogFragment newInstance(List<Comment> comments) {
        CommentsDialogFragment fragment = new CommentsDialogFragment();
        fragment.comments = comments;
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().setTitle(getContext().getString(R.string.comments));

        View view = inflater.inflate(R.layout.dialog_fragment_comments, container, false);

        recyclerView = (RecyclerView)view.findViewById(R.id.comments_list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);


        progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);

        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        recyclerView.setAdapter(new CommentAdapter(getContext(), comments));

        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }
}
