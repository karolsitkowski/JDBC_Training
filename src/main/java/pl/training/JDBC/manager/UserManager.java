package pl.training.JDBC.manager;

import pl.training.JDBC.database.UserDAO;
import pl.training.JDBC.model.User;

/**
 * Created by sit0 on 30.07.17.
 */
public class UserManager extends BaseManager<User,UserDAO> {

    public UserManager(){
        dao = new UserDAO();
    }
}
