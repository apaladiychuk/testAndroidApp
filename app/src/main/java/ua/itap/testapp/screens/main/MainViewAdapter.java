package ua.itap.testapp.screens.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ua.itap.testapp.R;
import ua.itap.testapp.RecycleClickListener;
import ua.itap.testapp.model.Customer;

public class MainViewAdapter  extends RecyclerView.Adapter<CustomerHolder> {
    private  final List<Customer> mValues;
    private final RecycleClickListener mListener ;

    private Picasso picasso;
    public MainViewAdapter(List<Customer> mValues, Context context, RecycleClickListener listener ) {
        this.mValues = mValues;
        this.mListener = listener;
        picasso = new Picasso.Builder(context).build();
    }

    @NonNull
    @Override
    public CustomerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_customer_item, parent, false);
        return new CustomerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerHolder holder, int position) {
        Customer item = mValues.get(position);
        holder.tvName.setText(item.getCustomerName());
        holder.tvName.setTag(position) ;
        picasso.load(item.getPicture().get(Customer.PICTURESMALL)).into(holder.ivImage);
        holder.itemView.setOnClickListener(l->{
            mListener.onClick( (Integer) holder.tvName.getTag());
        });


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
