package com.example.instagarmreplica.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.instagarmreplica.Apis.Postapi;
import com.example.instagarmreplica.Apis.Storyapi;
import com.example.instagarmreplica.Bottom_nav;
import com.example.instagarmreplica.Login;
import com.example.instagarmreplica.R;
import com.example.instagarmreplica.Url;
import com.example.instagarmreplica.adapter.Post_Adapter;
import com.example.instagarmreplica.adapter.Story_Adapter;
import com.example.instagarmreplica.model.PostList;
import com.example.instagarmreplica.model.Story;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView, stryRecycler;
    //    public static List<PostList> postLists;
    public List<Story> storyLists;
    private static final String TAG = "HomeFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.insta_recyclerview);
        stryRecycler = view.findViewById(R.id.insta_recyclerview_stories);

        storyLists = new ArrayList<>();

//        storyLists.add(new Story(R.drawable.emmaprofile, "emmawatson"));
//        storyLists.add(new Story(R.drawable.ntbprofile, "ronaldinho"));
//        storyLists.add(new Story(R.drawable.emmaprofile, "emmawatson"));
//        storyLists.add(new Story(R.drawable.ntbprofile, "ronaldinho"));
//        storyLists.add(new Story(R.drawable.emmaprofile, "emmawatson"));
//        storyLists.add(new Story(R.drawable.ntbprofile, "ronaldinho"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        Story_Adapter adapter = new Story_Adapter(storyLists, getContext());
        stryRecycler.setAdapter(adapter);
        stryRecycler.setLayoutManager(layoutManager);

        getAllStories();
        allPost();

        return view;
    }

    private void allPost() {
        try {
            Postapi postapi = Url.getInstance().create(Postapi.class);
            Call<List<PostList>> listCall = postapi.getPosts();

            listCall.enqueue(new Callback<List<PostList>>() {
                @Override
                public void onResponse(Call<List<PostList>> call, Response<List<PostList>> response) {
                    List<PostList> postLists = response.body();
                    Post_Adapter post_adapter = new Post_Adapter(postLists);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(post_adapter);
                }

                @Override
                public void onFailure(Call<List<PostList>> call, Throwable t) {
                    Log.e(TAG, "onFailure: " + t.getLocalizedMessage());

                }
            });

        } catch (Exception e) {

        }

    }

    private void getAllStories(){

        try{
            Storyapi story = Url.getInstance().create(Storyapi.class);
            Call<List<Story>> storyCall = story.getStories();

            storyCall.enqueue(new Callback<List<Story>>() {
                @Override
                public void onResponse(Call<List<Story>> call, Response<List<Story>> response) {
                    List<Story> storyModel = response.body();

                    stryRecycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
                    Story_Adapter adapter = new Story_Adapter(storyModel, getContext());
                    stryRecycler.setAdapter(adapter);

                }

                @Override
                public void onFailure(Call<List<Story>> call, Throwable t) {
                    Toast.makeText(getContext(), "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e){
            Toast.makeText(getContext(), "Error: " + e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
