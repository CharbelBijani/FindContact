package com.dam.findcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    Button btnFind;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFind = findViewById(R.id.btnFind);
        number = findViewById(R.id.editTextPhone);

        Uri contentUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(number.toString()));
        Uri contentUri2 = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(number.toString()));

        Log.i(TAG, "onCreate: contacts = " + contentUri);
        Log.i(TAG, "onCreate: phonelookup = " + contentUri2);

    }

    Uri filterUri = Uri.withAppendedPath(Phone.CONTENT_FILTER_URI, Uri.encode(searchString));
    String[] projection = new String[]{ Phone.CONTACT_ID, Phone.DISPLAY_NAME, Phone.NUMBER };
    Cursor cur = getContentResolver().query(filterUri, projection, null, null, null);

    
}