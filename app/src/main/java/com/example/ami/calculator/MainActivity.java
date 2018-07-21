package com.example.ami.calculator;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv ;
    EditText et1 ;
    ImageView iv ;
    Button b1;
    public static final int PICK_IMAGE = 100;
    Uri imageUri ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        iv = findViewById(R.id.iv1);
        b1 = (Button)findViewById(R.id.b);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();


            }
        });
    }

    private void openGallery()
    {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery,PICK_IMAGE);

    }

    @Override
    protected void onActivityResult(int request, int resultCode,Intent data)
    {
        super.onActivityResult(request,resultCode,data);
        if (resultCode ==RESULT_OK && request == PICK_IMAGE)
            imageUri = data.getData();
            iv.setImageURI(imageUri);


    }


   /* public void b1(View view) {
        et1.setText("111");

        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == PICK_IMAGE) {
            //TODO: action
            Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();
        }
    }*/
}
