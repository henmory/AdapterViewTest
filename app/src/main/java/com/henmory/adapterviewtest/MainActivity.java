package com.henmory.adapterviewtest;

import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView lv ;
    private Button btn_add;
    private Button btn_modify;
    private Button btn_delete;
    private ArrayList<Animal> animals;
    private GridView gv;
    private ArrayList<Icon> icons;
    private Spinner spinner1;
    private Spinner spinner2;
//    private AnimalAdapter animalAdapter;
//    private AnimalAdapterWithCommonViewHolder animalAdapter;
    private AnimalAdapterWithCommonAdapter animalAdapter;
    static int selected = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        lv = (ListView) findViewById(R.id.list_mylist);
//        String name[] = {"数学","语文","物理","化学"};
//        String desc[] = {"数学不好学","语文不会","物理太难","化学稍微还好"};
//        int image[] = {android.R.drawable.sym_call_incoming, android.R.drawable.sym_action_call,
//                android.R.drawable.sym_action_chat, android.R.drawable.sym_action_email};
//        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
//        for (int i = 0; i < 4; i++) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("name", name[i]);
//            map.put("desc", desc[i]);
//            map.put("image", image[i]);
//            list.add(map);
//        }
//        SimpleAdapter sa = new SimpleAdapter(this, list, R.layout.listview_item, new String[]{"image","name","desc"},
//                new int[]{R.id.image_id, R.id.name_id, R.id.desc_id});
//        lv.setAdapter(sa);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                System.out.println(position);
//            }
//        });

        //baseAdapterExtendTest();
//        testGridView();
        testSpinner();
    }

    public void baseAdapterExtendTest(){

        lv = (ListView) findViewById(R.id.list_mylist);
        animals = new ArrayList<>();
        animals.add(new Animal("狗","你是狗么",android.R.drawable.sym_call_incoming));
        animals.add(new Animal("牛","你是牛么",android.R.drawable.sym_action_chat));
        animals.add(new Animal("猪","你是猪么",android.R.drawable.sym_action_email));
        animals.add(new Animal("狗","你是狗么",android.R.drawable.sym_call_incoming));
        animals.add(new Animal("牛","你是牛么",android.R.drawable.sym_action_chat));
        animals.add(new Animal("猪","你是猪么",android.R.drawable.sym_action_email));
        animals.add(new Animal("狗","你是狗么",android.R.drawable.sym_call_incoming));
        animals.add(new Animal("牛","你是牛么",android.R.drawable.sym_action_chat));
        animals.add(new Animal("猪","你是猪么",android.R.drawable.sym_action_email));
        animals.add(new Animal("狗","你是狗么",android.R.drawable.sym_call_incoming));
        animals.add(new Animal("牛","你是牛么",android.R.drawable.sym_action_chat));
        animals.add(new Animal("猪","你是猪么",android.R.drawable.sym_action_email));
        animals.add(new Animal("狗","你是狗么",android.R.drawable.sym_call_incoming));
        animals.add(new Animal("牛","你是牛么",android.R.drawable.sym_action_chat));
        animals.add(new Animal("猪","你是猪么",android.R.drawable.sym_action_email));
        animals.add(new Animal("狗","你是狗么",android.R.drawable.sym_call_incoming));
        animals.add(new Animal("牛","你是牛么",android.R.drawable.sym_action_chat));
        animals.add(new Animal("猪","你是猪么",android.R.drawable.sym_action_email));

//        animalAdapter = new AnimalAdapter(animals, this);
//         animalAdapter = new AnimalAdapterWithCommonViewHolder(animals, this);
         animalAdapter = new AnimalAdapterWithCommonAdapter(animals, this, R.layout.listview_item);
        lv.setAdapter(animalAdapter);

        btn_add = (Button) findViewById(R.id.btn_add);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_modify = (Button) findViewById(R.id.btn_modify);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("item selected = " + selected);
                if (-1 == selected){
                    System.out.println("item count = " + animalAdapter.getCount());
                    animalAdapter.add(new Animal("ADD",selected + "",android.R.drawable.sym_def_app_icon), animalAdapter.getCount());
                }else{
                    animalAdapter.add(new Animal("ADD",selected +"",android.R.drawable.sym_def_app_icon), selected);
                }
                selected = -1;
            }
        });
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("delete item");
                animalAdapter.delete(1);

            }
        });
        btn_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("item modify");
                animalAdapter.monify( new Animal("ADD",selected + "",android.R.drawable.sym_def_app_icon), 1);
            }
        });


    }
    public void testGridView(){
        gv = (GridView) findViewById(R.id.grid_view);
        icons = new ArrayList<>();
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        icons.add(new Icon(android.R.drawable.ic_delete, "name"));
        IconAdapter iconAdapter = new IconAdapter(icons, this, R.layout.gridview_item);
        gv.setAdapter(iconAdapter);
    }

    public void testSpinner(){
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        icons = new ArrayList<>();
        icons.add(new Icon(android.R.drawable.ic_delete,"迅捷斥候：提莫（Teemo）"));
        icons.add(new Icon(android.R.drawable.ic_delete,"诺克萨斯之手：德莱厄斯（Darius）"));
        icons.add(new Icon(android.R.drawable.ic_delete,"无极剑圣：易（Yi）"));
        icons.add(new Icon(android.R.drawable.ic_delete,"德莱厄斯：德莱文（Draven）"));
        icons.add(new Icon(android.R.drawable.ic_delete,"德邦总管：赵信（XinZhao）"));
        icons.add(new Icon(android.R.drawable.ic_delete,"狂战士：奥拉夫（Olaf）"));
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Snackbar.make(view, "你选择的排位分段是" + parent.getItemAtPosition(position).toString(), Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Snackbar.make(view, "你选择的英雄是" + parent.getItemAtPosition(position).toString(), Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        IconAdapter iconAdapter = new IconAdapter(icons, this, R.layout.spinner_item);
        spinner2.setAdapter(iconAdapter);
    }
}
