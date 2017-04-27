package com.example.vrams.ramdieuconverter.activities.lottery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.activities.BaseActivity;
import com.example.vrams.ramdieuconverter.adapter.LotteryProvinceAdapter;
import com.example.vrams.ramdieuconverter.callbacks.Callback;
import com.example.vrams.ramdieuconverter.domain.lottery.LotteryApi;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProviderList;
import com.example.vrams.ramdieuconverter.fragments.LotteryFragment;

/**
 * Created by vrams on 4/27/2017.
 */

public class LotteryActivity extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottery);

        Fragment fragment = LotteryFragment.instance();
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_container, fragment).commit();

    }




}
