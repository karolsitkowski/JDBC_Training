package pl.training.JDBC.database;

import pl.training.JDBC.model.Category;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by sit0 on 30.07.17.
 */
public class CategoryDAO extends BaseDAO<Category> {

    @Override
    public String getTableName() {
        return "categories";
    }

    @Override
    public Category createObject(ResultSet result) throws SQLException {

        Category category = new Category();
        category.setId(result.getInt(1));
        category.setName(result.getString(2));
        return category;
    }
}
