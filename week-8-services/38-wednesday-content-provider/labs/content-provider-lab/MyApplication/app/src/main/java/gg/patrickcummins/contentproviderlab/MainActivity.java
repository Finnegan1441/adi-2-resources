package gg.patrickcummins.contentproviderlab;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView stocksListView;
    FloatingActionButton addStockButton;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        setViews();
        setOnClicks();
        
    }

    private void setOnClicks() {
        addStockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addStockToList();
            }
        });
    }

    private void addStockToList() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.add_stock_alert_dialog, null)).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                onAddClick(dialogInterface);
            }
        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    private void onAddClick(DialogInterface dialog) {
        EditText symbolEditText = (EditText)((AlertDialog)dialog).findViewById(R.id.stockSymbol);
        EditText quantityEditText = (EditText)((AlertDialog)dialog).findViewById(R.id.stockQuantity);
        String symbol = symbolEditText.getText().toString();
        String quantity = quantityEditText.getText().toString();

        if (symbol.length()>0 && quantity.length()>0){
            retrieveStockFromAPI(symbol, quantity);
        }else{
            if (symbol.length()<1){
                symbolEditText.setError("Enter Symbol");
            }
            if (quantity.length()<1){
                quantityEditText.setError("Enter Quantity");
            }
        }

    }

    private void retrieveStockFromAPI(String symbol, String quantity) {

        String stockLookup = "http://dev.markitondemand.com/MODApis/Api/v2/Lookup/jsonp?input=NFLX&callback=myFunction";


    }



    private void setViews() {
        stocksListView = (ListView) findViewById(R.id.stocksListView);
        addStockButton = (FloatingActionButton) findViewById(R.id.addStockFab);
    }


}
