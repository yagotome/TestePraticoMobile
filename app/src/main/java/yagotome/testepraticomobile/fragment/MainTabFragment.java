package yagotome.testepraticomobile.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.adapter.TabsAdapter;

/**
 *
 */
public class MainTabFragment extends BaseFragment implements TabLayout.OnTabSelectedListener {
    private static final String TAG = "MainTabFragment";
    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_tab, container, false);

        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.projects));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.work_in_progress));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.people));
        tabLayout.setOnTabSelectedListener(this);

        mViewPager = (ViewPager) view.findViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(2);
        mViewPager.setAdapter(new TabsAdapter(getContext(), getChildFragmentManager()));
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return view;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) { }

    @Override
    public void onTabReselected(TabLayout.Tab tab) { }
}
