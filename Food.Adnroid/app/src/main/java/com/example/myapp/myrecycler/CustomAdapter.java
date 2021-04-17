package com.example.myapp.myrecycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.myapp.constants.Urls;
import com.example.myapp.network.ImageRequester;
import com.example.myapp.network.profile.dto.ProfileResultDTO;
import com.example.myapp.R;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    private List<ProfileResultDTO> modelList;
    private Context context;
    private ImageRequester imageRequester;

    public CustomAdapter(List<ProfileResultDTO> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
        imageRequester = ImageRequester.getInstance();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater
                .from(parent.getContext()).inflate(R.layout.row_item, parent, false);
        return new CustomViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        if (modelList != null && position < modelList.size()) {
            ProfileResultDTO model = modelList.get(position);
            holder.txt.setText(model.getUserName());
            holder.sub_txt.setText(model.getDisplayName());
            String url = Urls.BASE+"/images/" + model.getImage();
            imageRequester.setImageFromUrl((NetworkImageView) holder.img, url);
        }
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}
