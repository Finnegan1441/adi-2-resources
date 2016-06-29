package ly.generalassemb.drewmahrt.iconlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import static android.R.attr.description;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        int id = intent.getIntExtra("id", -1);
        IconSQLiteOpenHelper helper = IconSQLiteOpenHelper.getInstance(DetailActivity.this);

        if (id>=0) {
            TextView mTextView = (TextView) findViewById(R.id.detailTextView);
            ImageView mImageView = (ImageView) findViewById(R.id.detailImageView);

            String description = helper.getDescriptionByID(id);
            mImageView.setImageResource(getDrawableValue(description));
            mTextView.setText(description);
        }




    }
    private int getDrawableValue(String icon){
        switch(icon){
            case "search":
                return android.R.drawable.ic_menu_search;
            case "add":
                return android.R.drawable.ic_menu_add;
            case "upload":
                return android.R.drawable.ic_menu_upload;
            case "play":
                return android.R.drawable.ic_media_play;
            default:
                return 0;
        }
    }
}
