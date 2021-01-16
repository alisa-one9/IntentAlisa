package com.example.intent_to_gmail_alisa;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private ImageView imageV;
    private EditText editText;
    private Button btnSendImage;
    private LinearLayout parent;
    public static final int SELECT=22;
    public static final String KEY2= "key";
    private Uri uri;
    public static  final String KEY3 = "key3";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen_intent_to_gmail);
        init();
    }

    private void init(){
        imageV = findViewById(R.id.foto_fromGallery);
        editText = findViewById(R.id.text_withFoto);
        btnSendImage = findViewById(R.id.btn_screen2);
        parent = findViewById(R.id.container2);

    }


    public void go_toGallery(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"select image"),SELECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT && resultCode == RESULT_OK && data != null){
            uri = data.getData();
            imageV.setImageURI(uri);
        }
    }

    public void foto_on1screen(View view) {
        Intent intent = getIntent();
        intent.putExtra(KEY2,editText.getText().toString());
        intent.putExtra(KEY3,uri.toString());
        setResult(RESULT_OK,intent);
        finish();
    }
}



