package com.example.sample1;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

	Button bLoad,bSave;
	EditText eSave;
	TextView tDisplay;
	SharedPreferences someData;
	public static String filename="MySharedString";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		someData=getSharedPreferences(filename, 0);
		bLoad=(Button)findViewById(R.id.bload);
		bSave=(Button)findViewById(R.id.bsave);
		eSave=(EditText)findViewById(R.id.editText1);
		tDisplay=(TextView)findViewById(R.id.textView1);
		bLoad.setOnClickListener(this);
		bSave.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bload:
				someData=getSharedPreferences(filename, 0);
				String dataReturned=someData.getString("sharedString","Cannot Load Data");
				tDisplay.setText("Load Data:"+dataReturned);
			break;
		case R.id.bsave:
				String stringData=eSave.getText().toString();
				SharedPreferences.Editor editor=someData.edit();
				editor.putString("sharedString", stringData);
				editor.commit();
			break;
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		switch (item.getItemId()) {
		  case R.id.action_settings:
			  	Intent sread=new Intent("com.example.sample1.TRIAL");
					startActivity(sread);
			      return true;
		  default:
		      return super.onOptionsItemSelected(item);
		  }
	}
}
