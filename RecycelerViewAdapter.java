package net.skillbooster.normaljsontest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecycelerViewAdapter extends RecyclerView.Adapter<DataViewHolder> {

    private ArrayList<DataList> arrayList;
    private Context context;

    public RecycelerViewAdapter() {
    }

    public RecycelerViewAdapter(ArrayList<DataList> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new DataViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder dataViewHolder, int i) {
              DataList currentDatalist = arrayList.get(i);
        dataViewHolder.name.setText(currentDatalist.getName());
        dataViewHolder.color.setText(currentDatalist.color);
        dataViewHolder.partner.setText(currentDatalist.getPartner());
        dataViewHolder.age.setText(currentDatalist.getAge());
        dataViewHolder.owner.setText(currentDatalist.getOwner());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
