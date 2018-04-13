package com.example.orangesoda.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.orangesoda.Db.NoteBook;
import com.example.orangesoda.Db.NotebookDatabaseHelper;
import com.example.orangesoda.R;
import com.example.orangesoda.Ui.TextEditActivity;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2018/3/1.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>{
    public final static int NAME = 1;//用来判断是哪个intent跳转的
    private List<NoteBook> mNotebookList;
    public  Context mContext;
    private List<NoteBook> readNoteList;

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
    public  NoteAdapter(Context context,List NotebookList){
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
        final ViewHolder holder = new ViewHolder(view);
        holder.text_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                NoteBook noteBook= mNotebookList.get(position);
                Intent intent = new Intent(mContext, TextEditActivity.class);
                intent.putExtra("ActivityName", NAME);
                intent.putExtra("Content", noteBook);
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {
      //   holder.text_number.setText(mNotebookList.get(position).toString());
//        int position1 = holder.getAdapterPosition();
//        readNoteList = DataSupport.findAll(NoteBook.class);
//        mNotebookList.clear();
//       for(NoteBook noteBook : readNoteList){
//         mNotebookList.add(noteBook);
      NoteBook noteBook = mNotebookList.get(position);
        holder.text_title.setText(noteBook.getTitle());
        holder.text_time.setText(new SimpleDateFormat("yy/MM/dd HH:mm:ss").format(noteBook.getDate()));
        holder.text_content.setText(noteBook.getContent());

    }

    @Override
    public int getItemCount() {
        return mNotebookList.size();
    }

}
