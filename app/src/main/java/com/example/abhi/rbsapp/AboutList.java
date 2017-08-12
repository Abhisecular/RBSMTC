package com.example.abhi.rbsapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
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

public class AboutList extends RecyclerView.Adapter<AboutList.ViewHolder> {
    private Activity activity;
    int[] images={R.drawable.hist3green,R.drawable.society,R.drawable.theinst,R.drawable.dirmess};
    String[] name={"Abhi","Abhi","Abhi","Abhi"};

    public AboutList(Activity activity) {
        this.activity = activity;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewgroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.aboutlist, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(images[position]);

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
        CardView cardView;
        public final Context context;
        public ViewHolder(View view) {
            super(view);
            imageView= (ImageView) view.findViewById(R.id.about_img);
            //textView1= (TextView) view.findViewById(R.id.course_head);
            //textView2=(TextView) view.findViewById(R.id.course_desc);
            linearLayout= (LinearLayout) view.findViewById(R.id.about_col2);
            cardView=(CardView)view.findViewById(R.id.course_col);
            context=view.getContext();
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Intent intent;
            switch (this.getLayoutPosition()) {
                case 0:
                    intent=new Intent(context,history.class);
                    break;
                case 1:
                    intent = new Intent(context, Society.class);
                    break;
                case 2:
                    intent = new Intent(context, Institute.class);
                    break;
                case 3:
                    intent=new Intent(context, Dir_message.class);
                    break;
                default:
                    intent=new Intent(context,Programs.class);
            }
                context.startActivity(intent);
            }
        }
    }
