package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class SongGeneratorTest {

  @Test
  void testIsEmpty() {
    SongGenerator generator = new SongGenerator(new ArrayList<>());
    assertTrue(generator.paragraphs.isEmpty());
  }

  @Test
  void testInit() {
    List<Paragraph> paragraphs = new ArrayList<>();
    paragraphs.add(Collections::emptyList);
    SongGenerator generator = new SongGenerator(paragraphs);
    assertEquals(1, paragraphs.size());
    assertEquals(1, generator.paragraphs.size());
  }

  @Test
  void testBuild() {
    SongGenerator generator = new SongGenerator(new ArrayList<>());
    List<Paragraph> build = generator.build("Snake", "Jaguar ", "Wolf", "Spider", "Lion", "Monkey", "Turtle");
    assertEquals(7, build.size());
  }
}
