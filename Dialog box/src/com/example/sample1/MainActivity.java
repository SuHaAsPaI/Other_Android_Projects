package com.example.sample1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

	 final Context context = this;
	Button bs,bn;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        bs=(Button)findViewById(R.id.abc);
        bn=(Button)findViewById(R.id.button1);
        
        bs.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.activity_su);
				dialog.setTitle("Title");
	 
				// set the custom dialog components - text, image and button
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("Android custom dialog example!");
				//ImageView image = (ImageView) dialog.findViewById(R.id.image);
				//image.setImageResource(R.drawable.ic_launcher);
	 
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
					}
				});
	 
				dialog.show();
			}
		});
        
        bn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				alert_dialog();
				
			}
		});
       
    }
	
	
	void alert_dialog(){

        AlertDialog.Builder builder2 = new AlertDialog.Builder(context);
        builder2.setMessage("Alert Dialog ");
        builder2.setCancelable(true);
        
        builder2.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    	dialog.cancel();
                    }
                });
        builder2.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
            }
        });

        AlertDialog alert12 = builder2.create();
        alert12.show();

    }
}
