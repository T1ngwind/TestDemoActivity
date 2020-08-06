package com.example.testdemoactivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creadted by Ting on 2020-07-24 16:41
 */
public class SharedPreferencesActivity extends AppCompatActivity {
	SharedPreferences sharedPreferences;
	SharedPreferences.Editor editor;

	String str_username;
	String str_password;
	String spPsw;

	EditText username;
	EditText password;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sharedpreferences);//绑定布局文件

		//获取只能被本应用读写的SharedPreferences
		sharedPreferences = getSharedPreferences("testdemo",MODE_PRIVATE);
		editor = sharedPreferences.edit();


		Button load = findViewById(R.id.load);
		Button register = findViewById(R.id.register);
		register.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent  = new Intent(SharedPreferencesActivity.this,RegisterActivity.class);
				startActivity(intent);
			}
		});

		load.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				username = findViewById(R.id.username);
				password = findViewById(R.id.password);

				str_username = username.getText().toString().trim();
				str_password = password.getText().toString().trim();

				spPsw = readPsw(str_username);

				if(TextUtils.isEmpty(str_username)){
					Toast.makeText(SharedPreferencesActivity.this,"请输入用户名",Toast.LENGTH_SHORT).show();
					return;
				}else if(TextUtils.isEmpty(str_password)){
					Toast.makeText(SharedPreferencesActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
					return;
				}else if (str_username.equals(sharedPreferences.getString("user",""))){
					Toast.makeText(SharedPreferencesActivity.this,"请输入正确的用户名",Toast.LENGTH_SHORT).show();
					return;
				}else if(str_password.equals(spPsw)){
					Intent intent2 = new Intent(SharedPreferencesActivity.this,SystemActivity.class);
					startActivity(intent2);
					Toast.makeText(SharedPreferencesActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
					return;
				}else if(!TextUtils.isEmpty(spPsw)&&!str_password.equals(spPsw)){
					Toast.makeText(SharedPreferencesActivity.this,"输入的用户名和密码不一致",Toast.LENGTH_SHORT).show();
					return;
				}else{
					Toast.makeText(SharedPreferencesActivity.this,"此用户名不存在",Toast.LENGTH_SHORT).show();
				}
			}
		});

	}

	private String readPsw(String str_username) {
		SharedPreferences sp = getSharedPreferences("loginInfo",MODE_PRIVATE);
		return sp.getString(str_username,"");

	}


}
