package ru.otus.java.basic.homeworks.homework22;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.java.basic.homeworks.homework22.MainApp.checkOneAndTwoOnly;
import static ru.otus.java.basic.homeworks.homework22.MainApp.trimAfterOne;

public class MainAppTest {

  public static Stream<Arguments> basicTrimData() {
    List<Arguments> data = new ArrayList<>();
    data.add(Arguments.arguments(new int[]{}, new int[]{2, 3, 1}));
    data.add(Arguments.arguments(new int[]{7, 8}, new int[]{5, 4, 1, 7, 8}));
    data.add(Arguments.arguments(new int[]{7, 8}, new int[]{1, 5, 4, 1, 7, 8}));
    data.add(Arguments.arguments(new int[]{5, 4, 7, 8}, new int[]{1, 5, 4, 7, 8}));
    return data.stream();
  }

  public static Stream<Arguments> exceptionsTrimData() {
    List<Arguments> data = new ArrayList<>();
    data.add(Arguments.arguments(new int[]{2, 3, 4}));
    data.add(Arguments.arguments(new int[]{}));
    data.add(Arguments.arguments((Object) null));
    return data.stream();
  }

  public static Stream<Arguments> oneAndTwoData() {
    List<Arguments> data = new ArrayList<>();
    data.add(Arguments.arguments(true, new int[]{1, 2}));
    data.add(Arguments.arguments(true, new int[]{1, 2, 1, 2, 1, 2}));
    data.add(Arguments.arguments(false, new int[]{1}));
    data.add(Arguments.arguments(false, new int[]{2}));
    data.add(Arguments.arguments(false, new int[]{1, 3, 2}));
    data.add(Arguments.arguments(false, new int[]{}));
    data.add(Arguments.arguments(false, null));
    return data.stream();
  }

  @ParameterizedTest
  @DisplayName("Parametrized Basic tests")
  @MethodSource("basicTrimData")
  void testTrimAfterOne(int[] expected, int[] input) {
    assertArrayEquals(expected, trimAfterOne(input));
  }

  @ParameterizedTest
  @DisplayName("Exception should be thrown")
  @MethodSource("exceptionsTrimData")
  void testExTrimAfterOne(int[] input) {
    assertThrows(RuntimeException.class, () -> trimAfterOne(input));
  }

  @ParameterizedTest
  @DisplayName("1 and 2 only - basic tests")
  @MethodSource("oneAndTwoData")
  void testOneAndTwo(boolean expected, int[] input) {
    assertEquals(expected, checkOneAndTwoOnly(input));
  }
}