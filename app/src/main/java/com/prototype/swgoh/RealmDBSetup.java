package com.prototype.swgoh;

import java.io.File;

import io.realm.Realm;
import io.realm.RealmList;

public class RealmDBSetup {

    Realm mRealm;
    RealmList<Character> mCharacters = new RealmList<>();

    public RealmDBSetup() {
        mRealm = Realm.getDefaultInstance();
    }

    public void createDatabase() {
        if(new File(mRealm.getConfiguration().getPath()).exists() && mRealm.isEmpty()) {
            retrieveAllCharactersFromAPI();
            writeToDatabase();
        }
    }

    private void writeToDatabase() {
        if(mCharacters != null) {
            mRealm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {
                    realm.insert(mCharacters);
                }
            });
        }
    }

    private void retrieveAllCharactersFromAPI() {
        AppRetrofitService service = new AppRetrofitService();

        try {
            mCharacters.addAll(service.execute().get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
