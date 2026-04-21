package com.example.app0414;

import java.io.File;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity9 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        Button btnFilelist;
        final EditText edtFilelist;
        btnFilelist = (Button) findViewById(R.id.btnFilelist);
        edtFilelist = (EditText) findViewById(R.id.edtFilelist);

        btnFilelist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // SD 카드의 Root
                String sysDir = Environment.getRootDirectory()
                        .getAbsolutePath();

                File[] sysFiles = (new File(sysDir).listFiles());

                String strFname;
                for (int i = 0; i < sysFiles.length; i++) {
                    if (sysFiles[i].isDirectory() == true)
                        strFname = "<폴더 > " + sysFiles[i].toString();
                    else
                        strFname = "<파일 > " + sysFiles[i].toString();

                    edtFilelist.setText(edtFilelist.getText() + "\n" + strFname);
                }
            }
        });
    }

}
