package com.example.mtzat.happybirthday;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by mtzat on 10/17/2015.
 */
public class BirthdayFragment extends Fragment {
    private AudioPlayer mPlayer = new AudioPlayer();

    private Button mPlayButton;
    private Button mStopButton;
    private Button mPauseButton;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_birthday,parent,false);

        mPlayButton = (Button) v.findViewById(R.id.playButton);
        mPlayButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.play(getActivity());
            }
        });


        mPauseButton = (Button) v.findViewById(R.id.pauseButton);
        mPauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mPlayer.pause();
            }
        });

        mStopButton = (Button) v.findViewById(R.id.stopButton);
        mStopButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.stop();
            }
        });

        return v;
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        mPlayer.stop();
    }

}
