package ua.itap.testapp.screens.detail;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ua.itap.testapp.R;
import ua.itap.testapp.ViewModelFactory;
import ua.itap.testapp.databinding.ActivityDetailBinding;
import ua.itap.testapp.model.Customer;
import ua.itap.testapp.screens.main.MainViewModel;

public class DetailActivity extends AppCompatActivity {
    public static String POSITION = "position";

    MainViewModel viewModel ;
    ActivityDetailBinding databinding;
    Customer customer ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databinding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
       // setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int position = getIntent().getIntExtra(POSITION, 0 );
        ViewModelFactory factory = new ViewModelFactory();
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        customer = viewModel.getListCustomer().get(position);
        customer.presentView();
        databinding.setCustomer(customer);
        ImageView ivPicture = findViewById(R.id.ivLogo);
        new Picasso.Builder(this)
                .build()
                .load(customer.getPicture().get(Customer.PICTURELARGE)).into(ivPicture);
    }

}
