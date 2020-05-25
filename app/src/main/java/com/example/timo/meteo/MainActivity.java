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
        preferences =  getApplicationContext().getSharedPreferences(MeteoPreference.PREFERENCE_NAME, Context.MODE_PRIVATE);

        gson = new GsonBuilder()
                .setLenient()
                .create();
        List<Meteo> listMeteoPreferences = getDataPreferences();
        if(listMeteoPreferences != null){
            meteo = listMeteoPreferences;
            setDate(meteo);
        }
        else {
            makeApicall();
        }



    }
    private List<Meteo> getDataPreferences() {
        String jsonOffre =  preferences.getString(MeteoPreference.PREFERENCE_KEY,null);

        if(jsonOffre == null) {
            return null;
        }
        else {
            Type type = new TypeToken<List<Meteo>>() {
            }.getType();
            return gson.fromJson(jsonOffre, type);
        }
    }
    private void savePreferences(List<Meteo> offreList) {
        String jsonString = gson.toJson(offreList);

        preferences
                .edit()
                .putString(MeteoPreference.PREFERENCE_KEY, jsonString)
                .apply();
        Toast.makeText(MainActivity.CONTEXT, " list saved", Toast.LENGTH_SHORT).show();
    }
    private void makeApicall() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MeteoApi meteoApi= retrofit.create(MeteoApi.class);

        Call<List<Meteo>> call = meteoApi.getMeteoResponse();
        call.enqueue(new Callback<List<Meteo>>() {
            @Override
            public void onResponse(Call<List<Meteo>> call, Response<List<Meteo>> response) {
                if(response.isSuccessful() && response.body() != null){
                    meteo = response.body();
                    savePreferences(meteo);
                    setDate(meteo);
                    Toast.makeText(getApplicationContext(), "API SUCCESS ", Toast.LENGTH_SHORT).show();
                }

                else {
                    showError();
                }
            }

            @Override
            public void onFailure(Call<List<Meteo>> call, Throwable t) {

                showError();

            }
        });
    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API ERROR ", Toast.LENGTH_SHORT).show();
    }


    public void setDate(List<Meteo> meteos){
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        for (int i=0; i<meteos.size(); i++){

            if(meteos.get(i).getLogo().equals("soleil")){
                itemsList.add(new ItemsGenerate(meteos.get(i).getVille(), R.drawable.sun, meteos.get(i).getTemperature(), meteos.get(i).getHeure()));
            }
            else if (meteos.get(i).getLogo().equals("froid")){
                itemsList.add(new ItemsGenerate(meteos.get(i).getVille(), R.drawable.neige, meteos.get(i).getTemperature(), meteos.get(i).getHeure()));

            }
            else if (meteos.get(i).getLogo().equals("pluie")){
                itemsList.add(new ItemsGenerate(meteos.get(i).getVille(), R.drawable.pluie, meteos.get(i).getTemperature(), meteos.get(i).getHeure()));

            }
            else{
                itemsList.add(new ItemsGenerate(meteos.get(i).getVille(), R.drawable.nuage, meteos.get(i).getTemperature(), meteos.get(i).getHeure()));

            }
        }


        adapter = new ItemsAdapter(itemsList);
        recyclerView.setAdapter(adapter);
    }
}

