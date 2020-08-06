package com.example.testdemoactivity;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

/**
 * Creadted by Ting on 2020-07-25 18:24
 */
public class User  implements Serializable {
	String username;
	String password;

	public User(String username,String password){
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
