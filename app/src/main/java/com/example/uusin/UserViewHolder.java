package com.example.uusin;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView firstName, lastName, email, degreeProgram;
    TextView textViewDegrees;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewDegrees = itemView.findViewById(R.id.textUserDegrees);
        firstName = itemView.findViewById(R.id.textFirstName);
        lastName = itemView.findViewById(R.id.textLastName);
        email = itemView.findViewById(R.id.textEmail);
        degreeProgram = itemView.findViewById(R.id.textDegreeProgram);

    }
}


