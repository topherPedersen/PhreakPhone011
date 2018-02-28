package com.phponacid.android.phreakphone;

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
        BigInteger bigNumber = new BigInteger("5555555555");
        BigInteger dummyNumber;
        ContentValues values;
        String j;
        BigInteger k;
        String dummyNumberStr;
        String longFormDummyNumberStr;
        Uri uri;

        for (int i = 0; i <= 500000; i++) {
            values = new ContentValues();
            j = Integer.toString(i);
            k = new BigInteger(j);
            dummyNumber = bigNumber.add(k);
            dummyNumberStr = dummyNumber.toString();
            longFormDummyNumberStr = "+1" + dummyNumberStr;
            if (i == 500000) {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
            } else {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, dummyNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormDummyNumberStr);
            }
            uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
        }
        Toast.makeText(getApplicationContext(), "500,000 Numbers BLOCKED?",
                Toast.LENGTH_LONG).show();
    }

    public void unBlockFunction(View v) {
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

        for (int i = 0; i <= 500000; i++) {
            values = new ContentValues();
            j = Integer.toString(i);
            k = new BigInteger(j);
            dummyNumber = bigNumber.add(k);
            dummyNumberStr = dummyNumber.toString();
            longFormDummyNumberStr = "+1" + dummyNumberStr;
            if (i == 500000) {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, phoneNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormNumberStr);
            } else {
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_ORIGINAL_NUMBER, dummyNumberStr);
                values.put(BlockedNumberContract.BlockedNumbers.COLUMN_E164_NUMBER, longFormDummyNumberStr);
            }
            uri = getContentResolver().insert(BlockedNumberContract.BlockedNumbers.CONTENT_URI, values);
            getContentResolver().delete(uri, null, null);
        }
        Toast.makeText(getApplicationContext(), "500,000 Numbers BLOCKED?",
                Toast.LENGTH_LONG).show();
    }

}
