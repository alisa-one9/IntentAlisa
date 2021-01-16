package com.example.intent_to_gmail_alisa;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private  int SELECT =2;
    private ImageView image_screen1;
    private TextView text;
    private String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

   public void init (){
        image_screen1=findViewById(R.id.image_screen1);
        text = findViewById(R.id.text_screen1);


   }
    public void openActivity(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivityForResult(intent,SELECT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==SELECT && resultCode ==RESULT_OK&& data!=null){
            image_screen1.setImageURI(Uri.parse(data.getStringExtra(MainActivity2.KEY3)));
            value = data.getStringExtra(MainActivity2.KEY2);
        }
    }

    public void to_Gmail(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL,"usenbaevaalisa@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT,"subject");
        intent.putExtra(Intent.EXTRA_TEXT,value);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(Intent.createChooser(intent,"send email"));

        }
    }
}