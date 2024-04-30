package com.jakobniinja;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class SongTest {

  private final List<String> verse = new ArrayList<>();

  private Song song = new Song(verse);

  @Test
  void testInit() {
    verse.add("Roses are red");
    verse.add("Violets are blue");
    assertEquals(2, verse.size());
  }

  @Test
  void testVerseEmpty() {
    assertTrue(song.verses.isEmpty());
  }

  @Test
  void testToString() {
    verse.add("Roses are red");
    verse.add("Violets are blue");

    assertTrue("Song{verses=[Roses are red, Violets are blue]}".equalsIgnoreCase(song.toString()));
  }

  @Test
  void testHash() {
    verse.add("Roses are red");
    verse.add("Violets are blue");
    assertEquals(1701724394, song.hashCode());
  }

  @Test
  void testEqualsSelf() {
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
  void testEqualsNewSong() {
    ArrayList<String> verses = new ArrayList<>();
    verse.add("Roses are red");

    Song song1 = new Song(verses);
    song = new Song(verses);
    assertTrue(song.equals(song1));
  }
}
