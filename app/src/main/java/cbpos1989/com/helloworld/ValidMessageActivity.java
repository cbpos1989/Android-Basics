package cbpos1989.com.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ValidMessageActivity extends AppCompatActivity {

    Button button;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valid_message);

        TextView tv = (TextView)findViewById(R.id.valid_message_text);
        Intent intent = getIntent();

        String name = intent.getStringExtra(HelloWorld.USER_NAME_KEY);

        tv.setText("Happy Birthday Mam");

        addListenerOnButton();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other, menu);
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

    private void addListenerOnButton(){
        image = (ImageView) findViewById(R.id.picture);

        button = (Button)findViewById(R.id.change_picture);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               image.setImageResource(R.drawable.birthday_cake_2);
            }
        });
    }
}
