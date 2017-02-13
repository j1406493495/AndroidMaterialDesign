package whjin.example.com.materialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by whjin on 17-2-13.
 */
public class MainActivity extends Activity{
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

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
    protected void onDestroy() {
        super.onDestroy();
    }
}
