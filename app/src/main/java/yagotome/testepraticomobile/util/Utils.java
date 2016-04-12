package yagotome.testepraticomobile.util;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
 *
 */
public class Utils {
    public static void loadImage(final ImageView img, String url
            , @Nullable final ProgressBar progress, final Context context, final String TAG) {
        Log.i(TAG, "Carregando imagem");
        Picasso.with(context).load(url).fit().into(img,
                new Callback() {
                    @Override
                    public void onSuccess() {
                        if (progress != null) {
                            progress.setVisibility(View.GONE);
                        }
                        Log.i(TAG, "Imagem carregada com sucesso.");
                    }

                    @Override
                    public void onError() {
                        if (progress != null) {
                            progress.setVisibility(View.GONE);
                        }
                        Log.i(TAG, "Erro ao carregar imagem.");
                    }
                });
    }
    public static void loadImage(final ImageView img, String url
            , final Context context, final String TAG) {
        loadImage(img, url, null, context, TAG);
    }
}
