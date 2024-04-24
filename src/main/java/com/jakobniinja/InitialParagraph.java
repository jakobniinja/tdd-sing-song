package com.jakobniinja;

import java.util.List;

public class InitialParagraph implements Paragraph {

  protected String animal;

  public InitialParagraph(String animal) {
    this.animal = animal;
  }

  @Override
  public List<String> generateContent() {
    return List.of();
  }
}
