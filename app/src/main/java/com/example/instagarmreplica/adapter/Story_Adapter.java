package com.example.instagarmreplica.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagarmreplica.R;
import com.example.instagarmreplica.Url;
import com.example.instagarmreplica.model.Story;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Story_Adapter extends RecyclerView.Adapter<Story_Adapter.StoryViewAdapter> {

    private List<Story> listStories;
    private Context mContext;

    public Story_Adapter(List<Story> listStories, Context mContext) {
        this.listStories = listStories;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Story_Adapter.StoryViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false);
        return new StoryViewAdapter(view);
    }

    private void Mode(){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onBindViewHolder(@NonNull Story_Adapter.StoryViewAdapter holder, int position) {

//        holder.story_image.setImageResource(story.getStory_image());
//        holder.posted_by.setText(story.getStory_posted_by());

        Story story = listStories.get(position);
        int get = holder.getAdapterPosition();
        String imgPath = Url.BASE_URL + "uploads/" + story.getStory_image();
        Mode();
        try{
            URL url;
            url = new URL(imgPath);
            holder.story_image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        holder.posted_by.setText(story.getStory_posted_by());
//        URL url = null;

//        if(get == 0){
//            try{
//                url = new URL(imgPath);
//                holder.story_image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                holder.story_image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            holder.posted_by.setText("Your Story");
//            holder.addStory.setVisibility(View.VISIBLE);
//
//        }else{
//            Story story1 = listStories.get(position);
//            try {
//                holder.story_image.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            holder.posted_by.setText(story1.getStory_posted_by());
//            holder.addStory.setVisibility(View.INVISIBLE);
//        }

    }

    @Override
    public int getItemCount() {
        return listStories.size();
    }

    public class StoryViewAdapter extends RecyclerView.ViewHolder {

        CircleImageView story_image,addStory;
        TextView posted_by;
        Context mContext;
        List<Story> list;

        public StoryViewAdapter(@NonNull View itemView) {
            super(itemView);
            story_image =itemView.findViewById(R.id.img_story);
            posted_by = itemView.findViewById(R.id.tvposted_by);
            addStory = itemView.findViewById(R.id.imgstry_add);
            this.mContext = mContext ;
            this.list = list;


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Story story = list.get(getAdapterPosition());
                    Toast.makeText(mContext, "" + story.getStory_posted_by(), Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
