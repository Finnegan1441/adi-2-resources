package drewmahrt.generalassemb.ly.instagramexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import drewmahrt.generalassemb.ly.instagramexample.models.RecentMedia;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private String mAccessToken;
    private ImageView mImage;

    private InstaGramService instaGramService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupApiService();

        mImage = (ImageView)findViewById(R.id.image);
        Intent intent = getIntent();


        mAccessToken = intent.getStringExtra("ACCESS_TOKEN");



        // TODO assign value;


        // TODO: Make the getImage() api call using accessToken
        instaGramService.getImage(mAccessToken).enqueue(new Callback<RecentMedia>() {
            @Override
            public void onResponse(Call<RecentMedia> call, Response<RecentMedia> response) {
                RecentMedia recentMedia = response.body();

                final String imageUrl = recentMedia.getData()[0].getImages().getStandard_resolution().getUrl();


                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Picasso.with(MainActivity.this).load(imageUrl).into(mImage);
                    }
                });
            }

            @Override
            public void onFailure(Call<RecentMedia> call, Throwable t) {

            }
        });

        // TODO: In onResponse() you can use Picasso to load image from url into mImage ImageView

        // TODO: Use image url and pass to picasso like so.
        //Picasso.with(MainActivity.this).load(imageUrl).into(mImage);                        }

        // HINT: Use RecentMedia model to get image url

    }

    private void setupApiService(){
        // Create retrofit instance with a base url and GsonConverter
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(InstagramAppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        instaGramService = retrofit.create(InstaGramService.class);
    }
}
