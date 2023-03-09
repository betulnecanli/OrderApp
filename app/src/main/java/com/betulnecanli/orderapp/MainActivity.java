package com.betulnecanli.orderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxWhippedCream;
    private CheckBox checkBoxchocolate;
    private Button buttonAzalt;
    private Button buttonArttir;
    private TextView txtQuantity;
    private EditText editTextNameSurname;
    private TextView orderSummary;
    private TextView txtOrderSummary;
    private Button buttonOrder;
    int quantity = 0;
    int total = 0;
    int whippedCreamPrice = 5;
    int chocolatePrice = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxWhippedCream = findViewById(R.id.checkbox_cream);
        checkBoxchocolate = findViewById(R.id.checkbox_chocalate);
        buttonAzalt = findViewById(R.id.button_azaltr);
        buttonArttir = findViewById(R.id.button_arttir);
        txtQuantity = findViewById(R.id.button_text);
        editTextNameSurname = findViewById(R.id.edittext_name);
        orderSummary = findViewById(R.id.txtOrderSummaryTitle);
        txtOrderSummary = findViewById(R.id.txtOrderSummary);
        buttonOrder = findViewById(R.id.button_order);



        buttonAzalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusQuantity();
            }
        });

        buttonArttir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plusQuantity();
            }
        });

        buttonOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSum();
            }
        });
    }

    public void showSum(){
        //
        total = 0;
        if (checkBoxWhippedCream.isChecked()){
            total += (quantity * whippedCreamPrice);
        }
        if (checkBoxchocolate.isChecked()){
            total += (quantity * chocolatePrice);
        }

        String info = String.format(Locale.getDefault(),getString(R.string.order_format),editTextNameSurname.getText(),
                checkBoxWhippedCream.isChecked(),checkBoxchocolate.isChecked(),quantity,total);
        txtOrderSummary.setText(info);
        showQuantityVisible();
    }

    public void plusQuantity(){
        quantity++;
       showQuantity();
    }


    public void minusQuantity(){
        if (quantity > 0){
            quantity--;
        }
        showQuantity();
    }

    public void showQuantity(){
        txtQuantity.setText(String.format(Locale.getDefault(),"%1d",quantity));
        txtOrderSummary.setVisibility(View.INVISIBLE);
        orderSummary.setVisibility(View.INVISIBLE);
    }


    public void showQuantityVisible(){
        txtQuantity.setText(String.format(Locale.getDefault(),"%1d",quantity));
        txtOrderSummary.setVisibility(View.VISIBLE);
        orderSummary.setVisibility(View.VISIBLE);
    }
}