package com.app.android.imagegallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.PhotoView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    RecyclerView horizontal_recycler_view;
    HorizontalAdapter horizontalAdapter;
    private List<Data> data;


    PhotoView fullScreenImage;
    boolean isImageFitToScreen;

    Button skipButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        horizontal_recycler_view = (RecyclerView) findViewById(R.id.horizontal_recycler_view);

        data = fillWithData();

        fullScreenImage = (PhotoView) findViewById(R.id.fullScreenImageView);
        skipButton = (Button) findViewById(R.id.fullScreenSkipButton);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                skipButton.setVisibility(View.GONE);
                horizontal_recycler_view.setVisibility(View.VISIBLE);
                fullScreenImage.setVisibility(View.GONE);
                fullScreenImage.setImageResource(R.drawable.img1);
            }
        });

        horizontalAdapter = new HorizontalAdapter(data, getApplication(), new ImageCallback() {
            @Override
            public void onClick(int imageId) {
                if(isImageFitToScreen) {

                } else {
                    skipButton.setVisibility(View.VISIBLE);
                    horizontal_recycler_view.setVisibility(View.GONE);
                    fullScreenImage.setVisibility(View.VISIBLE);
                    fullScreenImage.setImageResource(imageId);
                }
            }
        });

        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(HomeActivity.this, LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(horizontalAdapter);
    }

    public List<Data> fillWithData() {

        List<Data> data = new ArrayList<>();

        data.add(new Data( R.drawable.img1, "Image 1"));
        data.add(new Data( R.drawable.img2, "Image 2"));
        data.add(new Data( R.drawable.img3, "Image 3"));
        data.add(new Data( R.drawable.img4, "Image 4"));
        data.add(new Data( R.drawable.img5, "Image 5"));
        data.add(new Data( R.drawable.img6, "Image 6"));
        data.add(new Data( R.drawable.img1, "Image 1"));
        data.add(new Data( R.drawable.img2, "Image 2"));
        data.add(new Data( R.drawable.img3, "Image 3"));


        return data;
    }
}
