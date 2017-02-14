package whjin.example.com.materialdesign;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by whjin on 17-2-13.
 */
public class MainActivity extends AppCompatActivity{
    private static final String TAG = "MainActivity";

    private Fruit[] fruits = {
            new Fruit("Apple", R.drawable.apple_pic),
            new Fruit("Banana", R.drawable.banana_pic),
            new Fruit("Orange", R.drawable.orange_pic),
            new Fruit("Watermelon", R.drawable.watermelon_pic),
            new Fruit("Pear", R.drawable.pear_pic),
            new Fruit("Grape", R.drawable.grape_pic),
            new Fruit("Pineapple", R.drawable.pineapple_pic),
            new Fruit("Strawberry", R.drawable.strawberry_pic),
            new Fruit("Cherry", R.drawable.cherry_pic),
            new Fruit("Mango", R.drawable.mango_pic)};
    private ArrayList<Fruit> fruitList = new ArrayList<>();

    /*
    ** function for listview
    *
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        initFruits();
        ListView fruitListView = (ListView) findViewById(R.id.fruit_listview);
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        fruitListView.setAdapter(fruitAdapter);
        fruitListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FruitActivity.class);
                startActivity(intent);
            }
        });
    }
    */

    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (null != actionBar) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        initFruits();
        RecyclerView fruitRecyclerView = (RecyclerView) findViewById(R.id.fruit_recyclerview);
        FruitRecyclerAdapter fruitRecyclerAdapter = new FruitRecyclerAdapter(fruitList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        fruitRecyclerView.setLayoutManager(layoutManager);
        fruitRecyclerView.setAdapter(fruitRecyclerAdapter);
    }

    public void initFruits() {
        int count = fruits.length;
        for (int i = 0; i < count; i++) {
            fruitList.add(fruits[i]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.backup:
                Toast.makeText(MainActivity.this, "click backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(MainActivity.this, "click delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.setting:
                Toast.makeText(MainActivity.this, "click settings", Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Toast.makeText(MainActivity.this, "click home as up", Toast.LENGTH_SHORT).show();
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
