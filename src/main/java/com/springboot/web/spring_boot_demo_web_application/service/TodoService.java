package com.springboot.web.spring_boot_demo_web_application.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.web.spring_boot_demo_web_application.model.Todo;


@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 3;
    /*private static final String name="in28Minutes";*/

    static {
        todos.add(new Todo(1, "in28Minutes", "Learn Spring MVC", new Date(),
                false));
        todos.add(new Todo(2,"in28Minutes", "Learn Struts", new Date(), false));
        todos.add(new Todo(3, "in28Minutes", "Learn Hibernate", new Date(),
                false));
        
       /* todos.add(new Todo(1,name , "Learn Spring MVC", new Date(),false));
        todos.add(new Todo(2,name, "Learn Struts", new Date(), false));
        todos.add(new Todo(3, name, "Learn Hibernate", new Date(),false));*/
    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }
    
    public Todo retrieveTodos(int id) {
       // List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todos) {
            if (todo.getId()==id) {
               return todo;
            }
        }
        return null;
    }

    public void addTodo(String name, String desc, Date targetDate,
            boolean isDone) {
        todos.add(new Todo(++todoCount, name, desc, targetDate, isDone));
    }

    public void deleteTodo(int id) {
        Iterator<Todo> iterator = todos.iterator();
        while (iterator.hasNext()) {
            Todo todo = iterator.next();
            if (todo.getId() == id) {
                iterator.remove();
            }
        }
    }
    
    public void updateToDo(Todo todo) {
    	todos.remove(todo);
    	todos.add(todo);
    }
}