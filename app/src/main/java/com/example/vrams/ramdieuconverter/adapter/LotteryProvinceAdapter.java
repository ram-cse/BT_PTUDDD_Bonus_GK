package com.example.vrams.ramdieuconverter.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.activities.lottery.LotteryDetailActivity;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrams on 4/28/2017.
 */

public class LotteryProvinceAdapter extends RecyclerView.Adapter<LotteryProvinceAdapter.ItemHolder> {
    List<LotteryProvider> providers;
    LayoutInflater inflater;
    Context context;
    public LotteryProvinceAdapter(Context ct){
        this.context = ct;
        providers = new ArrayList<LotteryProvider>();
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_lot_province, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        final LotteryProvider provider = providers.get(position);
        holder.textView.setText(provider.getProvider()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, LotteryDetailActivity.class);
                intent.putExtra(LotteryDetailActivity.EXTRA_LOTTERY_DATA, provider);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return providers.size();
    }

    public void setData(List<LotteryProvider> models){
        providers.clear();
        if(models != null){
            providers.addAll(models);
        }
        Log.d("SIZE-->", providers.size()+"");
        notifyDataSetChanged();
    }


    class ItemHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ItemHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.txt_name);
        }
    }





    }
