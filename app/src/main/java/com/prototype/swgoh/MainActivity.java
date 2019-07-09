package com.prototype.swgoh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mImageUrl = new ArrayList<>();
    private ArrayList<String> mImageName = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //deleteDatabase();
        init();
        //Test
        initData();
        initRecyclerView();
    }

    private void init() {
        databaseSetup();
    }

    private void databaseSetup() {
        Realm.init(this);
        RealmDBSetup realmDBSetup = new RealmDBSetup();
        realmDBSetup.createDatabase();
    }

    private void deleteDatabase() {
        Realm.init(this);
        Realm.deleteRealm(Realm.getDefaultConfiguration());
    }

    private void initData() {
        RealmDBSetup realm = new RealmDBSetup();
        ArrayList<Character> characters = realm.getAllCharactersFromDB();

        for(Character character : characters) {
            mImageName.add(character.getName());
            mImageUrl.add("https://swgoh.gg" + character.getImage());
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mImageName, mImageUrl);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
