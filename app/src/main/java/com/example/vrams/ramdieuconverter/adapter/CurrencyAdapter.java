package com.example.vrams.ramdieuconverter.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.domain.currency.models.YahooCurrencyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrams on 3/24/2017.
 */

public class CurrencyAdapter extends RecyclerView.Adapter<CurrencyAdapter.ItemHolder> {
    List<YahooCurrencyModel> currencyModels;

    LayoutInflater inflater;

    public CurrencyAdapter(Context context){
        inflater = LayoutInflater.from(context);

        currencyModels = new ArrayList<>();
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_currency, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        YahooCurrencyModel model = currencyModels.get(position);
        holder.txtName.setText(model.getName());
        holder.txtTime.setText("" +  model.getDate() + " " + model.getTime());
        holder.txtRate.setText("" + model.getAsk());
    }

    public void setData(List<YahooCurrencyModel> models){
        currencyModels.clear();
        if(models != null){
            currencyModels.addAll(models);
        }
        Log.d("SIZE-->", currencyModels.size()+"");
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return currencyModels.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtRate;
        TextView txtTime;

        public ItemHolder(View itemView) {
            super(itemView);
            txtTime = (TextView) itemView.findViewById(R.id.txt_time);
            txtName = (TextView) itemView.findViewById(R.id.txt_name);
            txtRate = (TextView) itemView.findViewById(R.id.txt_rate);
        }
    }

}
