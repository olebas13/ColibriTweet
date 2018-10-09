package com.olebas.colibritweet.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.olebas.colibritweet.R;
import com.olebas.colibritweet.pojo.User;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private List<User> userList = new ArrayList<>();

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item_view, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        holder.bind(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public void setItems(Collection<User> users) {
        userList.addAll(users);
        notifyDataSetChanged();
    }

    public void clearItems() {
        userList.clear();
        notifyDataSetChanged();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView userImageView;
        private TextView nameTextView;
        private TextView nickTextView;

        public UsersViewHolder(View itemView) {
            super(itemView);
            userImageView = (CircleImageView) itemView.findViewById(R.id.profile_image_view);
            nameTextView = (TextView) itemView.findViewById(R.id.user_name_text_view);
            nickTextView = (TextView) itemView.findViewById(R.id.user_nick_text_view);
        }

        public void bind(User user) {
            nameTextView.setText(user.getName());
            nickTextView.setText(user.getNick());
            Picasso.get().load(user.getImgUrl()).into(userImageView);
        }
    }
}
