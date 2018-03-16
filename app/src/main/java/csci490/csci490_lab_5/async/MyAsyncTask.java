package csci490.csci490_lab_5.async;

import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;

import csci490.csci490_lab_5.data.LabDatabase;
import csci490.csci490_lab_5.entities.Person;

/**
 * Created by Sarah on 3/15/2018.
 */

public class MyAsyncTask extends AsyncTask<String, Void, Void>{
    LabDatabase database;

    public MyAsyncTask(LabDatabase database, Context applicationContext)
    {
        this.database = database;
    }

    @Override
    protected Void doInBackground(String... strings) {
        Person person = new Person();
        person.setName(strings[0]);
        database.personDao().insertPerson(person);
        return null;
    }
}
