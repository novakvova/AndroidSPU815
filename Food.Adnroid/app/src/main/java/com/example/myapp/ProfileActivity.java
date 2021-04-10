package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.myapp.network.profile.ApiWebService;
import com.example.myapp.network.profile.dto.ProfileResultDTO;
import com.example.myapp.utils.CommonUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        CommonUtils.showLoading(this);
        ApiWebService.getInstance()
                .getJSONApi()
                .profile()
                .enqueue(new Callback<ProfileResultDTO>() {
                    @Override
                    public void onResponse(Call<ProfileResultDTO> call, Response<ProfileResultDTO> response) {
//                        Log.d("super","Ok result good");
                        CommonUtils.hideLoading();
                        if(response.isSuccessful())
                        {
                            ProfileResultDTO result = response.body();
                            String image = result.getImage();
//                            String url = Urls.BASE+"/images/" + image;
//
//                            email.setText(result.getEmail());
//                            imageRequester.setImageFromUrl(imageView, url);
//                            name.setText(result.getUserName());
//                            phone.setText(result.getPhone());

//                            Log.d("Good Request", result.getToken());
                        }
                        else
                        {


                        }
                    }

                    @Override
                    public void onFailure(Call<ProfileResultDTO> call, Throwable t) {
                        Log.e("problem","problem API"+ t.getMessage());
                        CommonUtils.hideLoading();
                    }
                });
    }
}