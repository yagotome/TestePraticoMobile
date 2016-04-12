package yagotome.testepraticomobile.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Article;

/**
 *
 */
public class ArticleFragment extends BaseFragment {
    private Article article;

    public ArticleFragment() {
    }

    public static ArticleFragment newInstance(Article article) {
        ArticleFragment fragment =  new ArticleFragment();
        fragment.article = article;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }
}
