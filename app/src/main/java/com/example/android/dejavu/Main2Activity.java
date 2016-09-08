package com.example.android.dejavu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final Bundle extras = getIntent().getExtras();

        // Getting the memory name..
        final String name = extras.getString("abc");
        Log.i("test", name);
        TextView text = (TextView) findViewById(R.id.nameViewId);
        // Setting the name of the memory in the specified view..
        text.setText(name);

        // Getting the description of the memory..
        final String name1 = extras.getString("abd");
        Log.i("test 1", name1);
        TextView text1 = (TextView) findViewById(R.id.textViewId);
        // Setting the description to the specified view..
        text1.setText(name1);

        // Getting the Uri of the image..
        Uri uri = Uri.parse(extras.getString("uri"));
        Log.i("test", uri.toString());
        ImageView imageView1 = (ImageView) findViewById(R.id.viewImageId1);
        // Setting it to the specified space..
        Picasso.with(getBaseContext()).load(uri).placeholder(R.drawable.m1).into(imageView1);

        Button button = (Button) findViewById(R.id.sendMail);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, "mailfrom:");
                intent.putExtra(Intent.EXTRA_SUBJECT, "DejaVu of our happy memory.");
                intent.putExtra(Intent.EXTRA_TEXT, name);
                intent.putExtra(Intent.EXTRA_TEXT, name1);
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse(extras.getString("uri")));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);

                }
            }


        });
    }
}
