package pl.training.JDBC.manager;

import pl.training.JDBC.database.BaseDAO;
import pl.training.JDBC.model.Address;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sit0 on 29.07.17.
 */
public abstract class BaseManager <T,D extends BaseDAO<T>> {

    protected D dao;

    public void manage(Scanner scanner){

        System.out.print("Select command <list,find>: ");
        String cmd = scanner.next();

        switch (cmd){
            case "list":{
                listAll();
                break;
            }
            case"find":{
                findById(scanner);
                break;
            }
        }
    }

    private void listAll(){
        List<T> values = dao.findAll();
        for (T value : values){
            System.out.println(value);
        }
    }

    private void findById(Scanner scanner){
        System.out.println("Input ID: ");
        int id = scanner.nextInt();
        T value = dao.findById(id);
        System.out.println(value);
    }
}
