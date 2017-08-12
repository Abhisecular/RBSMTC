package com.example.abhi.rbsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Abhi on 08-03-2017.
 */

public class CourseList extends RecyclerView.Adapter<CourseList.ViewHolder>{
    private Activity activity;
    int[] images={R.drawable.business,R.drawable.computerscience,R.drawable.mcadd,R.drawable.mbat};
    String[] name={"Masters in Business Administration","Masters in Computer Application","MCA (Integrated)","MBA (Tourism)"};
    String[] subhead={"Affiliated to AKTU","Affiliated to AKTU","Affiliated to AKTU","Affiliated to AKTU"};

    public CourseList(Activity activity) {
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.proglist, viewgroup, false);
        return new ViewHolder(view);
        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);
        holder.textView1.setText(name[position]);
        holder.textView2.setText(subhead[position]);

    }


    @Override
    public int getItemCount() {
        return images.length;
    }

    protected class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout linearLayout;
        private ImageView imageView;
        private TextView textView1;
        private TextView textView2;
        public final Context context;
        public ViewHolder(View view) {
            super(view);
            imageView= (ImageView) view.findViewById(R.id.course_img);
            textView1= (TextView) view.findViewById(R.id.course_head);
            textView2=(TextView) view.findViewById(R.id.course_desc);
            linearLayout= (LinearLayout) view.findViewById(R.id.course_col2);
            context=view.getContext();
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (this.getLayoutPosition()) {
                case 0:
                    intent=new Intent(context,mba.class);
                    break;
                case 1:
                    intent = new Intent(context, mca.class);
                    break;
                case 2:
                    intent = new Intent(context, mcadual.class);
                    break;
                case 3:
                    intent=new Intent(context, mbadual.class);
                    break;
                default:
                    intent=new Intent(context,Programs.class);
            }
            context.startActivity(intent);

        }
    }
}