package com.example.joanabeleza.hobbytv.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.example.joanabeleza.hobbytv.R;

import java.util.List;

/**
 * Project HobbyTV refactored by joanabeleza on 03/02/2018.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.MyViewHolder> {

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageButton playButton;

        MyViewHolder(View view) {
            super(view);
            playButton = view.findViewById(R.id.play_video_button);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

    private List<String> mVideosUrl;

    public VideosAdapter(List<String> videosUrl) {
        this.mVideosUrl = videosUrl;
    }

    public void update(List<String> data) {
        this.mVideosUrl.clear();
        this.mVideosUrl.addAll(data);
        this.notifyDataSetChanged();
    }

    @Override
    public VideosAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View videoView = inflater.inflate(R.layout.item_video, parent, false);

        return new VideosAdapter.MyViewHolder(videoView);
    }

    @Override
    public void onBindViewHolder(final VideosAdapter.MyViewHolder holder, int position) {
        final String video = mVideosUrl.get(position);

        ImageButton playImageButton = holder.playButton;

        String url = "https://img.youtube.com/vi/"+video+"/0.jpg";
        Glide.with(holder.itemView.getContext()).load(url).into(playImageButton);

        playImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();

                Intent yt_play = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + video));
                Intent chooser = Intent.createChooser(yt_play , "Open With");

                if (yt_play .resolveActivity(context.getPackageManager()) != null) {
                    context.startActivity(chooser);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mVideosUrl.size();
    }
}
