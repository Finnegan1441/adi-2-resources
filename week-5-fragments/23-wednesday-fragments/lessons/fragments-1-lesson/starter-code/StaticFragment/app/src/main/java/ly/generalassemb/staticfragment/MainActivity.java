package ly.generalassemb.staticfragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Fragment myFrag = (Fragment) getSupportFragmentManager().findFragmentById(R.id.yee2);

        TextView fragText = (TextView) myFrag.getView().findViewById(R.id.mTextView);
        fragText.setText("Anotha One");
    }
}
