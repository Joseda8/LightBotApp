package com.example.jdmon.lightbot;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageButton top_button;
    private ImageButton left_button;
    private ImageButton right_button;
    private ImageButton up_button;
    private ImageButton light_on_button;
    private ImageButton play_button;
    private ImageButton trash_button;
    private ImageButton proc1_button;
    private ImageButton proc2_button;
    private ImageButton altern_button;

    private ImageButton space_1;
    private ImageButton space_2;
    private ImageButton space_3;
    private ImageButton space_4;
    private ImageButton space_5;
    private ImageButton space_6;
    private ImageButton space_7;
    private ImageButton space_8;
    private ImageButton space_9;
    private ImageButton space_10;
    private ImageButton space_11;
    private ImageButton space_12;

    private ImageView space_proc_1;
    private ImageView space_proc_2;
    private ImageView space_proc_3;
    private ImageView space_proc_4;
    private ImageView space_proc_5;
    private ImageView space_proc_6;
    private ImageView space_proc_7;
    private ImageView space_proc_8;

    private TextView proc_text;

    List<Integer> moves_list_aux = new ArrayList<Integer>();
    List<Integer> moves = new ArrayList<Integer>();
    List<Integer> moves_proc1 = new ArrayList<Integer>();
    List<Integer> moves_proc2 = new ArrayList<Integer>();
    List<ImageView> spaces_view_list_proc = new ArrayList<ImageView>();
    List<ImageButton> spaces_view_list = new ArrayList<ImageButton>();

    private int i=0;
    private int i_proc1=0;
    private int i_proc2=0;
    private boolean list_selected=true;
    private boolean identifier_proc;
    private boolean do_selection=false;
    private String proc_set_text="PROCEDIMIENTOS";

    private Client client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        top_button = (ImageButton) findViewById(R.id.top);
        top_button.setOnClickListener(this);
        right_button = (ImageButton) findViewById(R.id.right);
        right_button.setOnClickListener(this);
        left_button = (ImageButton) findViewById(R.id.left);
        left_button.setOnClickListener(this);
        up_button = (ImageButton) findViewById(R.id.up);
        up_button.setOnClickListener(this);
        play_button = (ImageButton) findViewById(R.id.play);
        play_button.setOnClickListener(this);
        light_on_button = (ImageButton) findViewById(R.id.light_on);
        light_on_button.setOnClickListener(this);
        trash_button = (ImageButton) findViewById(R.id.trash);
        trash_button.setOnClickListener(this);
        proc1_button = (ImageButton) findViewById(R.id.proc1_button);
        proc1_button.setOnClickListener(this);
        proc2_button = (ImageButton) findViewById(R.id.proc2_button);
        proc2_button.setOnClickListener(this);
        altern_button = (ImageButton) findViewById(R.id.altern_button);
        altern_button.setOnClickListener(this);

        proc_text = (TextView) findViewById(R.id.proc_text_view);

        set_image_list();
        connect_server();
        sleep(250);
    }

    private void process_button(int btn){
        if(i<12){
            switch (btn) {
                case R.id.top:
                    if(list_selected) {
                        moves.add(0);
                        spaces_view_list.get(i).setImageDrawable(getResources().getDrawable(R.drawable.top));
                        i++;
                    }else if(do_selection) {
                        if((i_proc1<8)&&identifier_proc) {
                            moves_proc1.add(0);
                            spaces_view_list_proc.get(i_proc1).setImageDrawable(getResources().getDrawable(R.drawable.top));
                            i_proc1++;
                        }else if(i_proc2<8){
                            moves_proc2.add(0);
                            spaces_view_list_proc.get(i_proc2).setImageDrawable(getResources().getDrawable(R.drawable.top));
                            i_proc2++;
                        }
                    }
                    break;

                case R.id.right:
                    if(list_selected) {
                        moves.add(1);
                        spaces_view_list.get(i).setImageDrawable(getResources().getDrawable(R.drawable.right));
                        i++;
                    }else if(do_selection) {
                        if((i_proc1<8)&&identifier_proc) {
                            moves_proc1.add(1);
                            spaces_view_list_proc.get(i_proc1).setImageDrawable(getResources().getDrawable(R.drawable.right));
                            i_proc1++;
                        }else if(i_proc2<8){
                            moves_proc2.add(1);
                            spaces_view_list_proc.get(i_proc2).setImageDrawable(getResources().getDrawable(R.drawable.right));
                            i_proc2++;
                        }
                    }
                    break;

                case R.id.left:
                    if(list_selected) {
                        moves.add(2);
                        spaces_view_list.get(i).setImageDrawable(getResources().getDrawable(R.drawable.left));
                        i++;
                    }else if(do_selection) {
                        if((i_proc1<8)&&identifier_proc) {
                            moves_proc1.add(2);
                            spaces_view_list_proc.get(i_proc1).setImageDrawable(getResources().getDrawable(R.drawable.left));
                            i_proc1++;
                        }else if(i_proc2<8){
                            moves_proc2.add(2);
                            spaces_view_list_proc.get(i_proc2).setImageDrawable(getResources().getDrawable(R.drawable.left));
                            i_proc2++;
                        }
                    }
                    break;

                case R.id.up:
                    if(list_selected) {
                        moves.add(3);
                        spaces_view_list.get(i).setImageDrawable(getResources().getDrawable(R.drawable.up));
                        i++;
                    }else if(do_selection) {
                        if((i_proc1<8)&&identifier_proc) {
                            moves_proc1.add(3);
                            spaces_view_list_proc.get(i_proc1).setImageDrawable(getResources().getDrawable(R.drawable.up));
                            i_proc1++;
                        }else if(i_proc2<8){
                            moves_proc2.add(3);
                            spaces_view_list_proc.get(i_proc2).setImageDrawable(getResources().getDrawable(R.drawable.up));
                            i_proc2++;
                        }
                    }
                    break;

                case R.id.light_on:
                    if(list_selected) {
                        moves.add(4);
                        spaces_view_list.get(i).setImageDrawable(getResources().getDrawable(R.drawable.on));
                        i++;
                    }else if(do_selection){
                        if((i_proc1<8)&&identifier_proc) {
                            moves_proc1.add(4);
                            spaces_view_list_proc.get(i_proc1).setImageDrawable(getResources().getDrawable(R.drawable.on));
                            i_proc1++;
                        }else if(i_proc2<8){
                            moves_proc2.add(4);
                            spaces_view_list_proc.get(i_proc2).setImageDrawable(getResources().getDrawable(R.drawable.on));
                            i_proc2++;
                        }
                    }
                    break;

                case R.id.proc1_button:
                    if(list_selected){
                        moves.add(5);
                        spaces_view_list.get(i).setImageDrawable(getResources().getDrawable(R.drawable.proc));
                        i++;
                    }else{
                        do_selection=true;
                        identifier_proc=true;
                        proc_set_text="PROCEDIMIENTO 1";
                        proc_text.setText(proc_set_text);
                        if(moves_proc2.isEmpty()==false) {
                            clean_screen();
                        }
                        if(moves_proc1.isEmpty()==false){
                            set_proc_images(moves_proc1);
                        }
                    }
                    break;

                case R.id.proc2_button:
                    if(list_selected){
                        moves.add(6);
                        spaces_view_list.get(i).setImageDrawable(getResources().getDrawable(R.drawable.proc2));
                        i++;
                    }else{
                        do_selection=true;
                        identifier_proc=false;
                        proc_set_text="PROCEDIMIENTO 2";
                        proc_text.setText(proc_set_text);
                        if(moves_proc1.isEmpty()==false) {
                            clean_screen();
                        }
                        if(moves_proc2.isEmpty()==false){
                            set_proc_images(moves_proc2);
                        }
                    }
                    break;

                case R.id.altern_button:
                    list_selected=!list_selected;
                    do_selection=false;
                    proc_text.setText(proc_set_text);
                    Toast.makeText(MainActivity.this, "Cambio", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        switch (btn){
            case R.id.play:
                try {
                    int moves_size = moves.size();
                    moves_list_aux.addAll(moves);
                    if((moves_proc1.isEmpty()==false)||(moves_proc2.isEmpty()==false)) {
                        for (int i = 0; i <= moves_size - 1; i++) {
                            if ((moves.get(i)==5)) {
                                moves.remove(i);
                                moves.addAll(i, moves_proc1);
                                moves_size = moves.size();
                            }
                            if ((moves.get(i)==6)) {
                                moves.remove(i);
                                moves.addAll(i, moves_proc2);
                                moves_size = moves.size();
                            }
                        }
                    }
                    moves_size = moves.size();
                    for (int i = 0; i <= moves_size - 1; i++) {
                        if(moves.get(i)==7){
                            moves.remove(i);
                            moves_size = moves.size();
                            i--;
                        }
                    }


                    Toast.makeText(MainActivity.this, "¡Buena suerte!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, JSONHandler.set_action(moves), Toast.LENGTH_SHORT).show();
                    try{
                        client.send_data(JSONHandler.set_action(moves));
                    }catch(JSONException e){
                    }
                    moves.clear();
                    moves.addAll(moves_list_aux);
                    moves_list_aux.clear();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                break;

            case R.id.trash:
                if(list_selected) {
                    moves.clear();
                    i = 0;
                    for (int i = 0; i <= spaces_view_list.size() - 1; i++) {
                        spaces_view_list.get(i).setImageDrawable(null);
                    }
                }else if(identifier_proc){
                    moves_proc1.clear();
                    i_proc1 = 0;
                    clean_screen();
                }else{
                    moves_proc2.clear();
                    i_proc2 = 0;
                    clean_screen();
                }
                break;

            case R.id.space_view_1:
                PopupMenu popup = new PopupMenu(MainActivity.this, space_1);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(0, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_2:
                popup = new PopupMenu(MainActivity.this, space_2);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(1, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_3:
                popup = new PopupMenu(MainActivity.this, space_3);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(2, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_4:
                popup = new PopupMenu(MainActivity.this, space_4);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(3, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_5:
                popup = new PopupMenu(MainActivity.this, space_5);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(4, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_6:
                popup = new PopupMenu(MainActivity.this, space_6);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(5, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_7:
                popup = new PopupMenu(MainActivity.this, space_7);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(6, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_8:
                popup = new PopupMenu(MainActivity.this, space_8);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(7, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_9:
                popup = new PopupMenu(MainActivity.this, space_9);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(8, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_10:
                popup = new PopupMenu(MainActivity.this, space_10);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(9, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_11:
                popup = new PopupMenu(MainActivity.this, space_11);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(10, new_move);
                        return true;
                    }
                });
                popup.show();
                break;

            case R.id.space_view_12:
                popup = new PopupMenu(MainActivity.this, space_12);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item){
                        int new_move = compare_item_popmenu(item.getTitle().toString());
                        edit_space(11, new_move);
                        return true;
                    }
                });
                popup.show();
                break;
        }
    }

    private int compare_item_popmenu(String compare){
        switch(compare){
            case "Top":
                return 0;
            case "Right":
                return 1;
            case "Left":
                return 2;
            case "Up":
                return 3;
            case "Light":
                return 4;
            case "Proc1":
                return 5;
            case "Proc2":
                return 6;
        }
        return 7;
    }

    private void edit_space(int pos, int new_move){
        spaces_view_list.get(pos).setImageDrawable(null);
        moves.set(pos, new_move);
        switch(new_move){
            case 0:
                spaces_view_list.get(pos).setImageDrawable(getResources().getDrawable(R.drawable.top));
                break;
            case 1:
                spaces_view_list.get(pos).setImageDrawable(getResources().getDrawable(R.drawable.right));
                break;
            case 2:
                spaces_view_list.get(pos).setImageDrawable(getResources().getDrawable(R.drawable.left));
                break;
            case 3:
                spaces_view_list.get(pos).setImageDrawable(getResources().getDrawable(R.drawable.up));
                break;
            case 4:
                spaces_view_list.get(pos).setImageDrawable(getResources().getDrawable(R.drawable.on));
                break;
            case 5:
                spaces_view_list.get(pos).setImageDrawable(getResources().getDrawable(R.drawable.proc));
                break;
            case 6:
                spaces_view_list.get(pos).setImageDrawable(getResources().getDrawable(R.drawable.proc2));
                break;
            case 7:
                moves.set(pos, 7);
                i--;
        }
    }

    private void set_image_list(){
        space_1 = (ImageButton) findViewById(R.id.space_view_1);
        space_2 = (ImageButton) findViewById(R.id.space_view_2);
        space_3 = (ImageButton) findViewById(R.id.space_view_3);
        space_4 = (ImageButton) findViewById(R.id.space_view_4);
        space_5 = (ImageButton) findViewById(R.id.space_view_5);
        space_6 = (ImageButton) findViewById(R.id.space_view_6);
        space_7 = (ImageButton) findViewById(R.id.space_view_7);
        space_8 = (ImageButton) findViewById(R.id.space_view_8);
        space_9 = (ImageButton) findViewById(R.id.space_view_9);
        space_10 = (ImageButton) findViewById(R.id.space_view_10);
        space_11 = (ImageButton) findViewById(R.id.space_view_11);
        space_12 = (ImageButton) findViewById(R.id.space_view_12);
        space_1.setOnClickListener(this);
        space_2.setOnClickListener(this);
        space_3.setOnClickListener(this);
        space_4.setOnClickListener(this);
        space_5.setOnClickListener(this);
        space_6.setOnClickListener(this);
        space_7.setOnClickListener(this);
        space_8.setOnClickListener(this);
        space_9.setOnClickListener(this);
        space_10.setOnClickListener(this);
        space_11.setOnClickListener(this);
        space_12.setOnClickListener(this);
        spaces_view_list.add(space_1);
        spaces_view_list.add(space_2);
        spaces_view_list.add(space_3);
        spaces_view_list.add(space_4);
        spaces_view_list.add(space_5);
        spaces_view_list.add(space_6);
        spaces_view_list.add(space_7);
        spaces_view_list.add(space_8);
        spaces_view_list.add(space_9);
        spaces_view_list.add(space_10);
        spaces_view_list.add(space_11);
        spaces_view_list.add(space_12);
        space_proc_1 = (ImageView) findViewById(R.id.space_view_proc_1);
        space_proc_2 = (ImageView) findViewById(R.id.space_view_proc_2);
        space_proc_3 = (ImageView) findViewById(R.id.space_view_proc_3);
        space_proc_4 = (ImageView) findViewById(R.id.space_view_proc_4);
        space_proc_5 = (ImageView) findViewById(R.id.space_view_proc_5);
        space_proc_6 = (ImageView) findViewById(R.id.space_view_proc_6);
        space_proc_7 = (ImageView) findViewById(R.id.space_view_proc_7);
        space_proc_8 = (ImageView) findViewById(R.id.space_view_proc_8);
        spaces_view_list_proc.add(space_proc_1);
        spaces_view_list_proc.add(space_proc_2);
        spaces_view_list_proc.add(space_proc_3);
        spaces_view_list_proc.add(space_proc_4);
        spaces_view_list_proc.add(space_proc_5);
        spaces_view_list_proc.add(space_proc_6);
        spaces_view_list_proc.add(space_proc_7);
        spaces_view_list_proc.add(space_proc_8);
    }

    private void clean_screen(){
        for (int i = 0; i <= spaces_view_list_proc.size() - 1; i++) {
            spaces_view_list_proc.get(i).setImageDrawable(null);
        }
    }

    private void set_proc_images(List<Integer> list){
        for (int i = 0; i <= list.size() - 1; i++){
            switch(list.get(i)){
                case 0:
                    spaces_view_list_proc.get(i).setImageDrawable(getResources().getDrawable(R.drawable.top));
                    break;
                case 1:
                    spaces_view_list_proc.get(i).setImageDrawable(getResources().getDrawable(R.drawable.right));
                    break;
                case 2:
                    spaces_view_list_proc.get(i).setImageDrawable(getResources().getDrawable(R.drawable.left));
                    break;
                case 3:
                    spaces_view_list_proc.get(i).setImageDrawable(getResources().getDrawable(R.drawable.up));
                    break;
                case 4:
                    spaces_view_list_proc.get(i).setImageDrawable(getResources().getDrawable(R.drawable.on));
                    break;
            }
        }
    }

    private void connect_server() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                client = new Client();
                client.start();
            }
        });
    }

    private void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onClick(View view) {
        process_button(view.getId());
    }
}
