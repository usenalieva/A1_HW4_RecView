package com.example.a1_hw4_recview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageHolder> {

     ArrayList<MessageModel> list;
     Context context;


    public MessageAdapter(ArrayList<MessageModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate( R.layout.recyclerview, parent,false);
        MessageHolder messageHolder = new MessageHolder(view);
        return  messageHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
    MessageModel  messageModel = list.get(position);
    holder.tv_name.setText(messageModel.getName());
    holder.tv_message.setText(messageModel.getMessage());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MessageHolder extends RecyclerView.ViewHolder {
        TextView  tv_name;
        TextView tv_message;


        public MessageHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_message = itemView.findViewById(R.id.tv_message);

        }
    }
}
