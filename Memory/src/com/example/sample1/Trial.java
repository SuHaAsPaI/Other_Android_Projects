package com.example.sample1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Trial extends Activity implements OnClickListener{

	Button bLoad,bSave;
	EditText eSave;
	TextView tDisplay;
	SharedPreferences someData;
	public static String filename="MySharedString";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		someData=getSharedPreferences(filename, 0);
		bLoad=(Button)findViewById(R.id.bload1);
		bSave=(Button)findViewById(R.id.bsave1);
		eSave=(EditText)findViewById(R.id.editText11);
		tDisplay=(TextView)findViewById(R.id.textView11);
		bLoad.setOnClickListener(this);
		bSave.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bload1:
				someData=getSharedPreferences(filename, 0);
				String dataReturned=someData.getString("sharedString","Cannot Load Data");
				tDisplay.setText("Load Data:"+dataReturned);
			break;
		case R.id.bsave1:
				String stringData=eSave.getText().toString();
				SharedPreferences.Editor editor=someData.edit();
				editor.putString("sharedString", stringData);
				editor.commit();
			break;
		}
		
	}

	
	
	

}
