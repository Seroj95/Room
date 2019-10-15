package com.example.carsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.List;

import Data.DataBaseHandler;
import Model.Cars;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHandler dataBaseHandler=new DataBaseHandler(this);
//        dataBaseHandler.addCar(new Cars("Toyota","2500$"));
//        dataBaseHandler.addCar(new Cars("Ferari","20500$"));
//        dataBaseHandler.addCar(new Cars("BMW","4500$"));
//        dataBaseHandler.addCar(new Cars("Opel","500$"));
//        List<Cars> carsList=dataBaseHandler.getAllCars();
//        for (Cars cars:carsList){
Cars cars=dataBaseHandler.getCar(1);
cars.setName("Tesla");
cars.setPrice("15000");
dataBaseHandler.updateCar(cars);
        }
    }

