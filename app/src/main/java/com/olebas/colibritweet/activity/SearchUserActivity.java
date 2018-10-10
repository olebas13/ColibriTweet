package com.olebas.colibritweet.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.olebas.colibritweet.R;
import com.olebas.colibritweet.adapter.UsersAdapter;
import com.olebas.colibritweet.pojo.User;

import java.util.Arrays;
import java.util.Collection;

public class SearchUserActivity extends AppCompatActivity {

    private RecyclerView usersRecyclerView;

    private UsersAdapter usersAdapter;

    private Toolbar toolbar;
    private EditText queryEditText;
    private Button searchButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_users);
        initRecyclerView();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        queryEditText = (EditText) toolbar.findViewById(R.id.search_edit_text);
        searchButton = (Button) toolbar.findViewById(R.id.search_button);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchUsers();
            }
        });

        queryEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    searchUsers();
                    return true;
                }
                return false;
            }
        });

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void searchUsers() {
        Collection<User> users = getUsers();
        usersAdapter.clearItems();
        usersAdapter.setItems(users);
    }

    private Collection<User> getUsers() {
        return Arrays.asList(
                new User(
                        148819271991L,
                        "http://www.mostvideo.org/data/big/2oggy_3.jpg",
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

        UsersAdapter.OnUserClickListener onUserClickListener = new UsersAdapter.OnUserClickListener() {
            @Override
            public void onUserClick(User user) {
                Intent intent = new Intent(SearchUserActivity.this, UserInfoActivity.class);
                intent.putExtra(UserInfoActivity.USER_ID, user.getId());
                startActivity(intent);
            }
        };

        usersAdapter = new UsersAdapter(onUserClickListener);
        usersRecyclerView.setAdapter(usersAdapter);
    }
}
