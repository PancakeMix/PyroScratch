package com.smashdev.pyroscratch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Access extends Activity {
	
	View defaultb;
	View customb;

	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.access);
        
    	try {
			Class.forName("com.mysql.jdbc.Driver") ;
    	Connection conn = DriverManager.getConnection("jdbc:mysql://tund.cefns.nau.edu/rcd53", "", "") ;
    	Statement stmt = conn.createStatement() ;
    	String query = "" ;
    	ResultSet rs = stmt.executeQuery(query) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        defaultb = findViewById(R.id.defaultb);
        customb = findViewById(R.id.customb);
        
		defaultb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			}
		});
		
		customb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {

			}
		});
		
	}
	
    boolean isEmailValid(CharSequence email) {
    	return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
	
}