package com.example.user.studytracker;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatenActivity extends AppCompatActivity {

    private static final int ACTIVITY_START_CAMERA_APP=0;
    private ImageView CapturedImageView;
    private  String mImageFileLocation= "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daten2);
        CapturedImageView= (ImageView) findViewById(R.id.Captured);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            if(bundle.get("some")!=null){
                Toast.makeText(getApplicationContext(),"data:" +bundle.getString("some"),Toast.LENGTH_SHORT).show();

            }
        }
    }

    public void Capture(View view) {

        Intent CallCameraApplication = new Intent ();
        CallCameraApplication.setAction(MediaStore.ACTION_IMAGE_CAPTURE);

        File photoFile = null;

        try{
            photoFile= createImagefile();

        } catch (IOException e){
            e.printStackTrace();
        }
        CallCameraApplication.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));

        startActivityForResult(CallCameraApplication,ACTIVITY_START_CAMERA_APP);


    }


    protected void onActivityResult (int requestCode, int resultCode,Intent data){
        if (requestCode == ACTIVITY_START_CAMERA_APP && resultCode== RESULT_OK){
           // Toast.makeText(this,"Picture taken successfully",Toast.LENGTH_SHORT).show();
            //Bundle extras = data.getExtras();
            //Bitmap photoCapturedBitmap =(Bitmap) extras.get("data");

            Bitmap photoCaptureBitmap= BitmapFactory.decodeFile(mImageFileLocation);
            CapturedImageView.setImageBitmap(photoCaptureBitmap);
        }
    }
    File createImagefile()throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFilename= "Image_" + timeStamp + "_";
        File storageDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);

        File image = File.createTempFile(imageFilename,".jpg",storageDirectory);
        mImageFileLocation = image.getAbsolutePath();
        return image ;



    }

    }

