package com.epam;

import com.epam.informationhandling.interpreter.Client;
import com.epam.informationhandling.interpreter.DecrementHandler;
import com.epam.informationhandling.interpreter.IncrementHandler;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class MathExpressionTest {

    @Test
    public void incrementTest1() {
        assertEquals(8, Integer.parseInt(IncrementHandler.increment("7++")));
    }

    @Test
    public void incrementTest2() {
        assertEquals(8, Integer.parseInt(IncrementHandler.increment("++7")));
    }

    @Test
    public void decrementTest1() {
        assertEquals(6, Integer.parseInt(DecrementHandler.decrement("7--")));
    }

    @Test
    public void decrementTest2() {
        assertEquals(6, Integer.parseInt(DecrementHandler.decrement("--7")));
    }

    @Test
    public void calculationTest() {
        Client interpreter = new Client("2+2*(2+2)");
        assertEquals(interpreter.calculate(), 10);
    }
    
}
