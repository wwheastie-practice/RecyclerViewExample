package com.prototype.swgoh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
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

}
