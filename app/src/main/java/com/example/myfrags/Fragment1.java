package com.example.myfrags;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment1 extends Fragment {
    private LayoutInflater inflater;
    private ViewGroup container;
    private Bundle savedInstanceState;

    public interface OnButtonClickListener {
        public void onButtonClickShuffle();
        public void onButtonClickClockwise();
        public void onButtonClickHide();
        public void onButtonClickRestore();
    }

    private OnButtonClickListener callback = null;

    public void setOnButtonClickListener(OnButtonClickListener callback) {
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.inflater = inflater;
        this.container = container;
        this.savedInstanceState = savedInstanceState;

        View view = inflater.inflate(R.layout.fragment_1, container, false);
        
        Button buttonShuffle = (Button) view.findViewById(R.id.button_shuffle);
        Button buttonClockwise = (Button) view.findViewById(R.id.button_clockwise);
        Button buttonHide = (Button) view.findViewById(R.id.button_hide);
        Button buttonRestore = (Button) view.findViewById(R.id.button_restore);

        buttonShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) callback.onButtonClickShuffle();
            }
        });
        buttonClockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) callback.onButtonClickClockwise();
            }
        });
        buttonHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) callback.onButtonClickHide();
                }
        });
        buttonRestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (callback != null) callback.onButtonClickRestore();
            }
        });
        return view;
    }

}