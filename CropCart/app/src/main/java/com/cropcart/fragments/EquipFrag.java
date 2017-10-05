package com.cropcart.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.cropcart.R;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BHUSRI on 10/3/2017.
 */

public class EquipFrag extends Fragment {
    private String keys[] = {"Tractor", "Conveyor belt", "Grain dryer", "Grain cart", "Buckrake", "Hydroponics", "Trowel"};
    private ArrayList<String> selectedcategories = new ArrayList<>();
    private List<TextView> textviews = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.equipments, container, false);
        FlexboxLayout flexboxLayout = v.findViewById(R.id.flexbox);
        for (int i = 0; i < keys.length; i++) {
            View subchild = getLayoutInflater().inflate(R.layout.single_chip, null);
            final TextView tv = subchild.findViewById(R.id.txt_title);
            tv.setText(keys[i]);
            final int finalI = i;
            final String[] finalKeys = keys;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (tv.getTag() != null && tv.getTag().equals("selected")) {
                        tv.setTag("unselected");
                        tv.setBackgroundResource(R.drawable.chip_unselected);
                        tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.filters_chips));
                        removeFromSelectedMap(finalKeys[finalI]);
                    } else {
                        tv.setTag("selected");
                        tv.setBackgroundResource(R.drawable.chip_selected);
                        tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.filters_header));
                        addToSelectedMap(finalKeys[finalI]);
                    }
                }
            });

            if (selectedcategories.contains(keys[finalI])) {
                tv.setTag("selected");
                tv.setBackgroundResource(R.drawable.chip_selected);
                tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.filters_header));
            } else {
                tv.setBackgroundResource(R.drawable.chip_unselected);
                tv.setTextColor(ContextCompat.getColor(getActivity(), R.color.filters_chips));
            }
            textviews.add(tv);

            flexboxLayout.addView(subchild);
        }
        TextView submit = v.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setNetworkRequest();
            }
        });
        return v;
    }

    private void setNetworkRequest() {
        Toast.makeText(getActivity(), "Request Submitted", Toast.LENGTH_SHORT).show();
    }

    private void addToSelectedMap(String value) {
        selectedcategories.add(value);
    }

    private void removeFromSelectedMap(String value) {
        selectedcategories.remove(value);
    }
}
