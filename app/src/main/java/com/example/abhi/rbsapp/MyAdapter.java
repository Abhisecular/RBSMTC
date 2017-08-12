package com.example.abhi.rbsapp;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Activity activity;
    int[] images={R.drawable.business,R.drawable.computerscience,R.drawable.mca_dualwhite,R.drawable.mbat_white};
    String[] name={"Masters in Business Administration","Masters in Computer Application","Affiliated to APJAKTU","Abhi"};
    String[] subhead={"Affiliated to AKTU","Affiliated to AKTU","Affiliated to AKTU","Affiliated to AKTU"};

    public MyAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_course_list2, viewgroup, false);
        return new MyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.textView1.setText(name[position]);
        holder.textView2.setText(subhead[position]);

    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout linearLayout;
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;

        public ViewHolder(View view) {
            super(view);
            imageView= (ImageView) view.findViewById(R.id.course_img);
            textView1= (TextView) view.findViewById(R.id.course_head);
            textView2=(TextView) view.findViewById(R.id.course_desc);
            linearLayout= (LinearLayout) view.findViewById(R.id.course_col2);

        }
    }
}