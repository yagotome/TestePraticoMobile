package yagotome.testepraticomobile.fragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devbrackets.android.exomedia.EMVideoView;

import yagotome.testepraticomobile.R;
import yagotome.testepraticomobile.activity.BaseActivity;
import yagotome.testepraticomobile.domain.Video;

/**
 *
 */
public class VideoFragment extends BaseFragment implements MediaPlayer.OnPreparedListener {
    private static final String TAG = "VideoFragment";
    private Video video;
    private  EMVideoView emVideoView;

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

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupVideoView();
    }

    private void setupVideoView() {
        assert (getView() != null);
        emVideoView = (EMVideoView)getView().findViewById(R.id.video_play_activity_video_view);
        emVideoView.setOnPreparedListener(this);
        emVideoView.setVideoURI(Uri.parse(video.getUri()));
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        emVideoView.start();
    }

}
