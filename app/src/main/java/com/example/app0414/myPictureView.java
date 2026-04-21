package com.example.app0414;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class myPictureView extends View {
    String imagePath = null;        // sdcard에서 넘어온 파일명
    public myPictureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if(imagePath != null) {
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            canvas.drawBitmap(bitmap, 0, 0, null);
            bitmap.recycle();
        }
    }
}

/*
    프래그먼트에 이미지를 넣어 해당 프래그먼트를 보여주는 것과 캔버스를 사용하여 비트맵 형식으로
    보여주는 것의 차이점(이점)
 */
