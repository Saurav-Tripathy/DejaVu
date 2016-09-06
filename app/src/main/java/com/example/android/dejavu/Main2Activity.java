package com.example.android.dejavu;

import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        String name = extras.getString("abc");
        Log.i("test", name);
        TextView text = (TextView) findViewById(R.id.nameViewId);
        text.setText(name);

        String name1 = extras.getString("abd");
        Log.i("test 1", name1);
        TextView text1 = (TextView) findViewById(R.id.textViewId);
        text1.setText(name1);

        Uri uri = Uri.parse(extras.getString("uri"));
        Log.i("test", uri.toString());



//        Bitmap bmp1 = extras.getParcelable("imageBitmap1");
//        Log.i("test 2", "asdad");
        ImageView imageView1 = (ImageView) findViewById(R.id.viewImageId1);
//        imageView1.setImageBitmap(bmp1);


        Picasso.with(getBaseContext()).load(uri).placeholder(R.drawable.m1).into(imageView1);
    }
}
