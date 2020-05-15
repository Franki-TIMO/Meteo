package com.example.timo.meteo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    public static Context CONTEXT;


    private static final String BASE_URL= "https://my-json-server.typicode.com/";
    private ArrayList<ItemsGenerate> itemsList = new ArrayList<ItemsGenerate>();
    public static List<Meteo> meteo = new ArrayList<Meteo>();
    private SharedPreferences preferences;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.CONTEXT = this;




    }
    private List<Meteo> getDataPreferences() {


    }
    private void savePreferences(List<Meteo> offreList) {

    }
    private void makeApicall() {

            @Override
            public void onResponse(Call<List<Meteo>> call, Response<List<Meteo>> response) {

            }

            @Override
            public void onFailure(Call<List<Meteo>> call, Throwable t) {

                showError();

            }
        });
    }

    private void showError() {

    }


    public void setDate(List<Meteo> meteos){


    }
}

