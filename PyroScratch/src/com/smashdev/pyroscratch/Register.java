package com.smashdev.pyroscratch;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.Window;
import com.github.sendgrid.SendGrid;
import java.lang.Class;


public class Register extends Activity {

	View submitb;

	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        
    	try {
			Class.forName("com.mysql.jdbc.Driver") ;
    	Connection conn = DriverManager.getConnection("jdbc:mysql://tund.cefns.nau.edu/rcd53", "rcd53", "1stinkykitty") ;
    	Statement stmt = conn.createStatement() ;
    	String query = "" ;
    	ResultSet rs = stmt.executeQuery(query) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        submitb = findViewById(R.id.submitb);
		submitb.setOnClickListener(new View.OnClickListener() {
			
			
			@Override
			public void onClick(View v) {
				SendGrid sendgrid = new SendGrid("cbilbrey", "EeVeeB20124");
				
				System.out.println("dude");
				sendgrid.addTo("pancakemix007@gmail.com");
				sendgrid.addToName("Curtie B");
				sendgrid.setFrom("cwb48@nau.edu");
				sendgrid.setSubject("Hello World");
				sendgrid.setText("Sup future Curtis, if you're reading this, you probably did it. I envy you, godspeed my friend.");

				
				System.out.println("it maybe worked");
			}
		});
	}
	
    boolean isEmailValid(CharSequence email) {
    	return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    
	
}
