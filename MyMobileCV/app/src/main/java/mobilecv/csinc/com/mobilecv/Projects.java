package mobilecv.csinc.com.mobilecv;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class Projects extends ActionBarActivity {

    String[] mobileArray = {"Tablet Dekor","Alfemo Design","Bross Home","New Joy",
            "Kids& Teens","AR Mod Tasarım","Mod 360","N Plus", "Heads Or Tails", " The Complete TOEFL iBT mobile application"};
    Integer[] ImageIDs = {
            R.drawable.tabletdekor_icon,
            R.drawable.alfemo_icon,
            R.drawable.bros_icon,
            R.drawable.newjoy_icon,
            R.drawable.teens_icon,
            R.drawable.armode_icon,
            R.drawable.mod_ucyuzaltmis_icon,
            R.drawable.nplus_icon,
            R.drawable.yazi_tura_icon,
            R.drawable.complete_toefl_icon};
    String[] mobileStore = {
            "com.kryteknik.tabletdekor",
            "com.Kryteknik.Alfemodesigner",
            "com.kryteknik.brosskumas",
            "com.Kryteknik.newjoysmartdesigner",
            "com.Kryteknik.kidsandTeen",
            "com.kryteknik.ModTasarimAR",
            "com.kryteknik.ModTasarim360",
            "com.kryteknik.nplusbanyo",
            "com.CSinc.yazitura",
            "com.tippsonline.completetoeflibt"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        ProjectList adapter = new ProjectList(this,mobileArray,ImageIDs);
        ListView listView = (ListView) findViewById(R.id.projects_listview);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + mobileStore[position])));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + mobileStore[position])));
                }
            }
        }
        );

        listView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_projects, menu);
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
