package com.example.instagarmreplica.adapter;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagarmreplica.R;
import com.example.instagarmreplica.Url;
import com.example.instagarmreplica.model.PostList;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class Post_Adapter extends RecyclerView.Adapter<Post_Adapter.PostViewHolder> {

    Context pContext;
    List<PostList> postLists;

    public Post_Adapter(List<PostList> postLists) {
//        this.pContext = pContext;
        this.postLists = postLists;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_card, parent, false);
        return new PostViewHolder(view, pContext, postLists);
    }

    public void Mode() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostList postList = postLists.get(position);

        String imagePath = Url.BASE_URL + "uploads/" + postList.getPost_image();
        String imagePath1 = Url.BASE_URL + "uploads/" + postList.getPostedby_image();
        Mode();
        try {
            URL url;
            url = new URL(imagePath1);
            holder.circleImageViewProfile.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
//            url = new URL(imagePath);
//            holder.imageViewPost.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            URL url;
            url = new URL(imagePath);
            holder.imageViewPost.setImageBitmap(BitmapFactory.decodeStream((InputStream) url.getContent()));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        holder.circleImageViewProfile.setImageResource(postList.getPostedby_image());
//        holder.circleImageViewAddComment.setImageResource(postList.getComment_img());
//        holder.imageViewPost.setImageResource(postList.getPost_image());
        holder.uname.setText(postList.getPostedby_name());
        holder.subinfo.setText(postList.getSub_info());
        holder.likes.setText(postList.getLikes());
        holder.desc.setText(postList.getDescription());
        holder.captionedby.setText(postList.getPostedby_name());
        holder.viewcomment.setText(postList.getView_comments());
        holder.posttime.setText(postList.getTime());

    }

    @Override
    public int getItemCount() {
        return postLists.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageViewProfile, circleImageViewAddComment;
        TextView uname, subinfo;
        ImageView imageViewPost;
        TextView likes, desc, captionedby, viewcomment, posttime;

        public PostViewHolder(@NonNull View itemView, Context pContext, List<PostList> postLists) {
            super(itemView);
            circleImageViewProfile = itemView.findViewById(R.id.img_profile_image);
            imageViewPost = itemView.findViewById(R.id.img_post);
            circleImageViewAddComment = itemView.findViewById(R.id.img_profile_image_comment);

            uname = itemView.findViewById(R.id.tv_uname);
            subinfo = itemView.findViewById(R.id.tv_subinfo);
            likes = itemView.findViewById(R.id.tv_insta_like_count);
            desc = itemView.findViewById(R.id.tv_insta_Desc);
            captionedby = itemView.findViewById(R.id.tv_insta_cap_name);
            viewcomment = itemView.findViewById(R.id.tv_insta_view_comment);
            posttime = itemView.findViewById(R.id.tv_insta_timeof_post);

        }
    }
}
