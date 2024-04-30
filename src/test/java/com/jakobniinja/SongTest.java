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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class SongTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

  private final List<String> verse = new ArrayList<>();

  private Song song;

  @BeforeEach
  void setUp() {
    System.setOut(new PrintStream(outContent));
    verse.clear(); // Clear verse list before each test
    song = new Song(verse);
  }

  @Test
  void testSize2() {
    verse.add("Roses are red");
    verse.add("Violets are blue");
    assertEquals(2, verse.size());
  }

  @Test
  void testInitEmpty() {
    assertTrue(song.verses.isEmpty());
  }

  @Test
  void testToString() {
    verse.add("Roses are red");
    verse.add("Violets are blue");
    assertEquals("Song{verses=[Roses are red, Violets are blue]}", song.toString());
  }

  @Test
  void testHashCode() {
    verse.add("Roses are red");
    verse.add("Violets are blue");
    assertEquals(1701724394, song.hashCode());
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

  @ParameterizedTest
  @MethodSource("songProvider")
  void testEqualsInstance(Song otherSong) {
    assertFalse(song.equals(otherSong));
  }

  private static List<Song> songProvider() {
    List<Song> songs = new ArrayList<>();
    ArrayList<String> verses = new ArrayList<>();
    verses.add("Roses are red");
    verses.add("Violets are blue");
    songs.add(new Song(verses));
    songs.add(new Song(verses)); // Same verses but different instance
    return songs;
  }

  @Test
  void testPrint() {
    verse.add("Roses are red");
    verse.add("Violets are blue");
    song.printOn(new PrintStream(outContent));
    assertTrue(outContent.toString().contains("Roses are red"));
  }
}
