package com.example.vrams.ramdieuconverter.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.domain.lottery.models.Lottery;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProvider;
import com.example.vrams.ramdieuconverter.domain.lottery.models.Prizes;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vrams on 4/28/2017.
 */

public class LotteryDetailAdapter extends RecyclerView.Adapter<LotteryDetailAdapter.ItemHolder> {
    LotteryProvider provider;
    List<Lottery> lotteries;
    LayoutInflater inflater;
    Context context;
    public LotteryDetailAdapter(Context ct){
        this.context = ct;
        inflater = LayoutInflater.from(context);
        lotteries = new ArrayList<Lottery>();
    }


    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_lot_result, parent, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Lottery lottery = lotteries.get(position);
        holder.sectionDivider.setVisibility( position == 0? View.GONE : View.VISIBLE);

        holder.txtLotTitle.setText(provider.getProvider() + "  " + lottery.getDate());
        Prizes prizes = lottery.getPrizes();
        if(prizes == null){
            throw  new RuntimeException("onBindViewHolder -> Prizes = null");
        }

        setPrizeText(holder.txtP1, prizes.getFirst());
        setPrizeText(holder.txtP2, prizes.getSecond());
        setPrizeText(holder.txtP3, prizes.getThird());
        setPrizeText(holder.txtP4, prizes.getFourth());
        setPrizeText(holder.txtP5, prizes.getFifth());
        setPrizeText(holder.txtP6, prizes.getSix());
        setPrizeText(holder.txtP7, prizes.getSeven());
        setPrizeText(holder.txtP8, prizes.getEight());
        setPrizeText(holder.txtSp, prizes.getSpecial());

    }

    private void setPrizeText(TextView textView, int[] code){
        if(code == null){
            //TODO
            return;
        }

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < code.length; i++){
            if(i == 0){
                builder.append(code[i] +"");
            }else{
                builder.append(" - " + code[i]);
            }
        }
        textView.setText(builder.toString());
    }

    public void setData(LotteryProvider model){
        provider = model;
        lotteries.clear();
        if(provider != null){
            lotteries.addAll(provider.getLotteries());
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return (provider == null)? 0 : lotteries.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        TextView txtP1;
        TextView txtP2;
        TextView txtP3;
        TextView txtP4;
        TextView txtP5;
        TextView txtP6;
        TextView txtP7;
        TextView txtP8;
        TextView txtSp;

        TextView txtLotTitle;

        View sectionDivider;


        public ItemHolder(View itemView) {
            super(itemView);
            txtP1 = getTextView(R.id.txt_prize1);
            txtP2 = getTextView(R.id.txt_prize2);
            txtP3 = getTextView(R.id.txt_prize3);
            txtP4 = getTextView(R.id.txt_prize4);
            txtP5 = getTextView(R.id.txt_prize5);
            txtP6 = getTextView(R.id.txt_prize6);
            txtP7 = getTextView(R.id.txt_prize7);
            txtP8 = getTextView(R.id.txt_prize8);
            txtSp = getTextView(R.id.txt_prize_sp);

            txtLotTitle = getTextView(R.id.txt_lot_result_name);

            sectionDivider = itemView.findViewById(R.id.section_divider);
        }
         private TextView getTextView(@IdRes int id){
             return (TextView) itemView.findViewById(id);
         }
    }


}
