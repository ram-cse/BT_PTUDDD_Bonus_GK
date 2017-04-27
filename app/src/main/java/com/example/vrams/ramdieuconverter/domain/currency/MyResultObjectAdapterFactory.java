/*
package com.example.vrams.ramdieuconverter.domain.currency;

import com.example.vrams.ramdieuconverter.domain.currency.models.YahooCurrencyModel;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

public class MyResultObjectAdapterFactory implements TypeAdapterFactory {

    @Override
    @SuppressWarnings("unchecked")
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if (type.getRawType()!= YahooCurrencyModel.class) return null;

        TypeAdapter<YahooCurrencyModel> defaultAdapter = (TypeAdapter<YahooCurrencyModel>) gson.getDelegateAdapter(this, type);
        return (TypeAdapter<T>) new MyResultObjectAdapter(defaultAdapter);
    }

    public class MyResultObjectAdapter extends TypeAdapter<YahooCurrencyModel> {

        protected TypeAdapter<YahooCurrencyModel> defaultAdapter;


        public MyResultObjectAdapter(TypeAdapter<YahooCurrencyModel> defaultAdapter) {
            this.defaultAdapter = defaultAdapter;
        }

        @Override
        public void write(JsonWriter out, YahooCurrencyModel value) throws IOException {
            defaultAdapter.write(out, value);
        }

        @Override
        public YahooCurrencyModel read(JsonReader in) throws IOException {
            */
/*
            This is the critical part. So if the value is a string,
            Skip it (no exception) and return null.
            *//*

            if (in.peek() == JsonToken.STRING) {
                in.skipValue();
                return null;
            }
            return defaultAdapter.read(in);
        }
    }
}*/
