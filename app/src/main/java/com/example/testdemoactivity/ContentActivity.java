package com.example.testdemoactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creadted by Ting on 2020-08-04 20:52
 */
public class ContentActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_content);
		final TextView MyOwnContentProvider = findViewById(R.id.MyOwnContentProvider);
//		TextView ContactsContractContentProvider = findViewById(R.id.ContactsContractContentProvider);


		MyOwnContentProvider.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(ContentActivity.this, MyOwnContentProviderActivity.class);
				startActivity(intent);
			}
		});

		/*ContactsContractContentProvider.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(ContentActivity.this, ContactsContractContentProviderActivity.class);
				startActivity(intent);

			}
		});*/


	}

}
