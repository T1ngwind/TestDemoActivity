package com.example.testdemoactivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Creadted by Ting on 2020-08-04 21:33
 */
public class ContactsContractContentProviderActivity extends AppCompatActivity {
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contactscontractcontentprovider);
		Button ContactsContract = findViewById(R.id.ContactsContract);
		ContactsContract.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				ContentResolver contentResolver1 = getContentResolver();
				Cursor cursor1 = contentResolver1.query(android.provider.ContactsContract.Contacts.CONTENT_URI,null,null,null,null);
				startManagingCursor(cursor1);
			}
		});

	}
}
