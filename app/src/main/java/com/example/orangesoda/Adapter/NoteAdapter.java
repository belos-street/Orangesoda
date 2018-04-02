package com.example.orangesoda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orangesoda.R;
import com.example.orangesoda.Ui.TextEditActivity;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2018/3/1.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
    private List<String> mNotebookList;
    public  Context mContext;
    static class ViewHolder extends  RecyclerView.ViewHolder{
        private  RelativeLayout text_rl;
        TextView text_time,text_title,text_content,text_number;
        ImageView text_sign_img;
        public  ViewHolder(View view){
            super(view);
            text_rl = (RelativeLayout)view.findViewById(R.id.text_rl);
            text_time = (TextView)view.findViewById(R.id.text_time);
            text_title = (TextView)view.findViewById(R.id.text_title);
            text_number = (TextView)view.findViewById(R.id.text_number);
            text_content = (TextView)view.findViewById(R.id.text_content);
            text_sign_img = (ImageView)view.findViewById(R.id.text_sign_img);

        }

    }
    public  NoteAdapter(Context context,List<String> NotebookList){
        mContext = context;
        mNotebookList = NotebookList;
    }
    public void removeData(int position){
        mNotebookList.remove(position);
        notifyItemRemoved(position);

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notebook_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
        holder.text_number.setText(mNotebookList.get(position));
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("data",MODE_PRIVATE);
        String title = sharedPreferences.getString("title","");
        String content = sharedPreferences.getString("content","");
    holder.text_rl.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent_edit = new Intent(v.getContext(), TextEditActivity.class);
             v.getContext().startActivity(intent_edit);
        }
    });
      //  holder.text_number.setText(holder.getAdapterPosition());
    //  Notebook notebook = mNotebookList.get(position);
        holder.text_title.setText(title);
        holder.text_content.setText(content);
    }

    @Override
    public int getItemCount() {
        return mNotebookList.size();
    }

}
