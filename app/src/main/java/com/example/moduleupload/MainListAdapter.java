package com.example.moduleupload;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.moduleupload.databinding.AdapterItemMainlistBinding;
import com.example.networkmanager_retrofitrxjava.MyBanner;

import java.util.List;
import java.util.Random;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.MyViewHolder> {

    private Context context;
    private List<MyBanner> list;

    public MainListAdapter(Context context, List<MyBanner> list){
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_item_mainlist, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyBanner banner = list.get(position);
        if (banner.getImagePath()!=null) {
            Glide.with(context).load(banner.getImagePath()).into(holder.getAdapterItemMainlistBinding().imageView);
        }
        int colorArr[] = {Color.LTGRAY, Color.BLUE, Color.RED, Color.GREEN, Color.YELLOW};
        int color = colorArr[new Random().nextInt(colorArr.length)];
        holder.getAdapterItemMainlistBinding().content.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private AdapterItemMainlistBinding adapterItemMainlistBinding;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            adapterItemMainlistBinding = AdapterItemMainlistBinding.bind(itemView);
        }
        public AdapterItemMainlistBinding getAdapterItemMainlistBinding(){
            return adapterItemMainlistBinding;
        }
    }
}
