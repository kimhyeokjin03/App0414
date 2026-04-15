package com.example.app0414;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button6 = findViewById(R.id.button6);        // 파일 쓰기
        Button button7 = findViewById(R.id.button7);        // 파일 읽기
        EditText editText = findViewById(R.id.editTextText5);
        button6.setOnClickListener(v -> {
            try {
                String data = editText.getText().toString();
                FileOutputStream fos = openFileOutput("test.txt", MODE_PRIVATE);
                fos.write(data.getBytes());
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        button7.setOnClickListener(v -> {
            try {
                FileInputStream fis = openFileInput("test.txt");
                byte[] bytes = new byte[fis.available()];
                fis.read(bytes);
                String data = new String(bytes);
                fis.close();
                editText.setText(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}