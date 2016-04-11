package yagotome.testepraticomobile.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import yagotome.testepraticomobile.fragment.PeopleFragment;
import yagotome.testepraticomobile.fragment.ProjectsFragment;
import yagotome.testepraticomobile.fragment.WorkInProgressFragment;

/**
 *
 */
public class TabsAdapter extends FragmentPagerAdapter {
    private Context context;
    public TabsAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new ProjectsFragment();
            case 1:
                return new WorkInProgressFragment();
            case 2:
                return new PeopleFragment();
            default:
                return null;
        }
    }

}
