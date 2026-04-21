package com.example.app0414;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity8 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        ActivityCompat.requestPermissions(this, new String[] {android.Manifest.permission.WRITE_EXTERNAL_STORAGE},MODE_PRIVATE);

        Button btnMkdir, btnRmdir;
        btnMkdir = (Button) findViewById(R.id.btnMkdir);
        btnRmdir = (Button) findViewById(R.id.btnRmdir);
        EditText editText = (EditText) findViewById(R.id.editTextText9);

        final String strSDpath = Environment.getExternalStorageDirectory()
                .getAbsolutePath();
        // SD카드의 루트 디렉토리
        
        //final File myDir = new File(strSDpath + "/mydir");
        // 루트 밑에 mydir 디렉토리 생성

        btnMkdir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File myDir = new File(strSDpath + editText.getText().toString());
                myDir.mkdir();
                Toast.makeText(getApplicationContext(), "폴더 생성", Toast.LENGTH_SHORT).show();
            }
        });

        btnRmdir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                File myDir = new File(strSDpath + editText.getText().toString());
                myDir.delete();
                Toast.makeText(getApplicationContext(), "폴더 삭제", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
