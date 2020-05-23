package com.example.timo.meteo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private TextView detail_ville;
    private TextView  itemTemperature;
    private ImageView detail_itemImage;
    private TextView levee;
    private TextView couchée;
    private TextView date;
    private TextView humidité;
    private TextView precipitation;
    private TextView visibility;
    private TextView dewPoint;
    private TextView pression;
    private TextView sunrise;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        detail_ville = findViewById(R.id.detail_ville);
        itemTemperature = findViewById(R.id.itemTemperature);
        detail_itemImage = findViewById(R.id.detail_itemImage);
        levee = findViewById(R.id.levee);
        couchée = findViewById(R.id.couchée);
        date = findViewById(R.id.date);
        humidité = findViewById(R.id.humidité);
        precipitation = findViewById(R.id.precipitation);
        visibility = findViewById(R.id.visibility);
        dewPoint = findViewById(R.id.dewPoint);
        pression = findViewById(R.id.pression);
        sunrise = findViewById(R.id.sunrise);


        detail_ville.setText(ItemsAdapter.m.getVille());
        itemTemperature.setText(ItemsAdapter.m.getTemperature());
        //detail_itemImage.setText(ItemsAdapter.m.getTemperature());
        levee.setText(ItemsAdapter.m.getLevee());
        couchée.setText(ItemsAdapter.m.getCouche());
        date.setText(ItemsAdapter.m.getDate());
        humidité.setText(ItemsAdapter.m.getHumidite()+" %");
        precipitation.setText(ItemsAdapter.m.getPrecipitation()+" in");
        visibility.setText(ItemsAdapter.m.getVisibilite()+" mi");
        dewPoint.setText(ItemsAdapter.m.getDewPoint());
        pression.setText(ItemsAdapter.m.getPression()+" in");
        sunrise.setText(ItemsAdapter.m.getLevee()+"/"+ItemsAdapter.m.getCouche());

        if(ItemsAdapter.m.getLogo().equals("soleil")){
            detail_itemImage.setImageResource(R.drawable.sun);
        }
        else if (ItemsAdapter.m.getLogo().equals("froid")){
            detail_itemImage.setImageResource(R.drawable.neige);

        }
        else if (ItemsAdapter.m.getLogo().equals("pluie")){

            detail_itemImage.setImageResource(R.drawable.pluie);
        }
        else{
            detail_itemImage.setImageResource(R.drawable.nuage);

        }





    }
}
