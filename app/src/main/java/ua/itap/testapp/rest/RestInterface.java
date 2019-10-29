package ua.itap.testapp.rest;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ua.itap.testapp.model.CustomerResponse;

public interface RestInterface {

    @GET("api/")
    Observable<CustomerResponse> getCustomer(@Query("results") Integer items ) ;
}
