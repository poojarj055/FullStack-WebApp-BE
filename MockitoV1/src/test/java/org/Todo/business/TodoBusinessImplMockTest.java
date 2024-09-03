package org.Todo.business;

import org.Todo.business.TodoBusinessImpl;
import org.Todo.data.api.TodoService;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TodoBusinessImplMockTest {
    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock() {
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        // Assert that the filtered list has exactly 2 items containing "Spring"
        assertEquals(2, filteredTodos.size());
    }
}
