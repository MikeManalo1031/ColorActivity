package edu.temple.mikem.coloractivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize spinner
        final Spinner spinner = (Spinner) findViewById(R.id.spinner);

        //Create adapter for Spinner widget
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.
                createFromResource(this, R.array.color_chooser,
                        android.R.layout.simple_spinner_item);
        //Specify the layout to use when the list appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply adapter to the spinner
        spinner.setAdapter(adapter);

        //
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Intent launchColorActivity = new Intent(MainActivity.this, ColorActivity.class);
                //Does nothing if first item is selected
                if (position !=0) {
                    launchColorActivity.putExtra("color", position);
                    launchColorActivity.putExtra("color name", spinner.getSelectedItem().toString());
                    startActivity(launchColorActivity);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
