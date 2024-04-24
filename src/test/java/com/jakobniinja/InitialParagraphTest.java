package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import org.junit.jupiter.api.Test;

class InitialParagraphTest {

  @Test
  void testInit() {
    InitialParagraph p = new InitialParagraph("Elephant");
    assertEquals("Elephant", p.animal);
  }

  @Test
  void testGenerate(){
    InitialParagraph p = new InitialParagraph("Elephant");

    assertEquals(Collections.emptyList(), p.generateContent());
  }
}
