package com.example.vrams.ramdieuconverter.activities.converter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.vrams.ramdieuconverter.R;
import com.example.vrams.ramdieuconverter.callbacks.Callback;
import com.example.vrams.ramdieuconverter.domain.currency.CurrencyApi;
import com.example.vrams.ramdieuconverter.domain.currency.models.YahooCurrencyListModel;
import com.example.vrams.ramdieuconverter.domain.currency.models.YahooCurrencyModel;

import java.util.List;

/**
 * Created by vrams on 3/24/2017.
 */

public class ConverterActivity extends AppCompatActivity {

    List<YahooCurrencyModel> currencyModels;

    Spinner spinner;
    EditText editTypeCurrency;
    TextView txtResult;
    CheckBox checkBox;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        CurrencyApi.getCurrency(new Callback<YahooCurrencyListModel>() {
            @Override
            public void callback(YahooCurrencyListModel result) {
                if(result == null || result.getCurrency().size() == 0){
                    return;
                }
                currencyModels = result.getCurrency();

                if(spinner != null){
                    String[] arr= new String[currencyModels.size()];
                    int i = 0;
                    for (YahooCurrencyModel model : currencyModels){
                        arr[i] = model.getName();
                        i++;
                    }
                    ArrayAdapter spinnerAdapter = new ArrayAdapter<String>(ConverterActivity.this, android.R.layout.simple_list_item_1,
                           arr);
                    spinner.setAdapter(spinnerAdapter);
                }

            }
        });
        setup();
    }

    private void setup() {
        editTypeCurrency = (EditText) findViewById(R.id.edit_input_currency);
        txtResult = (TextView) findViewById(R.id.txt_result);
        spinner = (Spinner) findViewById(R.id.spConvertType);
        checkBox = (CheckBox) findViewById(R.id.cb);
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.bt_convert:
                doConvert();
                break;

        }
    }


    private void doConvert(){
        if(currencyModels == null || editTypeCurrency.getText().toString().trim().length() <= 0){
            return;
        }
        int index = spinner.getSelectedItemPosition();
        YahooCurrencyModel model = currencyModels.get(index);
        float curr = Float.valueOf(editTypeCurrency.getText().toString());
        float result = 0.0f;
        if(checkBox.isChecked() && model.getAsk() != 0){
            result = curr *  (1.0f / model.getAsk());
        }else{
            result = curr * model.getAsk();
        }
        txtResult.setText(result + " (UnitName)");
    }



}
