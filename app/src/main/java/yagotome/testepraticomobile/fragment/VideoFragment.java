package yagotome.testepraticomobile.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.domain.Video;

/**
 *
 */
public class VideoFragment extends BaseFragment {
    private Video video;

    public VideoFragment() {
    }

    public static VideoFragment newInstance(Video video) {
        VideoFragment fragment = new VideoFragment();
        fragment.video = video;
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);
    }
}
