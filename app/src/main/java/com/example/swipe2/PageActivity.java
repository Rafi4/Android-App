package com.example.swipe2;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.swipe2.View.Activity1;
import com.example.swipe2.View.Activity2;
import com.example.swipe2.View.Activity3;

public class PageActivity extends FragmentPagerAdapter {

    private static final String TAG = MainActivity.class.getSimpleName();

    private int numberActivity;

    public PageActivity(FragmentManager fm, int numbeActivity) {
        super(fm);
        this.numberActivity = numbeActivity;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:
                return new Activity1();
            case 1:
                return new Activity2();
            case 2:
                return new Activity3();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberActivity;
    }

    @Override
    public int getItemPosition(@NonNull Object object) {

        return POSITION_NONE;
    }
}
