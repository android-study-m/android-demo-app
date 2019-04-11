package com.pychen0918.myapp.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pychen0918.myapp.R;
import com.pychen0918.myapp.model.DogModel;

import java.util.List;

public class DogListAdapter extends RecyclerView.Adapter<DogListAdapter.DogViewHolder> {
    private Context mContext;
    private List<DogModel> mDogList;

    public DogListAdapter(Context context, List<DogModel> dogList) {
        this.mContext = context;
        this.mDogList = dogList;
    }

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_item_dog, parent, false);
        DogViewHolder holder = new DogViewHolder(view);

        holder.title = view.findViewById(R.id.text_title);
        holder.subtitle = view.findViewById(R.id.text_subtitle);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder holder, int position) {
        DogModel dog = mDogList.get(position);
        holder.title.setText(dog.getName());
        holder.subtitle.setText(dog.getGender());
    }

    @Override
    public int getItemCount() {
        return mDogList.size();
    }

    class DogViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView subtitle;

        DogViewHolder(View view) {
            super(view);
        }
    }
}
