package com.cropcart.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cropcart.R;

/**
 * Created by BHUSRI on 10/3/2017.
 */

public class OrderItem extends Fragment {
    private ImageView imageView;
    private TextView name, price, location;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.orderitem, container, false);
        bindviews(v);
        return v;
    }

    private void bindviews(View v) {
        imageView=
    }
}
