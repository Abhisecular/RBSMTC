package com.example.abhi.rbsapp;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

/**
 * Created by Abhi on 04-03-2017.
 */
public class Programs extends Fragment {
    private RecyclerView recyclerView;
    private CourseList adapter;

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView=inflater.inflate(R.layout.progams, container, false);
            recyclerView= (RecyclerView) rootView.findViewById(R.id.rec_programs);
            GridLayoutManager gridLayout=new GridLayoutManager(getActivity(),2);
            ItemOffsetDecoration itemOffsetDecoration=new ItemOffsetDecoration(getContext(),R.dimen.item_offset);
            recyclerView.addItemDecoration(itemOffsetDecoration);
            recyclerView.setLayoutManager(gridLayout);
            adapter=new CourseList(this.getActivity());
            recyclerView.setAdapter(adapter);
            recyclerView.setHasFixedSize(true);
            return rootView;
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


