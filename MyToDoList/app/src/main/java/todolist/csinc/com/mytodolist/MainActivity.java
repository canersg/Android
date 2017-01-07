package todolist.csinc.com.mytodolist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import sql.database.handler.DBHandler;
import todolist.csinc.business.TODO;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        ListView listView = (ListView) findViewById(R.id.main_listview_todoitems);
/*
        db.addTODOItem(new TODO(1,"Dockers", " 475 Brannan St #330, San Francisco, CA 94107, United States"));
        db.addTODOItem(new TODO(2,"Dunkin Donuts", "White Plains, NY 10601"));
        db.addTODOItem(new TODO(3,"Pizza Porlar", "North West Avenue, Boston , USA"));
        db.addTODOItem(new TODO(4,"Town Bakers", "Beverly Hills, CA 90210, USA"));
*/
// Reading all shops
        final List<TODO> todos = db.getAllTodos();
        String log;
        log = "";
        for (TODO todo : todos) {
             log.concat("Id: " + todo.getId() + " ,Name: " + todo.getName() + ",Address: " + todo.getChecked() + "\n");
// Writing shops to log
        }
        TodoList adapter = new TodoList(this,todos);
        listView.setAdapter(adapter);
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
        if (id == R.id.action_addTODO) {

            Intent inte = new Intent(this,AddTodoItem.class);
            inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(inte);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
