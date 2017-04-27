package com.example.vrams.ramdieuconverter.activities.converter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.adapter.CurrencyAdapter;
import com.example.vrams.ramdieuconverter.callbacks.Callback;
import com.example.vrams.ramdieuconverter.domain.currency.CurrencyApi;
import com.example.vrams.ramdieuconverter.domain.currency.models.YahooCurrencyListModel;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        adapter = new CurrencyAdapter(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CurrencyApi.getCurrency(new Callback<YahooCurrencyListModel>() {
            @Override
            public void callback(YahooCurrencyListModel result) {
                if(result != null){
                    Log.d("CURRENCY","Size: " + result.getCurrency().size());
                }else{
                    Toast.makeText(getApplicationContext(), "Cannot Connect to the internet or Our Server have a problem.", Toast.LENGTH_LONG).show();
                    return;
                }
                if(adapter != null){
                    adapter.setData(result.getCurrency());
                }
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.actionConverter){
            startActivity(new Intent(getApplicationContext(), ConverterActivity.class));
        }
        return super.onOptionsItemSelected(item);

    }
}
