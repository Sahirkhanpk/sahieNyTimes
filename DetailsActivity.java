package com.example.nytimesahir;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {
    String uri;
    String title;
    String detail;
    String date;
    public ImageView picture;

    public TextView Title;

    //*** code added ***
    public TextView Detail;

    public TextView Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.containsKey("title")) {
                title = String.valueOf(bundle.getString("title", ""));
            }
            if (bundle.containsKey("detail")) {
                detail = String.valueOf(bundle.getString("detail", ""));
            }
            if (bundle.containsKey("date")) {
               date = String.valueOf(bundle.getString("date", ""));
            }
            if (bundle.containsKey("title")) {
                uri = String.valueOf(bundle.getString("url", ""));
            }


            Title = findViewById(R.id.Dtitle);
            Detail = findViewById(R.id.DDetail);
            picture = findViewById(R.id.Dpicture);
            Date = findViewById(R.id.Ddate);


            Glide.with(DetailsActivity.this).load(uri).into(picture);


            Title.setText(title);
            Detail.setText(detail);
            Date.setText(date);

        }
    }
}
