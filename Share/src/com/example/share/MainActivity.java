package com.example.share;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		 Button share=(Button)findViewById(R.id.button1);
	        final EditText eshare=(EditText)findViewById(R.id.editText1);
	        
	        
	        
	        share.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method 
					String s=eshare.getText().toString();
					shareImage(s);
		
				}
			});
	}

	private void shareImage(String data) {
    	String score="Total Score:"+data+"\nI Challenge u to beat this score\nApp link:https://www.facebook.com/suhaas.pai";
    	Intent sharingIntent = new Intent(Intent.ACTION_SEND);
    	sharingIntent.setType("image/*");
        Uri imageUri = Uri.parse("android.resource://" + getPackageName()+ "/drawable/" + "aaa");
        sharingIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Share Using");
		sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, score);
        startActivity(Intent.createChooser(sharingIntent, "Share Using!"));
    }
}
