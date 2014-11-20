package com.gdgistanbul.devfestistanbul.fragment;



import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.gdgistanbul.devfestistanbul.DetailActivity;
import com.gdgistanbul.devfestistanbul.R;


public class TrackFragment extends Fragment {

    private int index;
    public static TrackFragment getInstance() {
        TrackFragment fragment = new TrackFragment();

        return fragment;
    }

    public void setArguments(int index){
        this.index=index;
    }
    public TrackFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if (index==0)
            return inflater.inflate(R.layout.fragment_track1, container, false);
        else if (index==1)
            return inflater.inflate(R.layout.fragment_track2, container, false);
        else if (index==2)
            return inflater.inflate(R.layout.fragment_track3, container, false);
        return inflater.inflate(R.layout.fragment_track4, container, false);
    }

}
