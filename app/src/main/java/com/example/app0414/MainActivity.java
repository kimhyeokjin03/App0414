package com.example.app0414;

import static android.app.ProgressDialog.show;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editTextText);

        button.setOnClickListener(v -> {
            AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
            dlg.setTitle("안내");
            dlg.setMessage("대화상자를 실행합니다.");
            dlg.setIcon(R.drawable.ic_launcher_foreground);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, editText.getText(), Toast.LENGTH_SHORT).show();
                }
            });
            dlg.setNegativeButton("취소", null);
            dlg.show();
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> {
            final String[] items = {"사과", "딸기", "바나나"};
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("좋아하는 과일")
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            editText.setText(items[which]);
                        }
                    })
                    .setPositiveButton("닫기", null)
                    .show();
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] items = {"사과", "딸기", "바나나"};
                DialogInterface.OnClickListener checkedItem;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("좋아하는 과일")
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                editText.setText(items[which]);
                            }
                        })
                        .setPositiveButton("닫기", null)
                        .show();
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean[] checkArray = {false, false, false};
                final String[] items = {"사과", "딸기", "바나나"};
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("좋아하는 과일")
                        .setMultiChoiceItems(items, checkArray, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                checkArray[which] = isChecked;
                            }
                        })
                        .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String str = "";
                                for (int i = 0; i < checkArray.length; i++) {
                                    if (checkArray[i]) {
                                        str += items[i] + " ";
                                    }
                                }
                                editText.setText(str);
                            }
                        })
                        .show();
                };
            });
        Button button5 = findViewById(R.id.button5);
        View view = getLayoutInflater().inflate(R.layout.dialogview1, null);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("입력")
                        .setView(view)
                        .setPositiveButton("닫기", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText editText1 = view.findViewById(R.id.editTextText2);
                                EditText editText2 = view.findViewById(R.id.editTextText3);
                                editText.setText(editText1.getText() + " " + editText2.getText());
                            }
                        })
                        .show();
            }

        });
    }
}