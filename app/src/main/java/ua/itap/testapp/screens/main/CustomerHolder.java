package ua.itap.testapp.screens.main;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ua.itap.testapp.R;

public class CustomerHolder extends  RecyclerView.ViewHolder {
    ImageView  ivImage ;
    TextView tvName ;
    public CustomerHolder(@NonNull View itemView) {
        super(itemView);
        ivImage = itemView.findViewById(R.id.ivPicture);
        tvName = itemView.findViewById(R.id.tvName);
    }

}
