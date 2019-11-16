package com.example.midterm;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.midterm.DataModel.Games;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<Games> {

    private ArrayList<Games> dataset;
    private Context context;

    private static class ViewHolder{
        TextView tvName;
        TextView tvRate;
        TextView tvPrice;
    }

    public Adapter(ArrayList<Games> data, Context context){

        super (context,R.layout.activity_adapter,data);
        this.dataset = data;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Games game = getItem(position);

        ViewHolder holder;

        if(convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_adapter,parent,false);

            holder.tvName = convertView.findViewById(R.id.tv_Name);
            holder.tvRate = convertView.findViewById(R.id.tv_Rate);
            holder.tvPrice = convertView.findViewById(R.id.tv_Price);

            convertView.setTag(holder);

        }else{
        holder = (ViewHolder)convertView.getTag();
    }

        holder.tvName.setText(game.getName());
        holder.tvRate.setText(game.getRate());
        holder.tvPrice.setText(game.getPrice());

        return convertView;
    }
}
