package cbpos1989.com.helloworld;

import android.app.ListActivity;
import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import cbpos1989.com.person.Person;
import cbpos1989.com.sqlitedatabase.DBHandler;

public class DatabaseActivity extends ListActivity {

    private DBHandler mDatabaseHandler;
    private List<Person> people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        mDatabaseHandler = new DBHandler(getApplicationContext());
        initListView();
    }

    private void initListView(){
        people = mDatabaseHandler.getAllPeople();
        ArrayAdapter<Person> arrayAdapter = new ArrayAdapter<>(getApplicationContext(),
                R.layout.list_text_view,
                people);
        setListAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_database, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onListItemClick(ListView listView,View view,int position, long id){
        super.onListItemClick(listView, view, position, id);

        Person person = people.get(position);
        Intent intent = new Intent(this, PersonActivity.class);
        intent.putExtra("PERSON_NAME", person.getName());
        intent.putExtra("PERSON_PHONE", person.getPhoneNumber());
        intent.putExtra("PERSON_EMAIL",person.getEmail());
        intent.putExtra("PERSON_ID",person.getId());
        startActivityForResult(intent,1);
    }

    public void onAddClicked(View view){
        Intent intent = new Intent(this,AddPersonActivity.class);
        startActivityForResult(intent,1);
    }

    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if (resultCode == 1) {
           initListView();
        }
    }
}
