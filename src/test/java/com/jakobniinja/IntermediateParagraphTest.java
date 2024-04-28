package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntermediateParagraphTest {

  private IntermediateParagraph ip;

  @BeforeEach
  void setUp() {
    ip = new IntermediateParagraph("Butterfly", "The green frog jumped over the ...", "Frog", "Tiger");
  }

  @Test
  void testInit() {
    assertNotNull(ip);
  }

  @Test
  void testPrevious() {
    assertEquals(ip.previousAnimal[0], "Frog");
  }

  @Test
  void testTiger() {
    assertTrue(Arrays.asList(ip.previousAnimal).contains("Tiger"));
  }

  @Test
  void testContent() {
    assertTrue(ip.generateContent().toString().contains("swallowed a Butterfly"));
  }
}
