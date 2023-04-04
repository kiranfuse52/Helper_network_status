package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;

public class MainActivity extends AppCompatActivity {
 ;
    ImageView imageView;
    TextView textView;
    Helper helper;

    public static final int CAMERA=102;
    AlertDialog dialog;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageView);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("please check your connection");
        builder.setCancelable(false);

        dialog = builder.create();


        
        reverse();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                //                it access photo from Gallary

//               intent.setAction(Intent.ACTION_GET_CONTENT);
//                 it access photos from file.

            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

            Intent chooser = new Intent(Intent.ACTION_CHOOSER);
            chooser.putExtra(Intent.EXTRA_INTENT, intent);
            chooser.putExtra(Intent.EXTRA_TITLE, "Select from:");

            Intent[] intentArray = { cameraIntent };
            chooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, intentArray);
            startActivityForResult(chooser, CAMERA);
            }
        });
    }

    private void reverse() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                checkInternet();
                reverse();
            }
        }, 1000);
    }

    private void checkInternet() {
        boolean status = helper.isConnected(MainActivity.this);

        if (status == true) {
            dialog.cancel();

        } else {

            dialog.show();

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            Uri targetUri = data.getData();
//            uri is content provider

            Bitmap bitmap;
            //get each pixel value of image...

            try {
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                imageView.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }
        }


    }


}

