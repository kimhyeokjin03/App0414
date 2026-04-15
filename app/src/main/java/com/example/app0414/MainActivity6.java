package com.example.app0414;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

public class MainActivity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button9 = findViewById(R.id.button9);
        EditText editText = findViewById(R.id.editTextText7);

        button9.setOnClickListener(v -> {
            try(InputStream is = getResources().openRawResource(R.raw.raw_test)) {
                byte[] bytes = new byte[is.available()];
                int length = is.read(bytes);
                if(length > 0) {
                    // String 생성자에서 offset과 length를 지정하여 생성합니다.
                    editText.setText(new String(bytes, 0, length));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
