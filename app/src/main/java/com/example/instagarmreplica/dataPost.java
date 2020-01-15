package com.example.instagarmreplica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.instagarmreplica.Apis.Postapi;
import com.example.instagarmreplica.model.PostList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

//import static com.example.instagarmreplica.fragments.HomeFragment.postLists;

public class dataPost extends AppCompatActivity {
    TextView postData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_post);

        postData = findViewById(R.id.apidatapost);

        Postapi postapi = Url.getInstance().create(Postapi.class);
        Call<List<PostList>> listCallPost = postapi.getPosts();

        listCallPost.enqueue(new Callback<List<PostList>>() {
            @Override
            public void onResponse(Call<List<PostList>> call, Response<List<PostList>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(dataPost.this, "Error!!", Toast.LENGTH_SHORT).show();
                    return;
                }

                List<PostList> postLists = response.body();
                for (PostList postList : postLists) {
                    String postContent = "";
                    postContent += "postedby_name : " + postList.getPostedby_name();
//                    postContent += "postedby_image : " + postList.getPostedby_image();
//                    postContent += "post_image : " + postList.getPost_image();
                    postContent += "description : " + postList.getDescription();

                    postData.append(postContent);
                }

            }

            @Override
            public void onFailure(Call<List<PostList>> call, Throwable t) {
                postData.setText("Error" + t.getMessage());
            }
        });
    }
}
