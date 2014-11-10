package com.rr.youtubetest;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by Rafal on 2014-11-05.
 */
public class PlayerYouTubeFrag extends YouTubePlayerSupportFragment {

    private String currentVideoID = "video_id";
    private YouTubePlayer activePlayer;
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    public static PlayerYouTubeFrag newInstance(String url) {

        PlayerYouTubeFrag playerYouTubeFrag = new PlayerYouTubeFrag();

        Bundle bundle = new Bundle();
        bundle.putString("url", url);

        playerYouTubeFrag.setArguments(bundle);

        return playerYouTubeFrag;
    }

    public void init() {

        initialize(DeveloperKey.DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                YouTubeInitializationResult errorReason) {
                if (errorReason.isUserRecoverableError()) {
                    errorReason.getErrorDialog(getActivity(), RECOVERY_DIALOG_REQUEST).show();
                } else {
                    String errorMessage = String.format(getString(R.string.error_player), errorReason.toString());
                    Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                activePlayer = player;
                activePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                //activePlayer.addFullscreenControlFlag(YouTubePlayer.FULLSCREEN_FLAG_CUSTOM_LAYOUT);
                if (!wasRestored) {
                    activePlayer.cueVideo(getArguments().getString("url"), 0);

                }
            }
        });
    }

    public void setNewVideo(String video) {
        //activePlayer.loadVideo(video);
        activePlayer.cueVideo(video);
    }


}
