package com.rakaadinugroho.kalkulatorkesehatan.database;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Raka Adi Nugroho on 12/16/16.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class MasterDB {
    private Realm realm;
    private Context context;

    public MasterDB(Context context){
        this.context    = context;
        realm.init(this.context);
        this.realm  = Realm.getDefaultInstance();
    }
    public Realm getRealm(){
        return this.realm;
    }
    public void setMigration(RealmMigration migration){
        RealmConfiguration configuration    = new RealmConfiguration.Builder()
                .schemaVersion(0)
                .name("kalkulator.realm")
                .migration(migration)
                .build();
        realm   = Realm.getInstance(configuration);
    }
    public RealmResults<? extends RealmObject> getAllData(Class<? extends RealmObject> cls){
        return this.getRealm().where(cls.asSubclass(RealmObject.class)).findAll();
    }
    public void add(RealmObject object){
        getRealm().beginTransaction();
        getRealm().copyToRealm(object);
        getRealm().commitTransaction();
    }
}
