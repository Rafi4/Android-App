package com.example.swipe2.View;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;

import com.example.swipe2.R;


public class Activity2 extends Fragment {

    ImageButton buttonSoundsWind;
    ImageButton buttonSoundBonfire;
    ImageButton buttonSoundJungle;
    ImageButton buttonSoundBird;
    ImageButton buttonSoundPiano;
    ImageButton buttonSoundForest;

    MediaPlayer mediaPlayerWind;
    MediaPlayer mediaPlayerBonfire;
    MediaPlayer mediaPlayerJungle;
    MediaPlayer mediaPlayerBird;
    MediaPlayer mediaPlayerPiano;
    MediaPlayer mediaPlayerForest;

    boolean isFav = false;
    boolean isFav2 = false;
    boolean isFav3 = false;
    boolean isFav4 = false;
    boolean isFav5 = false;
    boolean isFav6 = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab2, container, false);

        mediaPlayerWind = MediaPlayer.create(getActivity(), R.raw.wind);
        mediaPlayerBonfire = MediaPlayer.create(getActivity(), R.raw.fire2);
        mediaPlayerJungle = MediaPlayer.create(getActivity(), R.raw.tropical_ambience);
        mediaPlayerBird = MediaPlayer.create(getActivity(), R.raw.bird);
        mediaPlayerPiano = MediaPlayer.create(getActivity(), R.raw.piano_loop);
        mediaPlayerForest = MediaPlayer.create(getActivity(),R.raw.forest);

        buttonSoundsWind = view.findViewById(R.id.windImage);
        buttonSoundBonfire = view.findViewById(R.id.bonfireImage);
        buttonSoundJungle = view.findViewById(R.id.jungleImage);
        buttonSoundBird = view.findViewById(R.id.birdImage);
        buttonSoundPiano = view.findViewById(R.id.pianoImage);
        buttonSoundForest = view.findViewById(R.id.tentImage);

        mediaPlayerWind.setVolume(1f, 1f);
        mediaPlayerWind.setLooping(true);
        mediaPlayerBonfire.setVolume(1f, 1f);
        mediaPlayerBonfire.setLooping(true);
        mediaPlayerJungle.setVolume(1f, 1f);
        mediaPlayerJungle.setLooping(true);
        mediaPlayerBird.setVolume(1f,1f);
        mediaPlayerBird.setLooping(true);
        mediaPlayerPiano.setVolume(1f,1f);
        mediaPlayerPiano.setLooping(true);
        mediaPlayerForest.setVolume(1f,1f);
        mediaPlayerForest.setLooping(true);

        final SeekBar windVolume = (SeekBar) view.findViewById(R.id.seekBar);
        windVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayerWind.setVolume(progress / 100f, progress / 100f);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });


        final SeekBar bonfireVolume = (SeekBar) view.findViewById(R.id.seekBar2);
        bonfireVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayerBonfire.setVolume(progress / 100f, progress / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        final SeekBar jungleVolume = (SeekBar) view.findViewById(R.id.seekBar3);
        jungleVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayerJungle.setVolume(progress / 100f, progress / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        final SeekBar birdVolume = (SeekBar) view.findViewById(R.id.seekBar4);
        birdVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayerBird.setVolume(progress / 100f, progress / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        final SeekBar pianoVolume = (SeekBar) view.findViewById(R.id.seekBar5);
        pianoVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayerPiano.setVolume(progress / 100f, progress / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        final SeekBar forestVolume = (SeekBar) view.findViewById(R.id.seekBar6);
        forestVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mediaPlayerForest.setVolume(progress / 100f, progress / 100f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}

        });

        buttonSoundsWind.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFav = !isFav;

                if(isFav){
                    windVolume.setScaleX(1);
                    windVolume.setScaleY(1);
                    buttonSoundsWind.setImageResource(R.drawable.wind_on);
                } else {
                    buttonSoundsWind.setImageResource(R.drawable.wind_off);
                    windVolume.setScaleX(0);
                    windVolume.setScaleY(0);
                }

                if (mediaPlayerWind.isPlaying()) {
                    mediaPlayerWind.pause();
                } else
                    mediaPlayerWind.start();
            }
        });

        buttonSoundBonfire.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFav2 = !isFav2;

                if(isFav2) {
                    bonfireVolume.setScaleX(1);
                    bonfireVolume.setScaleY(1);
                    buttonSoundBonfire.setImageResource(R.drawable.bonfire_on);
                } else {
                    bonfireVolume.setScaleX(0);
                    bonfireVolume.setScaleY(0);
                    buttonSoundBonfire.setImageResource(R.drawable.bonfire_off);
                }

                if (mediaPlayerBonfire.isPlaying()) {
                    mediaPlayerBonfire.pause();
                } else
                    mediaPlayerBonfire.start();
            }
        });

        buttonSoundJungle.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFav3 = !isFav3;

                if(isFav3) {
                    jungleVolume.setScaleX(1);
                    jungleVolume.setScaleY(1);
                    buttonSoundJungle.setImageResource(R.drawable.jungle_on);
                } else {
                    jungleVolume.setScaleX(0);
                    jungleVolume.setScaleX(0);
                    buttonSoundJungle.setImageResource(R.drawable.jungle_off);
                }

                if (mediaPlayerJungle.isPlaying()) {
                    mediaPlayerJungle.pause();
                } else
                    mediaPlayerJungle.start();
            }
        });

        buttonSoundBird.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFav4 = !isFav4;

                if(isFav4) {
                    birdVolume.setScaleX(1);
                    birdVolume.setScaleY(1);       
                } else {
                    birdVolume.setScaleX(0);
                    birdVolume.setScaleX(0);  
                }

                if (mediaPlayerBird.isPlaying()) {
                    mediaPlayerBird.pause();
                } else
                    mediaPlayerBird.start();
            }
        });

        buttonSoundPiano.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFav5 = !isFav5;

                if(isFav5) {
                    pianoVolume.setScaleX(1);
                    pianoVolume.setScaleY(1);
                    buttonSoundPiano.setImageResource(R.drawable.piano_on);
                } else {
                    pianoVolume.setScaleX(0);
                    pianoVolume.setScaleX(0);
                    buttonSoundPiano.setImageResource(R.drawable.piano_off);
                }

                if (mediaPlayerPiano.isPlaying()) {
                    mediaPlayerPiano.pause();
                } else
                    mediaPlayerPiano.start();
            }
        });

        buttonSoundForest.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                isFav6 = !isFav6;

                if(isFav6) {
                    forestVolume.setScaleX(1);
                    forestVolume.setScaleY(1);
                    //    buttonSoundJungle.setImageResource(R.drawable.jungle_on);
                } else {
                    forestVolume.setScaleX(0);
                    forestVolume.setScaleX(0);
                    //     buttonSoundJungle.setImageResource(R.drawable.jungle_off);
                }

                if (mediaPlayerForest.isPlaying()) {
                    mediaPlayerForest.pause();
                } else
                    mediaPlayerForest.start();
            }
        });
        return view;
    }
}
