package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MainTest {

  ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outputStream));
  }

  @Test
  void testInit() {
    assertNotNull(new Main());
  }

  @Test
  void testMain() {
    Main.main(new String[]{"Hi"});
    assertEquals("Hello world!", outputStream.toString());
  }
}