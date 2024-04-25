package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InitialParagraphTest {

  private InitialParagraph p;

  @BeforeEach
  void setUp() {
    p = new InitialParagraph("Elephant");
  }

  @Test
  void testInit() {
    assertEquals("Elephant", p.animal);
  }

  @Test
  void testGenerate() {
    assertNotEquals(Collections.emptyList(), p.generateContent());
  }

  @Test
  void testOldLadyEatAnimal() {
    assertTrue(p.generateContent().contains("There was an old lady who swallowed a Elephant."));
  }

  @Test
  void testWillSheDie() {
    assertTrue(p.generateContent().contains("I don't know why she swallowed a Elephant - perhaps she'll die!"));
  }

  @Test
  void testOldLadyEatNull() {
    p = new InitialParagraph(null);
    assertTrue(p.generateContent().contains("There was an old lady who swallowed a null."));
  }
}
