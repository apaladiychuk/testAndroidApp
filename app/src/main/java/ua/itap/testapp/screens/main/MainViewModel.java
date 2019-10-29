package ua.itap.testapp.screens.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.itap.testapp.model.Customer;
import ua.itap.testapp.rest.RestInterface;

public class MainViewModel extends ViewModel {

    List<Customer> listCustomer = new ArrayList<>();
    Map<String, Customer> mapCustomer = new HashMap<>();
    private MutableLiveData<String>  _custUpdate = new MutableLiveData<>();

    public List<Customer> getListCustomer() {
        return listCustomer;
    }


    public LiveData<String> getCustomerUpdates(){
        return _custUpdate;
    }
    public void setCustomerUpdates( String val ){
        _custUpdate.postValue(val);
    }

    public void loadCustomer() {
        Integer cnt = 20;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        RestInterface rest = retrofit.create(RestInterface.class);
        listCustomer.clear();
        mapCustomer.clear();
        rest.getCustomer(cnt)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> {
                            for ( Customer cust : result.getResults() ) {
                                listCustomer.add(cust);
                                mapCustomer.put( cust.getLogin().getUuid(), cust );
                            }
                           _custUpdate.postValue("OK");
                        },
                        error -> {
                            error.printStackTrace();
                        },
                        () -> {

                        }
                );
    }
}
