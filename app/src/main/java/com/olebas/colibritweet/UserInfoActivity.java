package com.olebas.colibritweet;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserInfoActivity extends AppCompatActivity {

    private CircleImageView userImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userImageView = (CircleImageView) findViewById(R.id.user_image_view);

        Picasso.get().load("http://images5.fanpop.com/image/photos/30900000/Joey-s-evil-smile-oggy-and-the-cockroaches-30928993-477-357.jpg").into(userImageView);
    }
}
