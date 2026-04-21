package com.example.app0414;

import android.Manifest;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainActivity7 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main7);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button10 = findViewById(R.id.button10);
        Button button11 = findViewById(R.id.button11);
        EditText editText = findViewById(R.id.editTextText8);

        button11.setOnClickListener(v -> {
            try {
                FileOutputStream fos = new FileOutputStream("/sdcard/test.txt");
                fos.write(editText.getText().toString().getBytes());
                fos.close();
                Toast.makeText(getApplicationContext(), "저장 완료", Toast.LENGTH_SHORT).show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        button10.setOnClickListener(v -> {
            try {
                FileInputStream fis = new FileInputStream("/sdcard/test.txt");
                byte[] data = new byte[fis.available()];
                fis.read(data);
                fis.close();
                editText.setText(new String(data));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}