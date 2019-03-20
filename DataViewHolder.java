package net.skillbooster.normaljsontest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class DataViewHolder extends RecyclerView.ViewHolder {
    TextView name,age,owner,partner,color;
    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.row_name);
        age = itemView.findViewById(R.id.row_age);
        owner = itemView.findViewById(R.id.row_owner);
        partner = itemView.findViewById(R.id.row_partner);
        color = itemView.findViewById(R.id.row_color);
    }
}
