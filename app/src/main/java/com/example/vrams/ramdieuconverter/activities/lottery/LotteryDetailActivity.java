package com.example.vrams.ramdieuconverter.activities.lottery;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.activities.BaseActivity;
import com.example.vrams.ramdieuconverter.adapter.LotteryDetailAdapter;
import com.example.vrams.ramdieuconverter.adapter.LotteryProvinceAdapter;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProvider;

/**
 * Created by vrams on 4/28/2017.
 */

public class LotteryDetailActivity extends BaseActivity {

    LotteryProvider lotteryProvider;

    public static final String EXTRA_LOTTERY_DATA = "EXTRA_LOTTERY_DATA";

    RecyclerView recyclerView;
    LotteryDetailAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_LOTTERY_DATA)) {
            lotteryProvider = (LotteryProvider) intent.getSerializableExtra(EXTRA_LOTTERY_DATA);
        }else{
            Toast.makeText(getApplicationContext(), "Lỗi -> ...không hợp lệ", Toast.LENGTH_SHORT).show();
            finish();
        }

        setTitle("KQXS - " + lotteryProvider.getProvider());

        init();
    }

    private void init() {
        adapter = new LotteryDetailAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setData(lotteryProvider);


    }
}
