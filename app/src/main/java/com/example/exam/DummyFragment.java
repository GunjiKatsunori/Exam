package com.example.exam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;

/*
 * Fragmentを返すクラス
 */
public class DummyFragment extends Fragment {
    String data;
    View view;

    DummyFragment(String data) {
        this.data = data;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.dummy_fragment, null);


        // フラグメントの編集
        TextView textView = (TextView)view.findViewById(R.id.textView2);
        textView.setText(data);

        // 値を返す
        return view;
    }
}