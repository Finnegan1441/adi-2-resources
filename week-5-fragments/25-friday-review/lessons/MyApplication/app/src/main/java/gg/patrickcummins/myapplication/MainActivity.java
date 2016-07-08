package gg.patrickcummins.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    DetailsFragment detailsFragment;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        detailsFragment = new DetailsFragment();
        editText = (EditText) findViewById(R.id.myEditText);
        button = (Button) findViewById(R.id.myButton);


        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.add(R.id.textViewFragment, detailsFragment);
        fragmentTransaction.commit();





    }

    @Override
    protected void onResume() {
        super.onResume();
        detailsFragment.setTextViewText("YEE BOI");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detailsFragment.setTextViewText(editText.getText().toString());
            }
        });

    }
}
