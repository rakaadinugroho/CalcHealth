package com.rakaadinugroho.kalkulatorkesehatan;

import android.app.Application;

import com.rakaadinugroho.kalkulatorkesehatan.database.MasterDB;

import io.realm.DynamicRealm;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

/**
 * Created by Raka Adi Nugroho on 12/16/16.
 *
 * @Github github.com/rakaadinugroho
 * @Contact nugrohoraka@gmail.com
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MasterDB masterDB   = new MasterDB(this);
        masterDB.setMigration(new DataMigration());
    }

    private class DataMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
            RealmSchema schema  = realm.getSchema();
            if (oldVersion == 0){
                schema.create("histories")
                        .addField("id", int.class)
                        .addField("content", String.class)
                        .addField("suggestion", String.class);
                oldVersion++;
            }
        }
    }
}
