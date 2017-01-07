package mobilecv.csinc.com.mobilecv;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Caner on 18.12.2016.
 */
public class ProjectList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public ProjectList(Activity context,
                       String[] web, Integer[] imageId) {
        super(context, R.layout.activity_listview, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.activity_listview, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.itemname);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        txtTitle.setText(web[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }

}
