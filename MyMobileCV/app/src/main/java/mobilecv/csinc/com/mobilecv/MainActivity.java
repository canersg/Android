package mobilecv.csinc.com.mobilecv;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    Button AboutMeBtn;
    Button ContactBtn;
    Button OnlineCVBtn;
    Button ProjectsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AboutMeBtn = (Button) findViewById(R.id.aboutme);
        AboutMeBtn.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    AboutMeBtn.setBackgroundResource(R.drawable.blue_button);

                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    AboutMeBtn.setBackgroundColor(Color.parseColor("#487596"));
                }
                return false;
            }

        });
        AboutMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              Intent intent =  new Intent(getBaseContext(), AboutMe.class);
               startActivity(intent);
            }
        });

        ContactBtn = (Button) findViewById(R.id.contact);
        ContactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getBaseContext(), Contact.class);
                startActivity(intent);
            }
        });
        ContactBtn.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    ContactBtn.setBackgroundResource(R.drawable.blue_button);

                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ContactBtn.setBackgroundColor(Color.parseColor("#487596"));
                }
                return false;
            }

        });
        OnlineCVBtn = (Button) findViewById(R.id.online);
        OnlineCVBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getBaseContext(), OnlineCV.class);
                startActivity(intent);
            }
        });
        OnlineCVBtn.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    OnlineCVBtn.setBackgroundResource(R.drawable.blue_button);

                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    OnlineCVBtn.setBackgroundColor(Color.parseColor("#487596"));
                }
                return false;
            }

        });
        ProjectsBtn = (Button) findViewById(R.id.projects);
        ProjectsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(getBaseContext(), Projects.class);
                startActivity(intent);
            }
        });
        ProjectsBtn.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP) {
                    ProjectsBtn.setBackgroundResource(R.drawable.blue_button);

                } else if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    ProjectsBtn.setBackgroundColor(Color.parseColor("#487596"));
                }
                return false;
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
