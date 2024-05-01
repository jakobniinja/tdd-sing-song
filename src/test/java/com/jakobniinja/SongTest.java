package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SongTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  private final List<String> verse = new ArrayList<>();

  private Song song;


  private static final String RED_ROSE = "Roses are red";

  private static final String BLUE_VIOLET = "Violets are blue";

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
    song = new Song(verse);
  }

  @Test
  void testToString() {
    addRoses();
    assertEquals("Song{verses=[" + RED_ROSE + ", " + BLUE_VIOLET + "]}", song.toString());
  }

  @Test
  void testHashCode() {
    assertEquals(1, song.hashCode());
  }

  @Test
  void testEquals() {
    assertTrue(song.equals(song));
  }

  @Test
  void testEqualsNull() {
    assertFalse(song.equals(null));
  }

  @Test
  void testEqualsOther() {
    assertFalse(song.equals(new InitialParagraphTest()));
  }

  @Test
  void testEqualInstance() {
    addRoses();
    Song song1 = new Song(verse);
    Song song2 = new Song(verse); // Same verses but different instance
    assertTrue(song1.equals(song2));
  }

  @Test
  void testPrint() {
    addRoses();
    song.printOn(new PrintStream(outContent));
    assertTrue(outContent.toString().contains(RED_ROSE));
  }

  private void addRoses() {
    verse.add(RED_ROSE);
    verse.add(BLUE_VIOLET);
  }
}
