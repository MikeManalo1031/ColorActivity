package edu.temple.mikem.coloractivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ColorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        //Gets ColorActivity layout
        RelativeLayout bgColor = (RelativeLayout) findViewById(R.id.activity_color_layout);

        Intent recievedIntent = getIntent();

        //Receives position of spinner
        int colorPosition = recievedIntent.getIntExtra("color", Color.WHITE);
        //Changes layout background depending on color selected
        bgColor.setBackgroundColor(getColorPosition(colorPosition));

        //Creates a toast that displays selected item
        CharSequence colorName = recievedIntent.getStringExtra("color name");
        Toast toast = Toast.makeText(getApplicationContext(),
                colorName + " was chosen", Toast.LENGTH_SHORT);
        toast.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_color, menu);
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

    /**
     * Returns item color specified by item position
     *
     * @param position
     * @return
     */
    private int getColorPosition(int position){
        int color;
        switch(position){
            case 1: color = Color.RED;
                break;
            case 2: color = Color.BLACK;
                break;
            case 3: color = Color.BLUE;
                break;
            case 4: color = Color.CYAN;
                break;
            case 5: color = Color.GRAY;
                break;
            default: color = Color.WHITE;
                break;
        }

        return color;
    }
}
