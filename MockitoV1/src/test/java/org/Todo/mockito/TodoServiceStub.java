package org.Todo.mockito;

import org.Todo.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
    }
}
