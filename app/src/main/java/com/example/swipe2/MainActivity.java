package com.example.swipe2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.swipe2.View.SpecialFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();



    Animation bounce;

    private ViewPager viewPager;
    public PagerAdapter pageradapter;

     EditText mEditTextInput;
     TextView mTextViewCountDown;
     Button mButtonStartPause, buttonWidget;
     public Button mButtonReset;
     public CountDownTimer mCountDownTimer;
     public boolean mTimerRunning;
     public long mStartTimeInMillis;
     public long mTimeLeftInMillis;
     public long mEndTime;

    ProgressBar pb;

    int i;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  List<Book> bookList = new ArrayList<>();
      //  Adapter_activity3 adapter = new Adapter_activity3(bookList);




        getSupportFragmentManager().beginTransaction()
                .add(R.id.specialFragmento, new SpecialFragment())
                .commit();


        pb = findViewById(R.id.progressCricle);
        mEditTextInput = findViewById(R.id.edit_text_input);
        mTextViewCountDown = findViewById(R.id.text_view_countdown);
      //  mButtonSet = findViewById(R.id.button_set);
        mButtonStartPause = findViewById(R.id.button_start_pause);
        mButtonReset = findViewById(R.id.button_reset);

      //  buttonWidget = findViewById(R.id.buttonW);

        bounce = AnimationUtils.loadAnimation(this, R.anim.bounce);
     //   bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
         TabItem tab1 = (TabItem) findViewById(R.id.Tab1);
         TabItem tab2 = (TabItem) findViewById(R.id.Tab2);
         TabItem tab3 = (TabItem) findViewById(R.id.Tab3);

        viewPager= findViewById(R.id.viewpager);
        pageradapter = new PageActivity(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pageradapter);



      /*     buttonWidget.setOnClickListener(new View.OnClickListener() {
               @Override
                public void onClick(View view) {
                       Intent intent = new Intent(view.getContext(), ActivityWidget.class);
                       startActivity(intent);
                     Log.i(TAG , "button działa");
                }
            });*/

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 3) {
                pageradapter.notifyDataSetChanged();
            } else if (tab.getPosition() == 3) {
                pageradapter.notifyDataSetChanged();
            } else if (tab.getPosition() == 3) {
                pageradapter.notifyDataSetChanged();
            }
        }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

             }
        });

              viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        // Reset Timer
        // Możliwy Crasch przez  pb.setProgress(60);


        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
               // pb.setProgress(60);

            }
        });
    }

    // Przycisk OK na klawiaturze
    // Możliwy Crash przez  pb.setProgress(60);

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
                pb.setProgress(60);

                String input = mEditTextInput.getText().toString();
                if (input.length() == 0) {
                    Toast.makeText(MainActivity.this, "Field can't be empty", Toast.LENGTH_SHORT).show();
                    return true;
                }

                long millisInput = Long.parseLong(input) * 60000;
                if (millisInput == 0) {
                    Toast.makeText(MainActivity.this, "Please enter a positive number", Toast.LENGTH_SHORT).show();
                    return true;
                }

                setTime(millisInput);
                mEditTextInput.setText("");
            default:
                return super.onKeyUp(keyCode, event);
        }

    }

    private void makeToast (String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    // Start Timer

    public void startTimer() {



        Animation bottom = AnimationUtils.loadAnimation(this, R.anim.bounce);
        mEditTextInput.startAnimation(bottom);

        Log.i("Start", "start time");
        mEndTime = System.currentTimeMillis() + mTimeLeftInMillis;
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
              i = (int) mTimeLeftInMillis / 1000 % 60;
                pb.setProgress(i);

            }

            @Override
            public void onFinish() {
                mTimerRunning = false;
                updateWatchInterface();
                System.exit(0);

               // mediaPlayerBonfire.pause();

            }
        }.start();
        mTimerRunning = true;
        updateWatchInterface();
    }

    public void pauseTimer() {
        mCountDownTimer.cancel();
        mTimerRunning = false;
        updateWatchInterface();
    }

    public void resetTimer() {
        mTimeLeftInMillis = i = (int) mStartTimeInMillis;
     //   mProgressBar.setProgress(i);
        updateCountDownText();
        updateWatchInterface();
        pb.setProgress(i);
    }

    public void setTime(long milliseconds) {
        mStartTimeInMillis = milliseconds;
        resetTimer();
        //   closeKeyboard();

    }

    public void updateCountDownText() {
        int hours = (int) (mTimeLeftInMillis / 1000) / 3600;
        int minutes = (int) ((mTimeLeftInMillis / 1000) % 3600) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted;
        if (hours > 0) {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeLeftFormatted = String.format(Locale.getDefault(),
                    "%02d:%02d", minutes, seconds);
        }
        mTextViewCountDown.setText(timeLeftFormatted);
    }

    public void updateWatchInterface() {
        if (mTimerRunning) {
            mEditTextInput.setVisibility(View.INVISIBLE);
       //     mButtonSet.setVisibility(View.INVISIBLE);
            mButtonReset.setVisibility(View.INVISIBLE);
            mButtonStartPause.setText("Pause");
        } else {
            mEditTextInput.setVisibility(View.VISIBLE);
      //      mButtonSet.setVisibility(View.VISIBLE);
            mButtonStartPause.setText("Start");
            if (mTimeLeftInMillis < 1000) {
                mButtonStartPause.setVisibility(View.INVISIBLE);
            } else {
                mButtonStartPause.setVisibility(View.VISIBLE);
            }
            if (mTimeLeftInMillis < mStartTimeInMillis) {
                mButtonReset.setVisibility(View.VISIBLE);
            } else {
                mButtonReset.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putLong("startTimeInMillis", mStartTimeInMillis);
        editor.putLong("millisLeft", mTimeLeftInMillis);
        editor.putBoolean("timerRunning", mTimerRunning);
        editor.putLong("endTime", mEndTime);
        editor.apply();
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        mStartTimeInMillis = prefs.getLong("startTimeInMillis", 600000);
        mTimeLeftInMillis = prefs.getLong("millisLeft", mStartTimeInMillis);
        mTimerRunning = prefs.getBoolean("timerRunning", false);
        updateCountDownText();
        updateWatchInterface();
        if (mTimerRunning) {
            mEndTime = prefs.getLong("endTime", 0);
            mTimeLeftInMillis = mEndTime - System.currentTimeMillis();
            if (mTimeLeftInMillis < 0) {
                mTimeLeftInMillis = 0;
                mTimerRunning = false;
                updateCountDownText();
                updateWatchInterface();
            } else {
                startTimer();
            }
        }
    }


/*
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy in Main");
    }
*/

}