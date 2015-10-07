package cbpos1989.com.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cbpos1989.com.person.Person;
import cbpos1989.com.sqlitedatabase.DBHandler;

public class AddPersonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_person, menu);
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

    public void onSubmitClicked(View view){
        EditText nameField = (EditText) findViewById(R.id.enter_name);
        EditText phoneField = (EditText) findViewById(R.id.enter_phone);
        EditText emailField = (EditText) findViewById(R.id.enter_email);

        final Person person = new Person(nameField.getText().toString(),phoneField.getText().toString(),emailField.getText().toString());

        new Thread(new Runnable() {
            @Override
            public void run() {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                dbHandler.addPerson(person);
            }
        }).start();



        setResult(1);
        finish();
    }
}
