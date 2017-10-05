package com.cropcart.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ahmedjazzar.rosetta.LanguageSwitcher;
import com.cropcart.R;
import com.cropcart.fragments.ApprovalFrag;
import com.cropcart.fragments.ChatFrag;
import com.cropcart.fragments.ConsumerMainFrag;
import com.cropcart.fragments.EquipFrag;
import com.cropcart.fragments.FarmerMainFrag;
import com.cropcart.fragments.LabourersFrag;
import com.cropcart.fragments.MainFrag;
import com.cropcart.fragments.MyFarm;
import com.cropcart.fragments.OrderItem;
import com.cropcart.fragments.PostCommodity;
import com.cropcart.preferences.SharedPref;

import java.util.HashSet;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        SharedPref pref = new SharedPref(MainActivity.this);
        if (!pref.issignedin())
            startActivity(new Intent(MainActivity.this, Signup.class));
        if (pref.isfarmer()) {
            FarmerMainFrag frag = new FarmerMainFrag();
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).add(R.id.container, frag).commit();
        } else {
            ConsumerMainFrag frag = new ConsumerMainFrag();
            getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).add(R.id.container, frag).commit();
        }


    }

    public void postCommodity() {
        PostCommodity frag = new PostCommodity();
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, frag).commit();

    }

    public void chatfrag() {
        ChatFrag frag = new ChatFrag();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, frag).commit();

    }

    public void labourersfrag() {
        LabourersFrag frag = new LabourersFrag();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, frag).commit();

    }

    public void approvefrag() {
        ApprovalFrag frag = new ApprovalFrag();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, frag).commit();

    }

    public void equipmentsfrag() {
        EquipFrag frag = new EquipFrag();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, frag).commit();

    }

    public void myfarm() {
        MyFarm frag = new MyFarm();
        getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, frag).commit();

    }

    public void orderitem(String s) {
        OrderItem frag = new OrderItem();
        Bundle bundle = new Bundle();
        bundle.putString("data", s);
        frag.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().addToBackStack(null).setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, frag).commit();

    }
}
