package sn.maliki.projetvente;

import androidx.room.RoomDatabase;
import androidx.room.Database;

@Database(entities = {Eleve.class}, version = 1)
public abstract class EleveDatabase extends RoomDatabase{

    abstract public EleveDao getEleveDao();
}
