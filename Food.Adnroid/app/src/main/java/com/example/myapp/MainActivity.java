package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;



import com.android.volley.toolbox.NetworkImageView;
import com.example.myapp.network.ImageRequester;

public class MainActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView my_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = "https://cdn.mindful.org/What-I-Learned-From-My-Dog-Pandemic.jpg?q=80&fm=jpg&fit=crop&w=1400&h=875";

        imageRequester = ImageRequester.getInstance();
        my_logo = findViewById(R.id.my_logo_image);
        imageRequester.setImageFromUrl(my_logo, url);
    }
}