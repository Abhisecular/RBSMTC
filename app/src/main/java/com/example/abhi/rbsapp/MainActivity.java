package com.example.abhi.rbsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

public class MainActivity extends Fragment {
    ViewPager viewpager;
    SwipeAdapter adapter;
    ViewPager vp;
    TextView textanim;
    TabLayout tabLayout;
    LayoutInflater layoutInflater;
    public MainActivity(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.activity_main,container,false);
        Activity activity=this.getActivity();
        Drawable d = ContextCompat.getDrawable(activity.getApplicationContext(),R.drawable.rbsmainmod);
        final ActionBar actionBar=((AppCompatActivity)getActivity()).getSupportActionBar();

        actionBar.setBackgroundDrawable(d);

        viewpager= (ViewPager) view.findViewById(R.id.view_p1);
        adapter=new SwipeAdapter(view.getContext());
        viewpager.setAdapter(adapter);
        vp= (ViewPager) view.findViewById(R.id.view_p2);

        vp.setAdapter(new CustomAdapter(getActivity().getSupportFragmentManager(),activity.getApplicationContext()));
        tabLayout= (TabLayout) view.findViewById(R.id.tabL1);
        tabLayout.setupWithViewPager(vp);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());

            }

        });
        return view;
    }


    private class CustomAdapter extends FragmentStatePagerAdapter {

        private String fragments [] = {"About Us","Overview"};

        public CustomAdapter(FragmentManager supportFragmentManager, Context applicationContext) {
            super(supportFragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new AboutUS();
                case 1:
                    return new Overview();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return fragments[position];
        }
    }

    }



