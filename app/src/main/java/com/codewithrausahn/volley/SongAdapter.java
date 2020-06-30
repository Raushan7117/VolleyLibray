package com.codewithrausahn.volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {

 List<Song> songs;
 LayoutInflater inflater;

 public SongAdapter(Context mctx,List<Song> songs){
     this.inflater=LayoutInflater.from(mctx);
     this.songs=songs;

 }


    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view=inflater.inflate(R.layout.list_item,parent,false);

        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        holder.mtitle.setText(songs.get(position).getTitle());
        holder.msongArtst.setText(songs.get(position).getArtists());
        Picasso.get().load(songs.get(position).getCoverImage())
                .into(holder.mimageView);
    }




    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class SongViewHolder extends RecyclerView.ViewHolder{

       public ImageView mimageView;
       public TextView mtitle,msongArtst;

        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            mtitle=itemView.findViewById(R.id.songTitle);
            msongArtst=itemView.findViewById(R.id.songArtist);
            mimageView=itemView.findViewById(R.id.coverImage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "Do Something With this Click", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
