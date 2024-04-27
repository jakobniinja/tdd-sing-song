package com.jakobniinja;

import java.util.ArrayList;
import java.util.List;

public class IntermediateParagraph implements Paragraph {

  final String animal = "Frog";

  final String introVerse = "The green frog jumped over the ...";

  final String[] previousAnimal = new String[]{"Tiger", "Dragon"};

  @Override
  public List<String> generateContent() {
    List<String> result = new ArrayList<>();

    result.add(introVerse);
    result.add("There was an old lady who swallowed a " + animal);

    for (int i = previousAnimal.length - 1; i >= 1; i--) {
      result.add("I don't know why she swallowed a " + previousAnimal[i] + " - perhaps she'll die!");
    }
    return result;
  }
}
