package com.jakobniinja;

import java.util.List;

public class Song {

  List<String> verses;

  public Song(List<String> verses) {
    this.verses = verses;
  }

  @Override
  public String toString() {
    return "Song{" +
        "verses=" + verses +
        '}';
  }
}
