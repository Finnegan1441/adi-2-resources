package drewmahrt.generalassemb.ly.databasethreading;

import android.content.Context;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by patrickcummins on 7/20/16.
 */

public class AsyncTask extends android.os.AsyncTask<String, Void, Integer> {
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private Context context;

    public AsyncTask(ProgressBar progressBar, TextView textView, Context context) {
        this.mProgressBar = progressBar;
        this.mTextView = textView;
        this.context = context;
    }
    public void addDatabaseItems(){
        for (int i = 0; i < 1000; i++) {
            ExampleDBHelper.getInstance(context.getApplicationContext()).addName("John","Doe");
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mTextView.setText("Adding items to database...");
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Integer doInBackground(String... params) {
        addDatabaseItems();
        int count = ExampleDBHelper.getInstance(context.getApplicationContext()).getItemCount();
        return count;
    }

    @Override
    protected void onPostExecute(Integer count) {
        super.onPostExecute(count);
        mProgressBar.setVisibility(View.INVISIBLE);
        mTextView.setText("All items added to database! Current item count: " + count);
    }
}
