package com.example.a1_hw4_recview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MessageAdapter messageAdapter;
    private ArrayList<MessageModel> list;

    EditText name;
    EditText message;
    Button save;


    private final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        messageAdapter = new MessageAdapter(list, this);
        recyclerView.setAdapter(messageAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        name = findViewById(R.id.et_name);
        message = findViewById(R.id.et_message);
        save = findViewById(R.id.btn_save);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration( this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    public void save(View view) {
        if (!name.getText().toString().equals("") && !message.getText().toString().equals("")) {
            list.add(new MessageModel(name.getText().toString(), message.getText().toString()));
            messageAdapter.notifyDataSetChanged();
            name.setText("");
            message.setText("");
        } else {
            Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList(KEY,list);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        list.addAll((savedInstanceState.getParcelableArrayList(KEY)));

    }
}