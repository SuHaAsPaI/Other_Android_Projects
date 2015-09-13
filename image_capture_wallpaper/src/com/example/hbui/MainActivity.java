package com.example.hbui;

import java.io.IOException;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;



public class MainActivity extends Activity implements View.OnClickListener {

    
	Button bSetWall;
    ImageButton im;
    ImageView iv;
    Bitmap bmp;
    
    final static int camera_result=0;
   Intent i; 
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initailize();
       
    }

	private void initailize() {
		// TODO Auto-generated method stub
		bSetWall=(Button)findViewById(R.id.bsetwall);
		iv=(ImageView)findViewById(R.id.imreturnpic);
		im=(ImageButton)findViewById(R.id.imtakepic);
		bSetWall.setOnClickListener(this);
		im.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		
		case R.id.bsetwall:
			try {
				getApplicationContext().setWallpaper(bmp);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			    break;
		case R.id.imtakepic:
			i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
			    startActivityForResult(i, camera_result);
			break;
		
		}
		  
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras=data.getExtras();
			bmp=(Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}
	


}
