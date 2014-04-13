package com.smashdev.pyroscratch;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {
	
	View login;
	View register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.loginb);
        register = findViewById(R.id.registerb);
        
        login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Thread loginStart = new Thread() {
					public void run() {
						Intent openLogin = new Intent("com.smashdev.pyroscratch.LOGIN");
						startActivity(openLogin);
					}
				};
				loginStart.start();	
			}
		});
        
        register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Thread registerStart = new Thread() {
					public void run() {
						Intent openRegister = new Intent("com.smashdev.pyroscratch.REGISTER");
						startActivity(openRegister);
					}
				};
				registerStart.start();	
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
