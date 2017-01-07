package todolist.csinc.com.mytodolist;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import todolist.csinc.business.TODO;

/**
 * Created by Caner on 25.12.2016.
 */
public class TodoList extends ArrayAdapter<TODO> {

    private final Activity context;
    private final List<TODO> todoList;
    public TodoList(Activity context,
                       List<TODO> todos) {
        super(context, R.layout.todo_listview, todos);
        this.context = context;
        this.todoList = todos;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.todo_listview, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.itemname);
        TextView txtkeyId = (TextView) rowView.findViewById(R.id.keyid);

        txtTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,EditItemActivity.class);
                intent.putExtra("EXTRA_TODO_NAME", (((TextView) v.findViewById(R.id.itemname)).getText().toString()));
                LinearLayout layout =(LinearLayout)v.getParent();
                TextView keyid =((TextView)layout.findViewById(R.id.keyid));
                intent.putExtra("EXTRA_TODO_KEY",keyid.getText());
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });
        CheckBox chkbox = (CheckBox) rowView.findViewById(R.id.check);
        txtTitle.setText(todoList.get(position).getName());
        txtkeyId.setText(Integer.toString((todoList.get(position).getId())));
        if(todoList.get(position).getChecked() == 0)
            chkbox.setChecked(false);
        else
            chkbox.setChecked(true);

        return rowView;
    }

}
