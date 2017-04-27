package com.example.vrams.ramdieuconverter.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.adapter.LotteryProvinceAdapter;
import com.example.vrams.ramdieuconverter.callbacks.Callback;
import com.example.vrams.ramdieuconverter.domain.lottery.LotteryApi;
import com.example.vrams.ramdieuconverter.domain.lottery.models.LotteryProviderList;

/**
 * Created by vrams on 4/27/2017.
 */

public class LotteryFragment extends Fragment {

    public static LotteryFragment instance(){
        return  new LotteryFragment();
    }


    LotteryProviderList providerList;

    RecyclerView recyclerView;
    LotteryProvinceAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_recycler, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        adapter = new LotteryProvinceAdapter(getContext());
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LotteryApi.getLottery(new Callback<LotteryProviderList>() {
            @Override
            public void callback(LotteryProviderList result) {
                if(result == null){
                    Toast.makeText(getContext(), R.string.network_error, Toast.LENGTH_SHORT).show();
                }else{
                    Log.d("Result:", result.getLotteryProviders().size() +"");
                    providerList = result;
                    adapter.setData(providerList.getLotteryProviders());
                }
            }
        });

    }
}
