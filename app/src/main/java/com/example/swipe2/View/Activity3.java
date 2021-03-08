package com.example.swipe2.View;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.swipe2.Adapter_special;
import com.example.swipe2.R;
import com.example.swipe2.ViewModel.ShareViewModel;
import java.util.ArrayList;
import java.util.List;

public class Activity3 extends Fragment {

    RecyclerView getDataList;
    List<String> titles;
    List<Integer> images;
    Adapter_special adapterSpecial;

    ShareViewModel viewModel;
    ImageView imageView;
    RecyclerView dataList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab3, container, false);
        dataList = v.findViewById(R.id.dataList2);
        imageView = v.findViewById(R.id.imageFragment2);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Firsdt Item");
        titles.add("Second Items");
        titles.add("Third Item");
        titles.add("Fourhh Item");
        titles.add("Firsdt Item");
        titles.add("Second Items");
        titles.add("Third Item");
        titles.add("Fourhh Item");

        images.add(R.drawable.wind_on);
        images.add(R.drawable.tent_on);
        images.add(R.drawable.piano2_off);
        images.add(R.drawable.piano_on);
        images.add(R.drawable.tent_on);
        images.add(R.drawable.piano2_off);
        images.add(R.drawable.piano_on);
        images.add(R.drawable.piano2_off);
        images.add(R.drawable.piano_on);
        images.add(R.drawable.wind_on);

        adapterSpecial = new Adapter_special(getContext(), titles,images);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3,GridLayoutManager.VERTICAL,false);
        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapterSpecial);

        viewModel = new ViewModelProvider(requireActivity()).get(ShareViewModel.class);
        viewModel.getImage().observe(getViewLifecycleOwner(), new Observer<Drawable>() {
            @Override
            public void onChanged(Drawable drawable) {
                imageView.setImageDrawable(drawable);
                Log.i("TAG", viewModel+"ActivityWidget viewModel it's work");
                Log.i("TAG", imageView+"ActivityWidget imageView it's work");
            }
        });

        return v;
    }
}
