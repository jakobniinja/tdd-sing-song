package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntermediateParagraphTest {

  private IntermediateParagraph ip;

  @BeforeEach
  void setUp() {
    ip = new IntermediateParagraph();
  }

  @Test
  void testInit() {
    assertNotNull(ip);
  }

  @Test
  void testTiger() {
    assertTrue(Arrays.asList(ip.previousAnimal).contains("Tiger"));
  }

  @Test
  void testDragon() {
    assertTrue(ip.generateContent().toString().contains("swallowed a Dragon"));
  }
}
