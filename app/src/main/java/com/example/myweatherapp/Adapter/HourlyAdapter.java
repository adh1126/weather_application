package com.example.myweatherapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myweatherapp.Domains.Hourly;
import com.example.myweatherapp.databinding.ViewholderHourlyBinding;

import java.util.ArrayList;
import java.util.List;

public class HourlyAdapter extends RecyclerView.Adapter<HourlyAdapter.HourlyViewHolder> {
    private List<Hourly> hourlyList;

    public HourlyAdapter(List<Hourly> hourlyList) {
        this.hourlyList = hourlyList;
    }

    @Override
    public HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewholderHourlyBinding binding = ViewholderHourlyBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new HourlyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(HourlyViewHolder holder, int position) {
        Hourly hourly = hourlyList.get(position);
        holder.binding.TvHourTxt.setText(hourly.getHour());
        holder.binding.TvTempTxt.setText(String.format("%d°C", hourly.getTemp()));
        //holder.binding.tvWeather.setText(hourly.getWeather()); // Update weather icon later if needed
    }

    @Override
    public int getItemCount() {
        return hourlyList.size();
    }

    public static class HourlyViewHolder extends RecyclerView.ViewHolder {
        ViewholderHourlyBinding binding;

        public HourlyViewHolder(ViewholderHourlyBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
