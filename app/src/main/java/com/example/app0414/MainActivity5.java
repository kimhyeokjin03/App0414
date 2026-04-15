package com.example.app0414;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        CalendarView calendarView = findViewById(R.id.calendarView);
        EditText editText = findViewById(R.id.editTextText6);
        Button button8 = findViewById(R.id.button8);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                String selectedDate = year + "년 " + (month + 1) + "월 " + dayOfMonth + "일";
                editText.setText("");
                try {
                    FileInputStream fis = openFileInput(selectedDate + ".txt");
                    byte[] bytes = new byte[fis.available()];
                    fis.read(bytes);
                    String data = new String(bytes);
                    fis.close();
                    editText.setText(data);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    button8.setOnClickListener(v -> {
                        try {
                            FileOutputStream fos = openFileOutput(selectedDate + ".txt", MODE_PRIVATE);
                            fos.write(editText.getText().toString().getBytes());
                            fos.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}