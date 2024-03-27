package com.example.uusin;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private Context context;
    private ArrayList<User> users;

    public UserListAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.user_view, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.firstName.setText(user.getName());
        holder.lastName.setText(user.getLastname());
        holder.email.setText(user.getEmail());
        holder.degreeProgram.setText(user.getMajor());

        // Yhdistä tutkinnot pilkulla erotettuun merkkijonoon ja aseta teksti TextViewiin

        holder.textViewDegrees.setText(user.getDegrees());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView firstName, lastName, email, degreeProgram, textViewDegrees;

        public UserViewHolder(View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.textFirstName);
            lastName = itemView.findViewById(R.id.textLastName);
            email = itemView.findViewById(R.id.textEmail);
            degreeProgram = itemView.findViewById(R.id.textDegreeProgram);
            textViewDegrees = itemView.findViewById(R.id.textUserDegrees);
        }
    }
}
