package com.example.android.dejavu;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    public ImageView viewImageId1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("abc");
        TextView text = (TextView) findViewById(R.id.nameViewId);
        text.setText(name);


        String name1 = extras.getString("abd");
        TextView text1 = (TextView) findViewById(R.id.textViewId);
        text1.setText(name1);

        Bitmap bmp1 = extras.getParcelable("imageBitmap1");
        ImageView imageView1 = (ImageView) findViewById(R.id.viewImageId1);
        imageView1.setImageBitmap(bmp1);

    }
}
