package ru.otus.java.basic.homeworks.homework22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.java.basic.homeworks.homework22.MainApp.checkOneAndTwoOnly;
import static ru.otus.java.basic.homeworks.homework22.MainApp.trimAfterOne;

public class MainAppTest {

  public static Stream<Arguments> goodarraysData() {
    List<Arguments> data = new ArrayList<>();
    for (int i = 3; i < 20; i++) {
      int[] newArray = new int[i];
      Arrays.fill(newArray, 1);
      Arrays.fill(newArray, 0, newArray.length / 2, 2);
      data.add(Arguments.arguments(newArray));
    }
    return data.stream();
  }

  public static Stream<Arguments> badarraysData() {
    List<Arguments> data = new ArrayList<>();
    for (int i = 3; i < 20; i++) {
      int[] newArray = new int[i];
      Arrays.fill(newArray, 1);
      Arrays.fill(newArray, 0, newArray.length / 2, 2);
      newArray[i - 2] = 4;
      data.add(Arguments.arguments(newArray));
    }
    return data.stream();
  }

  public static Stream<Arguments> trimData() {
    List<Arguments> data = new ArrayList<>();
    Random rand = new Random();
    for (int i = 5; i < 20; i++) {
      int[] newArray = new int[i];
      for (int j = 0; j <newArray.length; j++) {
        newArray[j] = rand.nextInt(2,10);
      }
      int onePosition = rand.nextInt(newArray.length-1);
      newArray[onePosition] = 1;
      int[] expected = Arrays.copyOfRange(newArray,onePosition+1, newArray.length);
      data.add(Arguments.arguments(newArray,expected));
    }
    return data.stream();
  }

  @Test
  @DisplayName ("Array trim after 1 - Basic tests")
  public void testTrimAfterOne() {
    assertArrayEquals(new int[]{}, trimAfterOne(new int[]{2, 3, 1}));
    assertArrayEquals(new int[]{7, 8}, trimAfterOne(new int[]{5, 4, 1, 7, 8}));
    assertArrayEquals(new int[]{7, 8}, trimAfterOne(new int[]{1, 5, 4, 1, 7, 8}));
    assertArrayEquals(new int[]{5, 4, 7, 8}, trimAfterOne(new int[]{1, 5, 4, 7, 8}));

    assertThrows(RuntimeException.class, () -> trimAfterOne(new int[]{2, 3, 4}));
    assertThrows(RuntimeException.class, () -> trimAfterOne(new int[]{}));
    assertThrows(RuntimeException.class, () -> trimAfterOne(null));

  }

  @ParameterizedTest
  @MethodSource ("trimData")
  @DisplayName ("Array trim after 1 - Random array tests")
  public void testTrim(int[] input, int[] expected) {
    assertArrayEquals(expected, trimAfterOne(input));
  }

  @Test
  @DisplayName ("1 or 2 only - Basic tests")
  public void testCheckOneAndTwoOnly() {
    assertTrue(checkOneAndTwoOnly(new int[]{1, 2}));
    assertTrue(checkOneAndTwoOnly(new int[]{1, 2, 1, 2, 1, 2}));

    assertFalse(checkOneAndTwoOnly(new int[]{1}));
    assertFalse(checkOneAndTwoOnly(new int[]{2}));
    assertFalse(checkOneAndTwoOnly(new int[]{1, 3, 2}));
    assertFalse(checkOneAndTwoOnly(new int[]{}));
    assertFalse(checkOneAndTwoOnly(null));

  }

  @ParameterizedTest
  @MethodSource("goodarraysData")
  @DisplayName ("1 or 2 only - Random valid arrays")
  public void testCheckOneAndTwoTrue(int[] input) {
    assertTrue(checkOneAndTwoOnly(input));
  }

  @ParameterizedTest
  @MethodSource("badarraysData")
  @DisplayName ("1 or 2 only - Random invalid arrays")
  public void testCheckOneAndTwoFalse(int[] input) {
    assertFalse(checkOneAndTwoOnly(input));
  }
}