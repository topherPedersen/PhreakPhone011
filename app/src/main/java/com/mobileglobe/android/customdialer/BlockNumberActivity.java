package com.mobileglobe.android.customdialer;

import android.content.ContentValues;
import android.net.Uri;
import android.provider.BlockedNumberContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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

        ContentValues values = new ContentValues();
        BigInteger dummyNumber = new BigInteger("5555555555");
        for (int i = 0; i <= 500000; i++) {
            String j = Integer.toString(i);
            BigInteger k = new BigInteger(j);
            dummyNumber = dummyNumber.add(k);
            String dummyNumberStr = dummyNumber.toString();
            String longFormDummyNumberStr = "+1" + dummyNumberStr;
            if (i == 500000) {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
            } else {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, dummyNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormDummyNumberStr);
            }

            if (i == 100) {
                Toast.makeText(getApplicationContext(), "100 Numbers Blocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 1000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "1,000 Numbers Blocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 10000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "10,000 Numbers Blocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 25000) {
                Toast.makeText(getApplicationContext(), "25,000 Numbers Blocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 100000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "100,000 Numbers Blocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 250000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "250,000 Numbers Blocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 500000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "500,000 Numbers Blocked!",
                        Toast.LENGTH_LONG).show();
            }
        }
        Uri uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
    }

    public void unBlockFunction(View v) {
        EditText phoneNumberEditText = (EditText) findViewById(R.id.phoneNumberEditText);
        String phoneNumberStr;
        phoneNumberStr = phoneNumberEditText.getText().toString();
        String longFormNumberStr;
        longFormNumberStr = "+1" + phoneNumberStr;

        ContentValues values = new ContentValues();
        BigInteger dummyNumber = new BigInteger("5555555555");
        for (int i = 0; i <= 500000; i++) {
            String j = Integer.toString(i);
            BigInteger k = new BigInteger(j);
            dummyNumber = dummyNumber.add(k);
            String dummyNumberStr = dummyNumber.toString();
            String longFormDummyNumberStr = "+1" + dummyNumberStr;
            if (i == 500000) {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
            } else {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, dummyNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormDummyNumberStr);
            }
            if (i == 100) {
                Toast.makeText(getApplicationContext(), "100 Numbers Unblocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 1000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "1,000 Numbers Unblocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 10000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "10,000 Numbers Unblocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 25000) {
                Toast.makeText(getApplicationContext(), "25,000 Numbers Unblocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 100000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "100,000 Numbers Unblocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 250000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "250,000 Numbers Unblocked!",
                        Toast.LENGTH_LONG).show();
            }
            if (i == 500000) {
                // do stuff
                Toast.makeText(getApplicationContext(), "500,000 Numbers Unblocked!",
                        Toast.LENGTH_LONG).show();
            }
        }
        Uri uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
        getContentResolver().delete(uri, null, null);
    }
}
