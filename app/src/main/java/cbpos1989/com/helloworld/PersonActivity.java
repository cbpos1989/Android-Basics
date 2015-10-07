package cbpos1989.com.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cbpos1989.com.person.Person;
import cbpos1989.com.sqlitedatabase.DBHandler;

public class PersonActivity extends AppCompatActivity {
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);

        Intent intent = getIntent();

        String name = intent.getStringExtra("PERSON_NAME");
        String phone = intent.getStringExtra("PERSON_PHONE");
        String email = intent.getStringExtra("PERSON_EMAIL");
        int id = intent.getIntExtra("PERSON_ID",0);

        TextView name_field = (TextView) findViewById(R.id.person_name_field);
        TextView phone_field = (TextView) findViewById(R.id.person_phone_field);
        TextView email_field = (TextView) findViewById(R.id.person_email_field);

        name_field.setText(name_field.getText().toString() + name);
        phone_field.setText(phone_field.getText().toString() + phone);
        email_field.setText(email_field.getText().toString() + email);

        person = new Person(id,name,phone,email);
    }

    public void onRemoveClicked(View view){
        DBHandler dbHandler = new DBHandler(getApplicationContext());
        dbHandler.removePerson(person.getId());
        setResult(1);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_person, menu);
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


}
