package com.example.dessert;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LifecycleObserver;


import android.os.Bundle;
import android.view.View;

import com.example.dessert.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LifecycleObserver {

    int revenue=0;
    int dessertsSold=0;

    int i=1;
    ArrayList<Desserts> allDesserts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        allDesserts.add(new Desserts(R.drawable.cupcake,3,1,"CupCake"));
        allDesserts.add(new Desserts(R.drawable.donut,9,1,"Donut"));
        allDesserts.add(new Desserts(R.drawable.eclair,10,2,"Eclair"));
        allDesserts.add(new Desserts(R.drawable.froyo,15,2,"Froyo"));
        allDesserts.add(new Desserts(R.drawable.gingerbread,25,2,"Ginger Bread"));
        allDesserts.add(new Desserts(R.drawable.honeycomb,60,2,"Honey Comb"));
        allDesserts.add(new Desserts(R.drawable.icecreamsandwich,50,2,"Ice Cream Sandwich"));
        allDesserts.add(new Desserts(R.drawable.jellybean,30,1,"JellyBean"));
        allDesserts.add(new Desserts(R.drawable.kitkat,20,2,"KitKat"));
        allDesserts.add(new Desserts(R.drawable.lollipop,30,4,"Lollipop"));
        allDesserts.add(new Desserts(R.drawable.marshmallow,40,1,"Marshmallow"));
        allDesserts.add(new Desserts(R.drawable.nougat,50,2,"Nougat"));
        allDesserts.add(new Desserts(R.drawable.oreo,60,5,"Oreo"));


        binding.dessertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClicker(binding);
            }
        });
        binding.setRevenue(revenue);
        binding.setAmountSold(dessertsSold);
        binding.dessertButton.setImageResource(R.drawable.cupcake);
        binding.setAmountSold(1);
        binding.setRevenue(3);
        binding.setItem("CupCake");

    }
    private void onClicker(ActivityMainBinding binding)
    {
        if(i==allDesserts.size())
            i=0;
        binding.dessertButton.setImageResource(allDesserts.get(i).imageId);
        binding.setRevenue(allDesserts.get(i).Price);
        binding.setAmountSold(allDesserts.get(i).startProductionAmount);
        binding.setItem(allDesserts.get(i).name);
        i++;

    }



}
class Desserts
{
    int imageId;
    int Price;
    int startProductionAmount;
    String name;
    Desserts(int imageId,int Price,int startProductionAmount,String name)
    {
        this.imageId=imageId;
        this.Price=Price;
        this.startProductionAmount = startProductionAmount;
        this.name=name;
    }

}
