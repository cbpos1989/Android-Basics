package cbpos1989.com.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorld extends AppCompatActivity {

    private String name;
    public static final String USER_NAME_KEY = "Username_Key";
    public static final String PASS_NAME = "Margaret";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_world);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hello_world, menu);
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

    public void onNewButtonClicked(View view) {

        EditText editText = (EditText) findViewById(R.id.enter_name_field);
        name = editText.getText().toString().trim();


        Toast.makeText(getApplicationContext(), "Welcome to the App " + name, Toast.LENGTH_LONG).show();

        if (name.equalsIgnoreCase(PASS_NAME)) {
            Intent it = new Intent(this, ValidMessageActivity.class);
            it.putExtra(HelloWorld.USER_NAME_KEY, name);
            startActivity(it);
        } else if (name.equalsIgnoreCase("Database")) {
            Intent it = new Intent(this,DatabaseActivity.class);
            startActivity(it);
        } else {
            Intent it = new Intent(this,InvalidMessage.class);
            it.putExtra(HelloWorld.USER_NAME_KEY,name);
            startActivity(it);
        }



    }

    public void changeText(View view){
        TextView newText = (TextView) findViewById(R.id.text);
        newText.setText("Welcome to the App " + name);
    }

}
