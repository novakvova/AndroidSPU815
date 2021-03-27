package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;


import com.android.volley.toolbox.NetworkImageView;
import com.example.myapp.constants.Urls;
import com.example.myapp.network.ImageRequester;
import com.example.myapp.network.account.AccountService;
import com.example.myapp.network.account.dto.LoginDto;
import com.example.myapp.network.account.dto.LoginResultDto;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ImageRequester imageRequester;
    private NetworkImageView my_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = Urls.BASE +"/images/1.jpg";//        "https://cdn.mindful.org/What-I-Learned-From-My-Dog-Pandemic.jpg?q=80&fm=jpg&fit=crop&w=1400&h=875";

        imageRequester = ImageRequester.getInstance();
        my_logo = findViewById(R.id.my_logo_image);
        imageRequester.setImageFromUrl(my_logo, url);
    }
    public void OnClickLogin(View view) {
        final TextInputEditText email = findViewById(R.id.textInputEmail);
        final TextInputLayout emailLayout = findViewById(R.id.textFieldEmail);

        final TextInputEditText password = findViewById(R.id.textInputPassword);
        final TextInputLayout passwordLayout = findViewById(R.id.textFieldPassword);

        LoginDto dto = new LoginDto(email.getText().toString(),
                password.getText().toString());

//        if(dto.getEmail().isEmpty())
//        {
//            emailLayout.setError("Вкажіть пошту!");
//        }
//        else
//            emailLayout.setError("");
//        Log.d("btnLogin", email.getText().toString());

        AccountService.getInstance()
                .getJSONApi()
                .login(dto)
                .enqueue(new Callback<LoginResultDto>() {
                    @Override
                    public void onResponse(Call<LoginResultDto> call, Response<LoginResultDto> response) {
                        if(response.isSuccessful())
                        {

                        }
                        else
                        {
                            try {
                                String json = response.errorBody().string();
                                Log.d("error info", json);
                            }catch(Exception ex) {
                                Log.e("errorRead", "Error read json");
                            }

                        }
                        //Log.d("request", "IS GOOD");
                    }

                    @Override
                    public void onFailure(Call<LoginResultDto> call, Throwable t) {
                        Log.d("request", "IS Problem");
                    }
                });

    }
}