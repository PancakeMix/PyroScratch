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

public class Login extends Activity {
	
	View submitb;
	View passField;

	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
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
        
        passField = findViewById(R.id.passwordInput);
        
        submitb = findViewById(R.id.submitb);
		submitb.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Thread accessStart = new Thread() {
					public void run() {
						Intent openAccess = new Intent("com.smashdev.pyroscratch.ACCESS");
						startActivity(openAccess);
					}
				};
				accessStart.start();	

			}
		});
	}
	
    boolean isEmailValid(CharSequence email) {
    	return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
	
}
