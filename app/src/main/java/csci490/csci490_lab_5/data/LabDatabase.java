package csci490.csci490_lab_5.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import csci490.csci490_lab_5.entities.Person;

/**
 * Created by Sarah on 3/15/2018.
 */
    @Database(entities = {Person.class}, version = 1)
    public abstract class LabDatabase extends RoomDatabase {

        public abstract PersonDao personDao();
    }
