package com.example.swipe2.ViewModel;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ShareViewModel extends ViewModel {

    private MutableLiveData<Drawable> image = new MutableLiveData<>();
    public void setImage(Drawable drawable) {
        Log.i("TAG", image+"SHAREDVIEWMODEL setImage it's work");
        image.setValue(drawable);
    }

    public LiveData<Drawable> getImage() {
        Log.i("TAG", "SHAREDVIEWMODEL getImage it's work");
        return image;
    }
}
