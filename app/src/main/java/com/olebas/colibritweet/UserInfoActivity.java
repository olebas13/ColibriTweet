package com.olebas.colibritweet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.olebas.colibritweet.adapter.TweetAdapter;
import com.olebas.colibritweet.pojo.Tweet;
import com.olebas.colibritweet.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.Collection;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends AppCompatActivity {

    private CircleImageView userImageView;
    private TextView nameTextView;
    private TextView nickTextView;
    private TextView descriptionTextView;
    private TextView locationTextView;
    private TextView followingCountTextView;
    private TextView followersCountTextView;
    private RecyclerView tweetsRecyclerView;

    private TweetAdapter tweetAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userImageView = (CircleImageView) findViewById(R.id.user_image_view);
        nameTextView = (TextView) findViewById(R.id.user_name_text_view);
        nickTextView = (TextView) findViewById(R.id.user_nick_text_view);
        descriptionTextView = (TextView) findViewById(R.id.user_description_text_view);
        locationTextView = (TextView) findViewById(R.id.user_location_text_view);
        followingCountTextView = (TextView) findViewById(R.id.following_count_text_view);
        followersCountTextView = (TextView) findViewById(R.id.followers_count_text_view);

        loadUserInfo();
        initRecyclerView();
        loadTweets();
    }

    private void loadTweets() {
        Collection<Tweet> tweets = getTweets();
        tweetAdapter.setItems(tweets);
    }

    private Collection<Tweet> getTweets() {
        return Arrays.asList(
                new Tweet(getUser(), 1L, "Thu Dec 13 07:31:08 +0000 2017", "Очень длинное описание твита 1",
                        4L, 5L, "https://i.ytimg.com/vi/XKo17M21Xp8/maxresdefault.jpg"),
                new Tweet(getUser(), 2L, "Thu Dec 12 12:25:37 +0000 2017", "Очень длинное описание твита 2",
                        10L, 9L, "https://i1.wp.com/vamers.com/wp-content/uploads/2016/07/Vamers-Ermahgerd-Animation-Humour-Batmans-Band-of-Metalheads-Are-Back-in-BATMETAL-RETURNS-Banner.jpg"),
                new Tweet(getUser(), 3L, "Thu Dec 11 14:25:44 +0000 2017", "Очень длинное описание твита 3",
                        5L, 8L, "https://avatars.mds.yandex.net/get-zen_doc/196516/pub_5ac0c9fc5991d33f1beb3d53_5ac0cc5a79885e04e139733d/scale_600")
        );
    }

    private void initRecyclerView() {
        tweetsRecyclerView = (RecyclerView) findViewById(R.id.tweets_recycler_view);
        tweetsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        tweetAdapter = new TweetAdapter();
        tweetsRecyclerView.setAdapter(tweetAdapter);
    }

    private void loadUserInfo() {
        User user = getUser();
        displayUserInfo(user);
    }

    private User getUser() {
        return new User(
                1L,
                "http://images5.fanpop.com/image/photos/30900000/Joey-s-evil-smile-oggy-and-the-cockroaches-30928993-477-357.jpg",
                "Oleg Nevoyt",
                "@olebas13",
                "Sample Description",
                "Ukraine",
                42,
                44
        );
    }

    private void displayUserInfo(User user) {
        Picasso.get().load(user.getImgUrl()).into(userImageView);
        nameTextView.setText(user.getName());
        nickTextView.setText(user.getNick());
        descriptionTextView.setText(user.getDescription());
        locationTextView.setText(user.getLocation());

        String followingCount = String.valueOf(user.getFollowingCount());
        followingCountTextView.setText(followingCount);

        String followersCount = String.valueOf(user.getFollowersCount());
        followersCountTextView.setText(followersCount);
    }

}
