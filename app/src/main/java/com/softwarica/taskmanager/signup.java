package com.softwarica.taskmanager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class signup extends AppCompatActivity {
    EditText firstname,lastname,username,password,confirmpassword;
    Button btnSignup;
    ImageView gallaryView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        firstname=findViewById(R.id.firstName);
        lastname=findViewById(R.id.lastName);
        username=findViewById(R.id.username);
        password=findViewById(R.id.password);
        confirmpassword=findViewById(R.id.confirmpassword);
        btnSignup=findViewById(R.id.btnLogin);
        gallaryView = findViewById(R.id.imgProfile);

        gallaryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BrowseImage();
            }
        });


    }

    private void BrowseImage() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (data == null) {
                Toast.makeText(this, "PLease Select image", Toast.LENGTH_SHORT).show();

            }


        }
        Uri uri = data.getData();
//        imagePath=getRealPathFromUri(uri);
        gallaryView.setImageURI(uri);
    }

}
