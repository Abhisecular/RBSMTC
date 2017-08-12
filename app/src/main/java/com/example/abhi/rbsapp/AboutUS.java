package com.example.abhi.rbsapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by Abhi on 04-03-2017.
 */
public class AboutUS extends Fragment {
    private RecyclerView recyclerView;
    private AboutList adapter;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.aboutus, container, false);
        recyclerView= (RecyclerView) rootView.findViewById(R.id.rec_about);
        GridLayoutManager gridLayout=new GridLayoutManager(getActivity(),2);

        ItemOffsetDecoration itemOffsetDecoration=new ItemOffsetDecoration(getContext(),R.dimen.item_offset2);
        recyclerView.addItemDecoration(itemOffsetDecoration);
        recyclerView.setLayoutManager(gridLayout);
        adapter=new AboutList(this.getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        return rootView;

    }
    public boolean onKeyDown(int keycode, KeyEvent event){
        if ((keycode == KeyEvent.KEYCODE_BACK)) {
            Intent intent=new Intent(this.getContext(), Main2Activity.class);
            startActivity(intent);
            return true;

        }
        return false;
    }


    public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {

        private int mItemOffset;

        public ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent,
                                   RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }
}


