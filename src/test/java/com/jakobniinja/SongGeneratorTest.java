package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongGeneratorTest {

  private static final String[] ANIMALS = {"Snake", "Jaguar", "Wolf", "Spider", "Lion", "Monkey", "Turtle"};

  private SongGenerator generator;

  @BeforeEach
  void setUp() {
    generator = new SongGenerator(new ArrayList<>());
  }

  @Test
  void testIsEmpty() {
    assertTrue(generator.paragraphs.isEmpty());
  }

  @Test
  void testInit() {
    List<Paragraph> paragraphs = new ArrayList<>();
    paragraphs.add(Collections::emptyList);
    SongGenerator generator = new SongGenerator(paragraphs);
    assertEquals(1, generator.paragraphs.size());
  }

  @Test
  void testBuild() {
    List<Paragraph> build = generator.build(ANIMALS);
    assertEquals(7, build.size());
  }

  @Test
  void testBuildWithSelect() {
    List<Paragraph> build = generator.build(ANIMALS);

    List<String> previous = build.stream()
        .filter(IntermediateParagraph.class::isInstance)
        .map(IntermediateParagraph.class::cast)
        .map(p -> Arrays.toString(p.previousAnimal))
        .toList();

    String[] expectedIntermediate = {"Snake", "Jaguar"};
    assertEquals(Arrays.toString(expectedIntermediate), previous.get(0));
  }

  @Test
  void testSelection() {
    String[] selected = SongGenerator.select(ANIMALS, 3);
    assertEquals(4, selected.length);
  }

  @Test
  void testExecute() {
    List<Paragraph> paragraphs = new ArrayList<>();
    String introVerse = "Hi from Jaguar";

    paragraphs.add(new IntermediateParagraph(ANIMALS[1], introVerse, ANIMALS[0]));
    SongGenerator generator = new SongGenerator(paragraphs);
    Song song = generator.execute();

    assertTrue(song.verses.contains(introVerse));
  }
}
