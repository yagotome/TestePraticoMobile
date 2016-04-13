package yagotome.testepraticomobile.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Article;
import static yagotome.testepraticomobile.util.Utils.loadImage;

/**
 *
 */
public class ArticleFragment extends BaseFragment {
    private static final String TAG = "ArticleFragment";
    private Article article;
    private ImageView articleImg;
    private TextView articleText;

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
        View view = inflater.inflate(R.layout.fragment_article, container, false);
        articleImg = (ImageView) view.findViewById(R.id.article_img);
        articleText = (TextView) view.findViewById(R.id.article_text);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadImage(articleImg, article.getPicture().getUrl(), getContext());
        articleImg.setContentDescription(article.getPicture().getDescription());
        articleText.setText(article.getText());
    }
}
