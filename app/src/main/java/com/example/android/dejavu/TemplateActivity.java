package com.example.android.dejavu;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

public class TemplateActivity extends AppCompatActivity {

    public static final int IMAGE_GALLERY_REQUEST = 20;
    public int s = 0;
    private ImageView imageViewId1;
    private ImageView imageViewId2;
    private ImageView imageViewId3;
    private ImageView imageViewId4;
    private ImageView imageViewId5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_template);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        imageViewId1 = (ImageView) findViewById(R.id.imageViewId1);
        imageViewId2 = (ImageView) findViewById(R.id.imageViewId2);
        imageViewId3 = (ImageView) findViewById(R.id.imageViewId3);
        imageViewId4 = (ImageView) findViewById(R.id.imageViewId4);
        imageViewId5 = (ImageView) findViewById(R.id.imageViewId5);

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
                s = 1;
            }
        });

        Button b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri data = Uri.parse(pictureDirectoryPath);
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
                s = 2;
            }
        });

        Button b3 = (Button) findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri data = Uri.parse(pictureDirectoryPath);
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
                s = 3;
            }
        });

        Button b4 = (Button) findViewById(R.id.button4);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri data = Uri.parse(pictureDirectoryPath);
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
                s = 4;
            }
        });

        Button b5 = (Button) findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                Uri data = Uri.parse(pictureDirectoryPath);
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent, IMAGE_GALLERY_REQUEST);
                s = 5;
            }
        });


        Button saveButton = (Button) findViewById(R.id.saveButtonId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_GALLERY_REQUEST) {

                // address of the image in SD card.
                Uri imageUri = data.getData();

                // declaring a stream to read the image data from the SD card.
                InputStream inputStream;
                // getting an input stream, based on URI of the image.
                try {
                    inputStream = getContentResolver().openInputStream(imageUri);
                    // getting a bitmap from the stream.
                    Bitmap image = BitmapFactory.decodeStream(inputStream);
                    // showing image to the user.

                    switch (s) {
                        case 1:
                            imageViewId1.setImageBitmap(image);
                            break;

                        case 2:
                            imageViewId2.setImageBitmap(image);
                            break;

                        case 3:
                            imageViewId3.setImageBitmap(image);
                            break;

                        case 4:
                            imageViewId4.setImageBitmap(image);
                            break;

                        case 5:
                            imageViewId5.setImageBitmap(image);
                            break;

                        default:
                            Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();

                    }

//                    imageViewId1.setImageBitmap(image);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    Toast.makeText(this, "Unable to open image", Toast.LENGTH_LONG).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //        final ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButtonId1);
//        imageButton1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(intent, REQUEST_CODE);
//            }
//
//            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//                if (resultCode != RESULT_OK)
//                    return;
//
//                if (requestCode == PICK_FROM_GALLERY) {
//                    Uri mImageURI = data.getData();
//                    saveImage(mImageURI);
//                }

//                if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK)
//                    try {
//                        We need to recycle unused bitmaps
//                        if (bitmap != null) {
//                            bitmap.recycle();
//                        }
//                        InputStream stream = getContentResolver().openInputStream(
//                                data.getData());
//                        bitmap = BitmapFactory.decodeStream(stream);
//                        stream.close();
//                        imageView.setImageBitmap(bitmap);
//                    } catch (FileNotFoundException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                onActivityResult(requestCode, resultCode, data);
//            }

//            public void saveImage(Uri imageUri){
//
//            }
//
//        });


//        final ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButtonId2);
//        imageButton2.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(this, );
//                startActivity(intent);
//            }
//        });
//
//        final ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButtonId3);
//        imageButton3.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(this, );
//                startActivity(intent);
//            }
//        });
//
//        final ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButtonId4);
//        imageButton4.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(this, );
//                startActivity(intent);
//            }
//        });
//
//        final ImageButton imageButton5 = (ImageButton) findViewById(R.id.imageButtonId5);
//        imageButton5.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(this, );
//                startActivity(intent);
//            }
//        });
//
//
//


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
