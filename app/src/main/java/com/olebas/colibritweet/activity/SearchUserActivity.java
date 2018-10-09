package com.olebas.colibritweet.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.olebas.colibritweet.R;
import com.olebas.colibritweet.adapter.UsersAdapter;
import com.olebas.colibritweet.pojo.User;

import java.util.Arrays;
import java.util.Collection;

public class SearchUserActivity extends AppCompatActivity {

    private RecyclerView usersRecyclerView;

    private UsersAdapter usersAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_users);
        initRecyclerView();
        searchUsers();
    }

    private void searchUsers() {
        Collection<User> users = getUsers();
        usersAdapter.setItems(users);
    }

    private Collection<User> getUsers() {
        return Arrays.asList(
                new User(
                        148819271991L,
                        "http://images5.fanpop.com/image/photos/30900000/Joey-s-evil-smile-oggy-and-the-cockroaches-30928993-477-357.jpg",
                        "Oleg Nevoyt",
                        "@olebas13",
                        "Sample description",
                        "Ukraine",
                        42, 44
                ),

                new User(
                        1231242387876L,
                        "https://s11.stc.all.kpcdn.net/share/i/12/10604075/inx960x640.jpg",
                        "Elon Musk",
                        "@elonmusk",
                        "Hat Salesman",
                        "USA",
                        14, 13
                )
        );
    }

    private void initRecyclerView() {
        usersRecyclerView = (RecyclerView) findViewById(R.id.users_recycler_view);
        usersRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        usersAdapter = new UsersAdapter();
        usersRecyclerView.setAdapter(usersAdapter);
    }
}
