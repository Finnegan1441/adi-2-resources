package gg.patrickcummins.toolbarslab;

import android.content.ClipData;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_chevron_left_white_24dp);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.plusIcon:

                Toast.makeText(MainActivity.this, "You Clicked the plus icon", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.threeDotsIcon:
                Toast.makeText(MainActivity.this, "You Clicked the three dots icon", Toast.LENGTH_SHORT).show();

                return true;
            case R.id.castIcon:
                Toast.makeText(MainActivity.this, "You Clicked the cast icon", Toast.LENGTH_SHORT).show();

                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
