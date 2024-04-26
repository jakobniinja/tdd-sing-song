package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class IntermediateParagraphTest {

  @Test
  void testInit() {
    assertNotNull(new IntermediateParagraph());
  }

  @Test
  void testContent() {
    IntermediateParagraph ip = new IntermediateParagraph();
    assertEquals(Collections.emptyList(), ip.generateContent());
  }

  @Test
  void testFrog() {
    IntermediateParagraph ip = new IntermediateParagraph();
    assertEquals(ip.animal, "Frog");
  }


  @Test
  void testInitVerse() {
    IntermediateParagraph ip = new IntermediateParagraph();
    assertEquals(ip.introVerse, "The green frog jumped over the ...");
  }

  @Test
  void testPrevious() {
    IntermediateParagraph ip = new IntermediateParagraph();
    assertEquals(ip.previousAnimal, "Tiger");
  }
}
