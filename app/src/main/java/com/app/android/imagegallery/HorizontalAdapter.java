package com.app.android.imagegallery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    List<Data> horizontalList = Collections.emptyList();
    Context context;
    ImageCallback onImageClickCallback;


    public HorizontalAdapter(List<Data> horizontalList, Context context, ImageCallback imageClickCallback) {
        this.horizontalList = horizontalList;
        this.context = context;
        this.onImageClickCallback = imageClickCallback;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        LinearLayout layout;
        //TextView textView;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageview);
            layout = (LinearLayout) view.findViewById(R.id.linearlayout);
            //textView=(TextView) view.findViewById(R.id.textview);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_menu, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        holder.imageView.setImageResource(horizontalList.get(position).imageId);
        //holder.textView.setText(horizontalList.get(position).text);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String list = horizontalList.get(position).text.toString();
                //Toast.makeText(context, list, Toast.LENGTH_SHORT).show();
                onImageClickCallback.onClick(horizontalList.get(position).imageId);
            }

        });

    }


    @Override
    public int getItemCount()
    {
        return horizontalList.size();
    }


}
