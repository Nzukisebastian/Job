package com.example.job;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;


public class AdapterList extends RecyclerView.Adapter<AdapterList.HolderItem>{
    List<ModelList> mListItem;
    Context context;
    public AdapterList(List<ModelList> mListItem, Context context) {
        this.mListItem = mListItem;
        this.context = context;}

    @Override
    public HolderItem onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_rows,parent,false);
        HolderItem holder=new HolderItem(layout);
        return holder;
    }
    @Override
    public void onBindViewHolder(final HolderItem holder, final int position) {
        final ModelList mlist=mListItem.get(position);
        holder.cnames.setText(mlist.getCname());
        holder.jobnames.setText(mlist.getJobname());
        holder.contacts.setText(mlist.getContact());
        holder.locations.setText(mlist.getLocation());
       holder.salarys.setText(mlist.getSalary());
      holder.descriptions.setText(mlist.getDescription());
    }

    @Override
    public int getItemCount() {
        return mListItem.size();
    }

    public class HolderItem extends RecyclerView.ViewHolder{
        TextView cnames,jobnames,contacts,locations,salarys,descriptions;
        CardView cardView;
        public ImageView imgs;

        public HolderItem(View v) {
            super(v);
            cnames=(TextView) v.findViewById(R.id.cname);
            jobnames=(TextView) v.findViewById(R.id.jobname);
            contacts=(TextView) v.findViewById(R.id.etcontactx);
            locations=(TextView) v.findViewById(R.id.etlocations);
            salarys=(TextView) v.findViewById(R.id.etsalaryx);
            descriptions=(TextView) v.findViewById(R.id.etdescriptionx);
            cardView=(CardView)v.findViewById(R.id.cardview);
        }
    }
}
