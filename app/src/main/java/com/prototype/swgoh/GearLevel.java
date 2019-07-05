package com.prototype.swgoh;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class GearLevel extends RealmObject {

    @SerializedName("tier")
    private Integer tier;

    @SerializedName("gear")
    private RealmList<String> gear;

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    public RealmList<String> getGear() {
        return gear;
    }

    public void setGear(RealmList<String> gear) {
        this.gear = gear;
    }

}
