package com.leancuke.android.hellonfc;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MyActivity extends Activity {

    public static final String EXTRA_MESSAGE = "com.leancuke.android.hellonfc.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        NfcAdapter mNfcAdapter;
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        TextView nfcStatusTextView = (TextView) findViewById(R.id.nfcStatusTextView);

        if (mNfcAdapter == null) {
            // Stop here, we definitely need NFC
            Toast.makeText(this, "This device doesn't support NFC.", Toast.LENGTH_LONG).show();
            finish();
            return;

        }

        checkNfcStatus(nfcStatusTextView);

        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent) {
        // TODO: handle Intent
    }

    public void checkNfcStatus(View view) {

        NfcAdapter mNfcAdapter;
        mNfcAdapter = NfcAdapter.getDefaultAdapter(this);

        TextView nfcStatusTextView = (TextView) findViewById(R.id.nfcStatusTextView);


        if (!mNfcAdapter.isEnabled()) {
            nfcStatusTextView.setText("NFC is disabled.");
        } else {
            nfcStatusTextView.setText("NFC is enabled");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
