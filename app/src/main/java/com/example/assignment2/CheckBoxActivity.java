package com.example.assignment2;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class CheckBoxActivity extends AppCompatActivity {

    ArrayList<String> arr = new ArrayList<>();
//club selecting
private CheckBox realmadrid,manu,chelsea;
private Button btnshow;
private TextView clubresult;


//size selecting
    private RadioGroup radiogrp;
    private TextView size;
    private Button showsize;
    private RadioButton selectedbutton,radiobutton;

    //price box
    private TextView priceTextView,quantityTextView;
    private  Button increment,decrement;
    private int quantity = 0;
    private int price = 0;



    //rating bar
    private RatingBar rating;
    private TextView resultOfrating;


    //order placing

    private Button placeorder;
    private AlertDialog.Builder builder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_check_box);


//finding id of club selecting
    realmadrid=(CheckBox) findViewById(R.id.cb_realmadrid);
    manu=(CheckBox) findViewById(R.id.cb_manu);
    chelsea= (CheckBox) findViewById(R.id.cb_chelsea);
    btnshow=(Button) findViewById(R.id.btn_show);
    clubresult= findViewById(R.id.tv_clubresult);


    //finding id for size selecting

        radiogrp=(RadioGroup)findViewById(R.id.rg_sizeselect);
        size=(TextView)findViewById(R.id.tv_size);
        showsize=(Button)findViewById(R.id.btn_showsize);



        //price box finding
        priceTextView=(TextView)findViewById(R.id.tv_price);
        quantityTextView=(TextView)findViewById(R.id.tv_quantity);
        increment=(Button)findViewById(R.id.btn_increment);
        decrement=(Button)findViewById(R.id.btn_decrement);


//finding rating
        rating=(RatingBar) findViewById(R.id.rb_rating);
        resultOfrating=(TextView) findViewById(R.id.tv_ratingresult);



//order placing finding
        placeorder=(Button)findViewById(R.id.btn_placeorder);
        builder = new AlertDialog.Builder(this);

    btnshow.setOnClickListener(v ->{

        StringBuilder strbuild=new StringBuilder();

        if(realmadrid.isChecked()){
            String value=realmadrid.getText().toString();
            strbuild.append(value+" jursey is ordered\n");
        }

        if(manu.isChecked()){
            String value=manu.getText().toString();
            strbuild.append(value+" jursey is ordered\n");
        }
        if(chelsea.isChecked()){
            String value=chelsea.getText().toString();
            strbuild.append(value+" jursey is ordered\n");
        }
clubresult.setText(strbuild);
    });




showsize.setOnClickListener(v ->{

   int selectedid= radiogrp.getCheckedRadioButtonId();
   selectedbutton=(RadioButton) findViewById(selectedid);
   String value =selectedbutton.getText().toString();

   size.setText(value+" size is selected");


});


//price and quantity

        increment.setOnClickListener(v -> {
            quantity++;
            price =quantity * 500;
            quantityTextView.setText("" + quantity);
            priceTextView.setText("$" + price);
        });
        decrement.setOnClickListener(v -> {
            if(quantity>0){
                quantity--;
                price = quantity * 500;
                quantityTextView.setText("" + quantity);
                priceTextView.setText("$" + price);
            }
        });



rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
    @Override
    public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
resultOfrating.setText("rating:"+v);
    }
});



        placeorder.setOnClickListener(v -> {
            try {
                if (arr.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Select Club!!", Toast.LENGTH_SHORT).show();
                }
                String radioValue = showsize.getText().toString();
                if (quantity == 0) {
                    Toast.makeText(getApplicationContext(), "Please add quantity!!", Toast.LENGTH_SHORT).show();
                } else {
                    builder.setTitle("Order Placed!!")
                            .setMessage("Order Summary:\n" + "Clubs: " + arr + "\nT-shirt Size: " + radioValue+ "\nQuantity: " + quantity + "\nTotal Price: BDT " + price + "\nRating: " + rating.getRating() +"\nThank you!!")
                            .setCancelable(false)
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                    Toast.makeText(getApplicationContext(), "Order Placed!!", Toast.LENGTH_SHORT).show();
                                    quantity = 0;
                                    price = 0;
                                    quantityTextView.setText("0");
                                    priceTextView.setText("BDT 0");
                                    clubresult.setText("");
                                    realmadrid.setChecked(false);
                                    manu.setChecked(false);
                                   chelsea.setChecked(false);
                                    radiogrp.clearCheck();
                                    rating.setRating(0);
                                }
                            }).show();
                }
            } catch (Exception e){
                Toast.makeText(getApplicationContext(), "Please Select T-shirt Size!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    void check(CompoundButton buttonView, Boolean isChecked){
        if (isChecked) {
            arr.add(buttonView.getText().toString());
            Log.d("array", String.valueOf(arr));
        } else{
            arr.remove(buttonView.getText().toString());
        }
        clubresult.setText(String.valueOf(arr));
    }
}



