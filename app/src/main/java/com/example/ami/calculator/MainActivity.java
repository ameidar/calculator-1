package com.example.ami.calculator;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv , exit ;
    EditText et1 ;
    ImageView iv ;
    Button b1;
    Dialog d1;
    ImageView image;
    Button button;

    public static final int PICK_IMAGE = 100;
    Uri imageUri ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = findViewById(R.id.et1);
        iv = findViewById(R.id.iv1);
        b1 = (Button)findViewById(R.id.b);
        d1 = new Dialog(this);


        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();


            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.it1)
        {

            Toast.makeText(  getApplicationContext() ,"add item " , Toast.LENGTH_SHORT).show();
            d1.setContentView(R.layout.adddocdialog);
            image = d1.findViewById(R.id.iv1);
            button = d1.findViewById(R.id.db1);
            exit = d1.findViewById(R.id.exit);
            d1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            d1.show();




        }


        //respond to menu item selection
        return true;

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

    public void b1(View view) {
        if (view.getId() == R.id.db1)
        {
            Toast.makeText(getApplicationContext(),"Follow me clicked" , Toast.LENGTH_SHORT ).show();

        }
        if (view.getId() == R.id.exit)
            d1.dismiss();

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
