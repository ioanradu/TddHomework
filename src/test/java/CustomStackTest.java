import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomStackTest {

    private CustomStack data;

    @Before
    public void init() {

        data = new CustomStack();
    }

    @Test
    public void testWhenStackIsNotEmptyThenIsEmptyMethodReturnsFalse(){
        data.push(0);
        assertEquals(false, data.isEmpty());
    }

    @Test
    public void testReturnsObjectFromTheTopOfTheStackWithoutRemovingIt(){
        data.push(3);
        assertEquals(3, data.peek());
    }

    @Test
    public void testReturnsTheFirstObjectFromTheTopOfTheStackWithAnElementAndRemoveIt(){
        data.push(5);
        assertEquals(5, data.pop());

    }

    @Test
    public void testReturnsTheFirstObjectFromTheTopOfTheStackWithManyElementsAndRemoveIt(){
        data.push(8);
        data.push(9);
        assertEquals(9, data.pop());
    }

    @Test
    public void testReturnTheObjectWhenIsAddedToTheTopOfTheStack(){
        data.push(4);
        assertEquals(4, data.get(0));
    }

    @Test
    public void testIfTheObjectIsInTheStackThatHasAnObject(){
        data.push(1);
        assertEquals(0, data.searchObject(1));
    }

    @Test
    public void testIfAnObjectIsInTheStackThatHasManyObjects(){
        data.push(1);
        data.push(10);
        data.push(13);
        data.push(18);
        assertEquals(1, data.searchObject(10));
    }

    @Test
    public void testIfMinusOneIsReturnedIfTheObjectIsNotFoundInTheStack(){
        data.push(1);
        data.push(9);

       // System.out.println(foundElement);
        assertEquals(-1, data.searchObject(2));
    }

}
