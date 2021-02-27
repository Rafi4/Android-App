package com.example.swipe2.View;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.swipe2.R;
import com.example.swipe2.ViewModel.ShareViewModel;

public class Activity1 extends Fragment implements SeekBar.OnSeekBarChangeListener, View.OnClickListener {



    private View fragmentView;
    ShareViewModel viewModel;


    private static final String TAG = Activity1.class.getSimpleName();

    Button button;

    ImageButton buttonSoundsWind, buttonSoundBonfire, buttonSoundJungle, buttonSoundBird, buttonSoundPiano, buttonSoundForest;
    MediaPlayer mediaPlayerWind, mediaPlayerBonfire, mediaPlayerJungle, mediaPlayerBird, mediaPlayerPiano,mediaPlayerForest;
    SeekBar windVolume, bonfireVolume;
   public boolean isFav = false, isFav2 = false, isFav3 = false, isFav4 = false, isFav5 = false, isFav6 =false;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        if (fragmentView != null) {
            return fragmentView;
        }


        fragmentView = view;



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
    //    mediaPlayerBonfire.setVolume(1f, 1f);
        mediaPlayerBonfire.setLooping(true);
        mediaPlayerJungle.setVolume(1f, 1f);
        mediaPlayerJungle.setLooping(true);
        mediaPlayerBird.setVolume(1f,1f);
        mediaPlayerBird.setLooping(true);
        mediaPlayerPiano.setVolume(1f,1f);
        mediaPlayerPiano.setLooping(true);
        mediaPlayerForest.setVolume(1f,1f);
        mediaPlayerForest.setLooping(true);

        windVolume = view.findViewById(R.id.seekBar);
        bonfireVolume = view.findViewById(R.id.seekBar2);



      //  final SeekBar bonfireVolume = (SeekBar) view.findViewById(R.id.seekBar2);
        final SeekBar jungleVolume = (SeekBar) view.findViewById(R.id.seekBar3);
        final SeekBar birdVolume = (SeekBar) view.findViewById(R.id.seekBar4);
        final SeekBar pianoVolume = (SeekBar) view.findViewById(R.id.seekBar5);
        final SeekBar forestVolume = (SeekBar) view.findViewById(R.id.seekBar6);

        windVolume.setOnSeekBarChangeListener(this);
        bonfireVolume.setOnSeekBarChangeListener(this);
        jungleVolume.setOnSeekBarChangeListener(this);
        birdVolume.setOnSeekBarChangeListener(this);
        pianoVolume.setOnSeekBarChangeListener(this);
        forestVolume.setOnSeekBarChangeListener(this);
        
        buttonSoundsWind.setOnClickListener(this);



        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        Log.i(TAG, "onActivityCreated");

  //      button.setOnClickListener(this);


    //    final Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);

  /*     buttonSoundsWind.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                windVolume.startAnimation(bottom);
                isFav =! isFav;
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
        });*/





        buttonSoundBonfire.setOnClickListener(new ImageView.OnClickListener()

          {
              @Override
              public void onClick (View v){

              Log.i("TAG", viewModel+"ACTIVITY 1 viewModel it's work");

              Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
              bonfireVolume.startAnimation(bottom);
              isFav2 =! isFav2;
              if (isFav2) {
                  bonfireVolume.setScaleX(1);
                  bonfireVolume.setScaleY(1);
                  viewModel.setImage(buttonSoundBonfire.getDrawable());
                  buttonSoundBonfire.setImageResource(R.drawable.bonfire_on);


              } else {
                  bonfireVolume.setScaleX(0);
                  bonfireVolume.setScaleY(0);
                  buttonSoundBonfire.setImageResource(R.drawable.bonfire_off);
                  viewModel.setImage(null);
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
                Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                jungleVolume.startAnimation(bottom);

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
                Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                birdVolume.startAnimation(bottom);

                isFav4 = !isFav4;
                if(isFav4) {
                    birdVolume.setScaleX(1);
                    birdVolume.setScaleY(1);
                    buttonSoundBird.setImageResource(R.drawable.origami_on);
                } else {
                    birdVolume.setScaleX(0);
                    birdVolume.setScaleX(0);
                    buttonSoundBird.setImageResource(R.drawable.origami_off);
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
                Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                pianoVolume.startAnimation(bottom);


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
                Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                forestVolume.startAnimation(bottom);

                isFav6 = !isFav6;
                if(isFav6) {
                    forestVolume.setScaleX(1);
                    forestVolume.setScaleY(1);
                    buttonSoundForest.setImageResource(R.drawable.tent_on);
                } else {
                    forestVolume.setScaleX(0);
                    forestVolume.setScaleX(0);
                    buttonSoundForest.setImageResource(R.drawable.tent_off);
                }
                if (mediaPlayerForest.isPlaying()) {
                    mediaPlayerForest.pause();
                } else
                    mediaPlayerForest.start();
            }
        });


        Log.i(TAG, "Only Activity1");



        return view;
    }

    private void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {

        switch (seekBar.getId()) {
            case R.id.seekBar:
                mediaPlayerWind.setVolume(progress / 100f, progress / 100f);
                seekBar.setProgress(100);
                break;
          case R.id.seekBar2:
                mediaPlayerBonfire.setVolume(progress / 100f, progress / 100f);
                break;
            case R.id.seekBar3:
                mediaPlayerJungle.setVolume(progress /100f, progress / 100f);
                break;
            case R.id.seekBar4:
                mediaPlayerBird.setVolume(progress /100f, progress / 100f);
                break;
            case R.id.seekBar5:
                mediaPlayerPiano.setVolume(progress /100f, progress / 100f);
                break;
            case R.id.seekBar6:
                mediaPlayerForest.setVolume(progress /100f, progress / 100f);
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.windImage:
                Animation bottom = AnimationUtils.loadAnimation(getActivity(), R.anim.bounce);
                Log.i(TAG, "button wind");
                windVolume.startAnimation(bottom);
                isFav =! isFav;
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
                break;
        }
        }
    }
