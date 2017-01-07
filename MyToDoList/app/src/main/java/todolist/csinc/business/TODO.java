package todolist.csinc.business;

/**
 * Created by Caner on 25.12.2016.
 */
public class TODO {
    private int id;
    private int checked;
    private String name;

    public  TODO()
    {

    }
    public TODO(int id, String nm, int checked)
    {
        this.id= id;
       this.checked = checked;
        this.name = nm;
    }
    public String getName() {
        return name;
    }

    public int getChecked() {
        return  checked;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setChecked(int checked) {
      this.checked = checked;
    }
    public int getId() {
        return id;
    }

}
