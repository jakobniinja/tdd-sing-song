package com.jakobniinja;

import java.util.List;
import java.util.Objects;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Song song = (Song) o;
    return Objects.equals(verses, song.verses);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(verses);
  }
}
