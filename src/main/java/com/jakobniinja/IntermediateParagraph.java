package com.jakobniinja;

import java.util.List;

public class IntermediateParagraph implements Paragraph {

  final String animal = "Frog";

  final String introVerse = "The green frog jumped over the ...";

  final String previousAnimal = "Tiger";

  @Override
  public List<String> generateContent() {
    return List.of();
  }
}
