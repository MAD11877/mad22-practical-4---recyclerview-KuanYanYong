package sg.edu.np.mad.MADPractical;

import java.util.ArrayList;

public class User {
    String Name;
    String Description;
    int Id;
    boolean Followed;
    ArrayList<User> userList;

    public ArrayList<User> getUserList(){return userList;}

    public User(){

    }

    public User(String n, String des, int ID, boolean f){
        Name = n;
        Description = des;
        Id = ID;
        Followed = f;
    }
}
