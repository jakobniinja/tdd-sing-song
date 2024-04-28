package com.jakobniinja;

import java.util.ArrayList;
import java.util.List;

public class IntermediateParagraph implements Paragraph {

  String animal;

  String introVerse;

  String[] previousAnimal;

  public IntermediateParagraph(String animal, String introVerse, String... previousAnimal) {
    this.animal = animal;
    this.introVerse = introVerse;
    this.previousAnimal = previousAnimal;
  }

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
