package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class IntermediateParagraphTest {

  @Test
  void testInit() {
    assertNotNull(new IntermediateParagraph());
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

  @Test
  void testContainsFrog() {
    IntermediateParagraph ip = new IntermediateParagraph();
    assertTrue(ip.generateContent().contains("There was an old lady who swallowed a Frog"));
  }

  @Test
  void testContainsVerse() {
    IntermediateParagraph ip = new IntermediateParagraph();
    assertTrue(ip.generateContent().contains("The green frog jumped over the ..."));
  }
}
