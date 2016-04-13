package yagotome.testepraticomobile.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Article;
import yagotome.testepraticomobile.domain.Project;
import yagotome.testepraticomobile.domain.Video;
import yagotome.testepraticomobile.fragment.ArticleFragment;
import yagotome.testepraticomobile.fragment.VideoFragment;

public class ProjectViewActivity extends BaseActivity {
    private Project project;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_view);

        super.setUpActionBar(R.id.toolbar);

        project = (Project)getIntent().getSerializableExtra("project");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(project.getTitle());
        }

        addFragment();
    }

    private void addFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (project instanceof Article) {
            transaction.add(R.id.layout_fragment_project_view, ArticleFragment.newInstance((Article) project));
        } else if (project instanceof Video) {
            transaction.add(R.id.layout_fragment_project_view, VideoFragment.newInstance((Video) project));
        }
        transaction.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_project, menu);

        Intent intent = new Intent(Intent.ACTION_SEND);
        if (project instanceof Article) {
            intent.setType("text/*");
            intent.putExtra(Intent.EXTRA_TEXT, project.getPicture().getUrl() + "\n"
                    + ((Article) project).getText());
        } else if (project instanceof Video) {
            intent.setType("video/*");
            intent.putExtra(Intent.EXTRA_STREAM, ((Video) project).getUri());
        }

        MenuItem menuItem = menu.findItem(R.id.action_share);
        ShareActionProvider share = new ShareActionProvider(this);
        share.setShareIntent(intent);
        MenuItemCompat.setActionProvider(menuItem, share);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
