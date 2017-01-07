package todolist.csinc.com.mytodolist;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import sql.database.handler.DBHandler;
import todolist.csinc.business.TODO;


public class AddTodoItem extends ActionBarActivity {

    Button todoItemSaveBtn;
    EditText todoItemName;
    CheckBox todoItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo_item);
        todoItemSelected = (CheckBox)findViewById(R.id.todo_is_finished);
        todoItemName = (EditText)findViewById(R.id.add_todo_name);
        todoItemSaveBtn = (Button) findViewById(R.id.todo_item_save_btn);
        final Intent inte = new Intent(this,MainActivity.class);
        todoItemSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(todoItemName.getText().length()> 0)
                {
                    DBHandler db = new DBHandler(getApplicationContext());
                    int checked =0;
                    if(todoItemSelected.isChecked())
                        checked = 1;

                    db.addTODOItem(new TODO(1,todoItemName.getText().toString(),checked));
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                   startActivity(inte);

                }
           }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_todo_item, menu);
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
