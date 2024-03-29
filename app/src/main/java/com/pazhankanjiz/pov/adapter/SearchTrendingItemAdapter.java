package com.pazhankanjiz.pov.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.pazhankanjiz.pov.R;
import com.pazhankanjiz.pov.model.SearchTrendingItemModel;

import java.util.List;

public class SearchTrendingItemAdapter extends RecyclerView.Adapter<SearchTrendingItemAdapter.SearchTrendingItemViewHolder> {

    private Context mCtx;

    private List<SearchTrendingItemModel> searchTrendingItemModels;

    public SearchTrendingItemAdapter(Context mCtx, List<SearchTrendingItemModel> searchTrendingItemModels) {
        this.mCtx = mCtx;
        this.searchTrendingItemModels = searchTrendingItemModels;
    }

    @NonNull
    @Override
    public SearchTrendingItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.search_trending_item, parent, false);
        return new SearchTrendingItemAdapter.SearchTrendingItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchTrendingItemViewHolder holder, int position) {
        SearchTrendingItemModel searchTrendingItemModel = searchTrendingItemModels.get(position);
        Glide.with(holder.image)
                .load(searchTrendingItemModel.getUrl())
                .into(holder.image);
//        holder.content.setText(searchTrendingItemModel.getTitle());
    }

    @Override
    public int getItemCount() {
        return searchTrendingItemModels.size();
    }

    class SearchTrendingItemViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
//        TextView content;

        public SearchTrendingItemViewHolder(@NonNull View itemView) {
            super(itemView);
//            content = itemView.findViewById(R.id.search_trending_item_name);
            image = itemView.findViewById(R.id.search_trending_item_image);
        }
    }
}
