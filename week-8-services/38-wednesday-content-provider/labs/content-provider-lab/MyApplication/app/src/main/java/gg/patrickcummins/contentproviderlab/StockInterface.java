package gg.patrickcummins.contentproviderlab;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by patrickcummins on 7/27/16.
 */

public interface StockInterface {

    @GET()
    Call<Stock> getStock(@Query("Symbol") String symbol,
                         @Query("Name") String name,
                         @Query("Exchange") String exchange);
}
