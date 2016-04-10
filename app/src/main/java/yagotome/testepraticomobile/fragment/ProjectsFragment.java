package yagotome.testepraticomobile.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Project;
import yagotome.testepraticomobile.domain.ProjectService;

/**
 *
 */
public class ProjectsFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private List<Project> projects;
    private LinearLayoutManager mLayoutManager;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_projects, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.lista_projetos);
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        projects = ProjectService.getProjetos(getContext());
        //recyclerView.setAdapter();
    }
}
