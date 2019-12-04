package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
 private Spinner spRoom, sphotel;
 EditText etIn, etOut, eta, etc, etR;
 Button btnSubmit;
 TextView tvhotel,tvhotelType,tvInDate,tvOutDate,tvadults,tvchildern,tvrooms;
 DatePickerDialog IndatePickerDialog;
 DatePickerDialog OutdatePickerDialog;
 int currentyear, currentmonth, currentday;
 String hotel,hotelType,dateIn,dateOut, adults,child,room;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eta=findViewById(R.id.eta);
        etc=findViewById(R.id.etc);
        etR=findViewById(R.id.etR);
        etOut=findViewById(R.id.etOut);
        etIn=findViewById(R.id.etIn);
        btnSubmit=findViewById(R.id.btnc);
        tvhotel=findViewById(R.id.hotelResult);
        tvhotelType=findViewById(R.id.hotelTypeResult);
        tvInDate=findViewById(R.id.checkInResult);
        tvOutDate=findViewById(R.id.checkOutResult);
        tvadults=findViewById(R.id.adultsResult);
        tvchildern=findViewById(R.id.childrenResult);
        tvrooms=findViewById(R.id.roomsResult);
        CheckInDate();

        etIn.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                IndatePickerDialog.show();
            }
        });
        CheckOutDate();

        //Out
        etOut.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                OutdatePickerDialog.show();
            }
        });

        etIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IndatePickerDialog.show();
            }
        });
        //Out
        etOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OutdatePickerDialog.show();
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adults = eta.getText().toString();
                //Toast.makeText(MainActivity.this,"Adults" +adults,Toast.LENGTH_LONG).show();
                child = etc.getText().toString();
                room = etR.getText().toString();
                hotel = sphotel.getSelectedItem().toString();
                hotelType = spRoom.getSelectedItem().toString();
                //Toast.makeText(MainActivity.this,"Hotel" +hotel,Toast.LENGTH_LONG).show();
                dateIn = etIn.getText().toString();
                dateOut = etOut.getText().toString();


                tvhotel.setText(hotel);
                tvhotelType.setText(hotelType);
                tvInDate.setText(dateIn);
                tvOutDate.setText(dateOut);
                tvadults.setText(adults);
                tvchildern.setText(child);
                tvrooms.setText(room);

            }

        });
        sphotel = findViewById(R.id.spnhotel);
        String Hotels[] = {"","ktm", "Chitwan", "Pokhara", "Ilam"};
        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, Hotels

        );
        spRoom = findViewById(R.id.spnroom);
        String Room[] = {"", "Deluxe", "Ac Room", "Master room", "five Star"};
        ArrayAdapter adapter1 = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1, Room

        );
        sphotel.setAdapter(adapter);
        spRoom.setAdapter(adapter1);

    }


    public void CheckInDate(){
        final Calendar c = Calendar.getInstance();
        currentyear = c.get(Calendar.YEAR);
        currentmonth = c.get(Calendar.MONTH);
        currentday = c.get(Calendar.DAY_OF_MONTH);

        IndatePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                currentyear = year;
                currentmonth = month;
                currentday = dayOfMonth;

                etIn.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                etIn.setFocusable(false);
            }
        },currentyear,currentmonth,currentday);
    }

    public void CheckOutDate(){
        final Calendar c = Calendar.getInstance();
        currentyear = c.get(Calendar.YEAR);
        currentmonth = c.get(Calendar.MONTH);
        currentday = c.get(Calendar.DAY_OF_MONTH);

        OutdatePickerDialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                currentyear = year;
                currentmonth = month;
                currentday = dayOfMonth;

                etOut.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                etOut.setFocusable(false);
            }
        },currentyear,currentmonth,currentday);

    }
}
