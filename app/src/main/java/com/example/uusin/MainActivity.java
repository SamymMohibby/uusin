package com.example.uusin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserStorage.getInstance().loadUsers(this);
        //UserStorage.getInstance().printFileContents(this);
        //UserStorage.getInstance().showToastWithFilePath(this);
    }
    UserStorage s = UserStorage.getInstance();

    public void switchToAddUserActivity(View view){
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);

    }
    public void switchToListUsersInRecyclerViewActivity(View view){
        Intent intent = new Intent(this, ListUsersInRecyclerViewActivity.class);
        startActivity(intent);
    }

}

