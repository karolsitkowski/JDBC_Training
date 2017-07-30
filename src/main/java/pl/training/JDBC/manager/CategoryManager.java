package pl.training.JDBC.manager;

import pl.training.JDBC.database.CategoryDAO;
import pl.training.JDBC.model.Category;

/**
 * Created by sit0 on 30.07.17.
 */
public class CategoryManager extends BaseManager<Category,CategoryDAO> {

    public CategoryManager(){
        dao = new CategoryDAO();
    }
}
