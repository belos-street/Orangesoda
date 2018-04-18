package com.example.orangesoda.Ui;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.orangesoda.Adapter.NoteAdapter;
import com.example.orangesoda.Db.NoteBook;
import com.example.orangesoda.R;
import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
import com.yanzhenjie.recyclerview.swipe.touch.OnItemMoveListener;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainDrawerLayout extends TitleInit implements View.OnClickListener{
    private List<NoteBook> notebookAddList = new ArrayList<>();
    private DrawerLayout drawer;
    public final static int NAME = 0;
    public NoteAdapter adapter;
    public ImageView image_change_list;
    private int IS_CHANGE_LIST = 1;
    private SwipeMenuRecyclerView swipeMenuRecyclerView;
    private LinearLayoutManager layoutManager;
    private  SwipeMenuCreator mSwipeMenuCreator;
    private  SwipeMenuItemClickListener menuItemClickListener;
    private SwipeMenuItem collectItem1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_drawer_layout_activity);
        immersionSystemBar();
        LitePal.getDatabase();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        notebookAddList = DataSupport.findAll(NoteBook.class);
        swipeMenuRecyclerView =(SwipeMenuRecyclerView) findViewById(R.id.recycle_view);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true); //倒叙显示
        swipeMenuRecyclerView.setLayoutManager(layoutManager);
        mSwipeMenuCreator = new SwipeMenuCreator() {
            @Override
            public void onCreateMenu(SwipeMenu leftMenu, SwipeMenu rightMenu, int viewType) {
                 collectItem1 = new SwipeMenuItem(getApplicationContext())
                        .setBackground(R.color.yellow)
                        .setText("收藏") // 文字。
                        //.setImage(R.mipmap.collect)
                        .setTextColor(Color.WHITE) // 文字颜色。
                        .setTextSize(20) // 文字大小。
                        .setWidth(260)
                        .setHeight(260);
                // 各种文字和图标属性设置。
                rightMenu.addMenuItem(collectItem1); // 在Item右侧添加一个菜单。
                SwipeMenuItem delete1Item2 = new SwipeMenuItem(getApplicationContext())
                        .setBackground(R.color.orange)
                        .setText("删除") // 文字。
                        .setTextColor(Color.WHITE) // 文字颜色。
                        .setTextSize(20) // 文字大小。
                        .setWidth(240)
                        .setHeight(260);

                // 各种文字和图标属性设置。
                rightMenu.addMenuItem(delete1Item2); // 在Item右侧添加一个菜单。
                // 注意：哪边不想要菜单，那么不要添加即可。
            }
        };
        menuItemClickListener= new SwipeMenuItemClickListener() {
            @Override
            public void onItemClick(SwipeMenuBridge menuBridge) {
                // 任何操作必须先关闭菜单，否则可能出现Item菜单打开状态错乱。
                menuBridge.closeMenu();
                int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
                int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
                int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
                if(menuPosition == 0){
                    Toast.makeText(MainDrawerLayout.this, "已收藏", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(menuPosition ==1){
                    int position = adapterPosition;
                    int id = notebookAddList.get(position).getId();
                    notebookAddList.remove(position);  // Item被侧滑删除时，删除数据，并更新adapter。
                  deleteData(id);//同时删除数据库的内容
                    adapter.notifyItemRemoved(position);
                    return;
                }
            }
        };
        swipeMenuRecyclerView.setSwipeMenuCreator(mSwipeMenuCreator);
        swipeMenuRecyclerView.setSwipeMenuItemClickListener(menuItemClickListener);

        adapter = new NoteAdapter(getApplicationContext(),notebookAddList);
        swipeMenuRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        image_change_list = (ImageView) findViewById(R.id.change_list_view);
        image_change_list.setImageResource(R.drawable.changes_waterfall);



        FloatingActionButton floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainDrawerLayout.this, TextEditActivity.class);
                intent.putExtra("ActivityName", NAME);
                startActivity(intent);
            }
        });

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
            case R.id.change_list_view:
               if(IS_CHANGE_LIST == 1){
                   IS_CHANGE_LIST = 0;
                   image_change_list.setImageResource(R.drawable.changes_waterfall);
                  swipeMenuRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
               }else if(IS_CHANGE_LIST ==0){
                   image_change_list.setImageResource(R.drawable.changes_list);
                  swipeMenuRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));//指定RecyclerView为线性布局
                   IS_CHANGE_LIST = 1;
               }
                break;

            default:
                break;

        }
    }

    @Override
    public void onResume() {
        super.onResume();
       notebookAddList.clear(); //去掉之前的数据
        List<NoteBook> newList = DataSupport.findAll(NoteBook.class);
        notebookAddList.addAll(newList);//注意要将数据复制过来，而不是直接使用，不然无法更新数据
       adapter.notifyDataSetChanged();

    }


    //删除数据库的内容
    public void deleteData(int id){
        DataSupport.deleteAll(NoteBook.class, "id = ?", String.valueOf(id));
        Log.d("TAG", "deleteData: " + id);
    }

}
