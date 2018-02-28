package com.phponacid.android.phreakphone;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BlockedNumberContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class BlockNumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_block_number);
    }

    public void blockFunction(View v) {
        EditText phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        String phoneNumberStr;
        phoneNumberStr = phoneNumberEditText.getText().toString();
        String longFormNumberStr;
        longFormNumberStr = "+1" + phoneNumberStr;
        BigInteger bigNumber = new BigInteger("5555555555");
        BigInteger dummyNumber;
        ContentValues values;
        String j;
        BigInteger k;
        String dummyNumberStr;
        String longFormDummyNumberStr;
        Uri uri;

        for (int i = 0; i <= 10000; i++) {
            values = new ContentValues();
            j = Integer.toString(i);
            k = new BigInteger(j);
            dummyNumber = bigNumber.add(k);
            dummyNumberStr = dummyNumber.toString();
            longFormDummyNumberStr = "+1" + dummyNumberStr;
            if (i == 10000) {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
            } else {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, dummyNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormDummyNumberStr);
            }
            uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
        }
        Toast.makeText(getApplicationContext(), "10,000 Numbers BLOCKED?",
                Toast.LENGTH_LONG).show();
    }

    // function unblocks 1000 numbers from the users BlockedNumbers list
    public void unBlockFunction(View v) {

        Cursor c = getContentResolver().query(BlockedNumberContract.BlockedNumbers.CONTENT_URI,
                new String[]{BlockedNumberContract.BlockedNumbers.COLUMN_ID, BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER,
                        BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER}, null, null, null);
        String blockedPhoneNumber;
        ContentValues values;
        Uri uri;
        Integer index = 1;
        c.moveToFirst();
        if (c != null) {
            do {
                blockedPhoneNumber = c.getString(c.getColumnIndex(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER));
                values = new ContentValues();
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, blockedPhoneNumber);
                uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
                getContentResolver().delete(uri, null, null);
                index++;
            } while (c.moveToNext() && index <= 1000);
        }
        Toast.makeText(getApplicationContext(), "1,000 Numbers UN-BLOCKED?",
                Toast.LENGTH_LONG).show();
        /*
        EditText phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        String phoneNumberStr;
        phoneNumberStr = phoneNumberEditText.getText().toString();
        String longFormNumberStr;
        longFormNumberStr = "+1" + phoneNumberStr;
        BigInteger bigNumber = new BigInteger("5555555555");
        BigInteger dummyNumber;
        ContentValues values;
        String j;
        BigInteger k;
        String dummyNumberStr;
        String longFormDummyNumberStr;
        Uri uri;

        for (int i = 0; i <= 10000; i++) {
            values = new ContentValues();
            j = Integer.toString(i);
            k = new BigInteger(j);
            dummyNumber = bigNumber.add(k);
            dummyNumberStr = dummyNumber.toString();
            longFormDummyNumberStr = "+1" + dummyNumberStr;
            if (i == 10000) {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
            } else {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, dummyNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormDummyNumberStr);
            }
            uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
            getContentResolver().delete(uri, null, null);
        }
        Toast.makeText(getApplicationContext(), "10,000 Numbers BLOCKED?",
                Toast.LENGTH_LONG).show();
        */
    }

}
