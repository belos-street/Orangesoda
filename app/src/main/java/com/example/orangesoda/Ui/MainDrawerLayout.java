package com.example.orangesoda.Ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.orangesoda.Adapter.NoteAdapter;
import com.example.orangesoda.Adapter.Notebook;
import com.example.orangesoda.AddActivity;
import com.example.orangesoda.Db.NotebookDatabaseHelper;
import com.example.orangesoda.MainActivity;
import com.example.orangesoda.R;

import java.util.ArrayList;
import java.util.List;

public class MainDrawerLayout extends TitleInit {
    private List notebookList = new ArrayList<>();
    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_drawer_layout_activity);
        immersionSystemBar();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        RecyclerView recyclerView =(RecyclerView)findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NoteAdapter adapter = new NoteAdapter(getApplicationContext(),notebookList);
        recyclerView.setAdapter(adapter);
        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDrawerLayout.this,TextEditActivity.class);
                startActivity(intent);
                notebookList.add("");

            }
        });
        adapter.notifyDataSetChanged();
      //  init();

    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        startActivity(intent);
    }
    public void onClick(View v){
        int id = v.getId();
        switch (id){
            case R.id.collect:
            Toast.makeText(MainDrawerLayout.this,"该功能还未完成...",Toast.LENGTH_SHORT).show();
            break;
            case R.id.question:
                Toast.makeText(MainDrawerLayout.this,"该功能还未完成...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.night:
                Toast.makeText(MainDrawerLayout.this,"该功能还未完成...",Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                startActivity(new Intent(MainDrawerLayout.this,SettingActivity.class));
                break;
            case R.id.about:
               startActivity( new Intent(MainDrawerLayout.this,AboutUsActivity.class));
                break;
            case R.id.main_head:
                drawer.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
    }
//   private  void init(){
//        for(int i = 0 ;i<9;i++){
//            notebookList.add(i);
//        }
//   }

}
