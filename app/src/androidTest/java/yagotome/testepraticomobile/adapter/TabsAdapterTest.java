package yagotome.testepraticomobile.adapter;

import android.support.v4.app.FragmentManager;
import android.test.AndroidTestCase;

import yagotome.testepraticomobile.fragment.MainTabFragment;
import yagotome.testepraticomobile.fragment.PeopleFragment;
import yagotome.testepraticomobile.fragment.ProjectsFragment;
import yagotome.testepraticomobile.fragment.WorkInProgressFragment;

/**
 * Teste para adapter TabsAdapter.
 */
public class TabsAdapterTest extends AndroidTestCase {
    private TabsAdapter adapter;
    private FragmentManager fm;
    private MainTabFragment fragment;
    @Override
    protected void setUp() throws Exception {
        fragment = new MainTabFragment();
        fm = fragment.getChildFragmentManager();
        adapter = new TabsAdapter(getContext(), fm);
    }

    public void testGetCount() {
        assertEquals(3, adapter.getCount());
    }
    public void testGetItem() {
        assertTrue(adapter.getItem(0) instanceof ProjectsFragment);
        assertTrue(adapter.getItem(1) instanceof WorkInProgressFragment);
        assertTrue(adapter.getItem(2) instanceof PeopleFragment);
    }
}
