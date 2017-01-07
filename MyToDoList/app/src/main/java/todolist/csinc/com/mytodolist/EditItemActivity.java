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
import android.widget.Toast;

import sql.database.handler.DBHandler;
import todolist.csinc.business.TODO;


public class EditItemActivity extends ActionBarActivity {

    EditText editTxt;
    CheckBox chkIsChecked;
    Button btnSave;
    TODO WillUpdatedTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);

        chkIsChecked = (CheckBox)findViewById(R.id.edit_todo_is_finished);
        editTxt = (EditText)findViewById(R.id.edit_todo_name);


        String todoname = getIntent().getStringExtra("EXTRA_TODO_NAME");
        final String keyid = getIntent().getStringExtra("EXTRA_TODO_KEY");
        final Intent inte = new Intent(this,MainActivity.class);

       DBHandler db2 = new DBHandler(getApplicationContext());
        WillUpdatedTodo = db2.getShop(Integer.parseInt(keyid));

        editTxt.setText(WillUpdatedTodo.getName());
        chkIsChecked.setChecked(WillUpdatedTodo.getChecked() == 1 ? true : false);
        btnSave = (Button) findViewById(R.id.todo_item_save_btn);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(editTxt.getText().length() > 0)
                {
                    DBHandler db = new DBHandler(getApplicationContext());
                    int checked =0;
                    if(chkIsChecked.isChecked())
                        checked = 1;
                    Toast.makeText(getApplicationContext(),  "Update Yapılıyor",
                            Toast.LENGTH_LONG).show();
                    db.updateTodo(new TODO(WillUpdatedTodo.getId(), editTxt.getText().toString(), checked));
                    inte.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(inte);
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_edit_item, menu);
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
