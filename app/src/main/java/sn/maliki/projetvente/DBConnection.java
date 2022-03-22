package sn.maliki.projetvente;

import android.content.Context;
import androidx.room.Room;

public class DBConnection {

    private static final String BD_NAME = "GHR-EPT";
    public EleveDatabase db;
    private Context ctx;
//    private EleveDatabase db;
    private static DBConnection dbInstance;

    private DBConnection(Context ctx) {
        this.ctx = ctx;
        db = Room.databaseBuilder(ctx,
                DBConnection.class,
                BD_NAME).build();
    }

    public EleveDatabase getDb() {
        return db;
    }

    public static DBConnection getDbInstance(Context ctx) {
        if(dbInstance==null){
            dbInstance = new DBConnection(ctx);
        }

        return dbInstance;
    }
}
