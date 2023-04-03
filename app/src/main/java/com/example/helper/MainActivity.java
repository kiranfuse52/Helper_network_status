package com.example.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    TextView textView;
    Helper helper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




                boolean status=helper.isConnected(MainActivity.this);

                if(status==true){
                    Toast.makeText(MainActivity.this, "Connected", Toast.LENGTH_SHORT).show();
                }else{

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("please check your connection");
                    builder.create();
                    builder .setCancelable(false);
                    builder.show();

                    }

                }





            }

