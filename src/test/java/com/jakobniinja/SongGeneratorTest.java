package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
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
    List<Paragraph> build = generator.build("Snake", "Jaguar", "Wolf", "Spider", "Lion", "Monkey", "Turtle");
    assertEquals(7, build.size());
  }

  @Test
  void testBuildWithSelect() {
    SongGenerator generator = new SongGenerator(new ArrayList<>());
    String[] animals = {"Snake", "Jaguar", "Wolf", "Spider", "Lion", "Monkey", "Turtle"};

    List<Paragraph> build = generator.build(animals);

    List<String> previous = build.stream()
        .filter(IntermediateParagraph.class::isInstance)
        .map(IntermediateParagraph.class::cast)
        .map(p -> Arrays.toString(p.previousAnimal))
        .toList();

    String[] expectedIntermediate = {"Snake", "Jaguar"};
    assertEquals(Arrays.toString(expectedIntermediate), previous.get(0));
  }

  @Test
  void testBuildWithSelect2() {
    SongGenerator generator = new SongGenerator(new ArrayList<>());
    String[] animals = {"Snake", "Jaguar", "Wolf", "Spider", "Lion", "Monkey", "Turtle"};

    List<Paragraph> build = generator.build(animals);

    List<String> previous = build.stream()
        .filter(IntermediateParagraph.class::isInstance)
        .map(IntermediateParagraph.class::cast)
        .map(p -> Arrays.toString(p.previousAnimal))
        .toList();

    String[] expectedIntermediate = {"Snake", "Jaguar", "Wolf"};
    assertEquals(Arrays.toString(expectedIntermediate), previous.get(1));
  }

  @Test
  void testSelection() {
    String[] selected = SongGenerator.select(new String[]{"Snake", "Jaguar", "Spider"}, 3);
    assertEquals(4, selected.length);
  }
}
