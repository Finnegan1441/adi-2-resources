package drewmahrt.generalassemb.ly.startactivityforresultdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.app.Activity.RESULT_OK;

public class SecondActivity extends AppCompatActivity {
    Button mButton;
    EditText firstNumber, secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        firstNumber = (EditText)findViewById(R.id.first_number);
        secondNumber = (EditText)findViewById(R.id.second_number);

        mButton = (Button)findViewById(R.id.close_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNum = Integer.parseInt(firstNumber.getText().toString());
                int secondNum = Integer.parseInt(secondNumber.getText().toString());
                Intent results = new Intent();
                results.putExtra("sum", firstNum + secondNum);
                setResult(RESULT_OK, results);
                finish();
            }
        });
    }
}
