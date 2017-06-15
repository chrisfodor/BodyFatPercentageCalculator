package chrisfodor.com.bodyfatpercentagecalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ageEditText;
    EditText weightEditText;
    TextView bfpTextView;
    EditText heightEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ageEditText = (EditText) findViewById(R.id.ageEditText);
        weightEditText = (EditText) findViewById(R.id.weightEditText);
        bfpTextView = (TextView) findViewById(R.id.bfpTextView);
        heightEditText = (EditText) findViewById(R.id.heightEditText);

        final float weight  = Float.parseFloat(weightEditText.getText().toString());
        final float height = Integer.parseInt(heightEditText.getText().toString());
        final int age = Integer.parseInt(ageEditText.getText().toString());

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double bmi = (weight / Math.pow(height, 2)) * 703;
                double bodyFatPercentage = (1.20 * bmi) + (0.23 * age) - 16.2;
                bfpTextView.setText(Double.toString(bodyFatPercentage));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
