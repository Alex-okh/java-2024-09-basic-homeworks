package ru.otus.java.basic.homeworks.homework22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.java.basic.homeworks.homework22.MainApp.checkOneAndTwoOnly;
import static ru.otus.java.basic.homeworks.homework22.MainApp.trimAfterOne;

public class MainAppTest {

    @Test
    public void testTrimAfterOne() {
        assertArrayEquals(new int[]{}, trimAfterOne(new int[]{2, 3, 1}));
        assertArrayEquals(new int[]{7, 8}, trimAfterOne(new int[]{5, 4, 1, 7, 8}));
        assertArrayEquals(new int[]{7, 8}, trimAfterOne(new int[]{1, 5, 4, 1, 7, 8}));
        assertArrayEquals(new int[]{5, 4, 7, 8}, trimAfterOne(new int[]{1, 5, 4, 7, 8}));

        assertThrows(RuntimeException.class, () -> trimAfterOne(new int[]{2, 3, 4}));
        assertThrows(RuntimeException.class, () -> trimAfterOne(new int[]{}));
        assertThrows(RuntimeException.class, () -> trimAfterOne(null));

    }

    @Test
    public void testCheckOneAndTwoOnly() {
        assertTrue(checkOneAndTwoOnly(new int[]{1, 2}));
        assertTrue(checkOneAndTwoOnly(new int[]{1, 2, 1, 2, 1, 2}));

        assertFalse(checkOneAndTwoOnly(new int[]{1}));
        assertFalse(checkOneAndTwoOnly(new int[]{2}));
        assertFalse(checkOneAndTwoOnly(new int[]{1, 3, 2}));
        assertFalse(checkOneAndTwoOnly(new int[]{}));
        assertFalse(checkOneAndTwoOnly(null));

    }


}


