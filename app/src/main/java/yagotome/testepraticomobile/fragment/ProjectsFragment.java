package yagotome.testepraticomobile.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.activity.ProjectViewActivity;
import yagotome.testepraticomobile.adapter.ProjectAdapter;
import yagotome.testepraticomobile.domain.Project;
import yagotome.testepraticomobile.domain.ProjectService;

/**
 *
 */
public class ProjectsFragment extends BaseFragment {
    private static final String TAG = "ProjectsFragment";
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private List<Project> projects;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projects, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.projects_list);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        progressBar = (ProgressBar)view.findViewById(R.id.progress_bar);

        return view;
    }

    @Override
    public void onActivityCreated(final Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "Chamando serviço que pega projetos.");
        new AsyncTask<Void, Void, List<Project>>() {
            @Override
            protected void onPreExecute() {
                recyclerView.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected List<Project> doInBackground(Void... params) {
                projects = ProjectService.getProjetos(getContext());
                return projects;
            }

            @Override
            protected void onPostExecute(final List<Project> projects) {
                progressBar.setVisibility(View.GONE);
                recyclerView.setVisibility(View.VISIBLE);
                recyclerView.setAdapter(new ProjectAdapter(getContext(), projects, new ProjectAdapter.ProjectOnClickListener() {
                    @Override
                    public void projectImageOnClick(View view, int position) {
                        Intent intent = new Intent(getContext(), ProjectViewActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("projects", projects.get(position));
                        intent.putExtras(bundle);
                        getActivity().startActivity(intent);
                    }

                    @Override
                    public void likesOnClick(View view, int position) {
                        //dar like
                    }

                    @Override
                    public void commentsOnClick(View view, int position) {
                        //abrir comments
                        FragmentManager fm = getFragmentManager();
                        CommentsDialogFragment comments = CommentsDialogFragment.newInstance(projects.get(position).getComments());

                        comments.show(fm, "Comments");
                    }
                }));
            }
        }.execute();
    }
}
