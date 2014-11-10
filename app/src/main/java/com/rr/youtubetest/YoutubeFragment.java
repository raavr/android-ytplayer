package com.rr.youtubetest;




import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.internal.y;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link YoutubeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class YoutubeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int RECOVERY_DIALOG_REQUEST = 1;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YoutubeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YoutubeFragment newInstance(String param1, String param2) {
        YoutubeFragment fragment = new YoutubeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public YoutubeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         View view = inflater.inflate(R.layout.fragment_youtube, container, false);
        final PlayerYouTubeFrag myFragment = PlayerYouTubeFrag.newInstance("kdComTp7KsA");
        Button button1 = (Button) view.findViewById(R.id.button);
        Button button2 = (Button) view.findViewById(R.id.button2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFragment.setNewVideo("ozsmSlvGHv4");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myFragment.setNewVideo("YYc9NPiVw7c");
            }
        });

        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.youtube_fragment, myFragment).commit();

        myFragment.init();

        return view;
    }






}
