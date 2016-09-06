package com.example.android.dejavu;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.DatagramPacket;

public class TemplateActivity extends AppCompatActivity {

    public static final int IMAGE_GALLERY_REQUEST = 20;
    private ImageView imageViewId1;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);

        actionBar.setDisplayHomeAsUpEnabled(true);

        imageViewId1 = (ImageView) findViewById(R.id.imageViewId1);

        Button b1 = (Button) findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri data = Uri.parse(pictureDirectoryPath);
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
            }
        });




        Button saveButton = (Button) findViewById(R.id.saveButtonId);
        saveButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent i = new Intent(TemplateActivity.this, Main2Activity.class);
                Bundle extras = new Bundle();

                EditText e = (EditText) findViewById(R.id.editQueryId);
                String s = e.getText().toString();
                i.putExtra("abc", s);

                EditText e1 = (EditText) findViewById(R.id.editTextId);
                String s1 = e1.getText().toString();
                i.putExtra("abd", s1);

                i.putExtra("uri", imageUri.toString());

                ImageView im1 = (ImageView) findViewById(R.id.imageViewId1);
//                im1.buildDrawingCache();
//                Bitmap image1 = im1.getDrawingCache();
//
//                extras.putParcelable("imageBitmap1", image1);
//                i.putExtras(extras);

                startActivity(i);

            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_GALLERY_REQUEST) {

                // address of the image in SD card.
                imageUri = data.getData();

                // declaring a stream to read the image data from the SD card.
                InputStream inputStream;
                // getting an input stream, based on URI of the image.
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    // getting a bitmap from the stream.
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    // showing image to the user.

                    imageViewId1.setImageBitmap(image);

//                            Intent newIntent = new Intent(this, SummaryActivity.class);
//                            newIntent.putExtra("imageUri", imageUri);
//                            startActivity(newIntent);



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
