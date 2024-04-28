package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FinalParagraphTest {

  private FinalParagraph fp;

  @BeforeEach
  void setUp() {
    fp = new FinalParagraph("Monkey");
  }

  @Test
  void testInit() {
    assertEquals("Monkey", fp.animal);
  }

  @Test
  void testContent() {
    assertTrue(fp.generateContent().toString().contains("There was an old lady who swallowed a " + fp.animal));
    assertTrue(fp.generateContent().toString().contains("...She's dead, of course!"));
  }
}
