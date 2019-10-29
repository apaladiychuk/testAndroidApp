package ua.itap.testapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import ua.itap.testapp.screens.detail.DetailActivity;
import ua.itap.testapp.screens.main.MainViewAdapter;
import ua.itap.testapp.screens.main.MainViewModel;

public class MainActivity extends AppCompatActivity implements RecycleClickListener {

    RecyclerView customerList ;
    MainViewModel viewModel ;
    MainViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        customerList = findViewById(R.id.listCustomer);
        ViewModelFactory factory = new ViewModelFactory();
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel.class);
        setupAdapter();
        initObserver();
        viewModel.loadCustomer();
    }

    private void setupAdapter(){
        adapter = new MainViewAdapter(viewModel.getListCustomer(),this.getApplicationContext(),this );
        customerList.setLayoutManager(new LinearLayoutManager(this));
        customerList.setAdapter(adapter);

    }
    private void initObserver(){
        LiveData<String> custUpdate = viewModel.getCustomerUpdates();
        custUpdate.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                adapter.notifyDataSetChanged();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(Integer position) {
         Intent intent = new Intent(this, DetailActivity.class);
         intent.putExtra(DetailActivity.POSITION , position);
         this.startActivity(intent);
    }
}
