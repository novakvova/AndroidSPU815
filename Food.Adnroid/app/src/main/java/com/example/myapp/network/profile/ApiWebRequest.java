package com.example.myapp.network.profile;

import com.example.myapp.network.profile.dto.ProfileResultDTO;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiWebRequest {
    @GET("/api/user/profile")
    public Call<ProfileResultDTO> profile();
}
