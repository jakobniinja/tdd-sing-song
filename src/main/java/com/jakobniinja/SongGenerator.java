package com.jakobniinja;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SongGenerator {

  List<Paragraph> paragraphs;

  public SongGenerator(List<Paragraph> paragraphs) {
    this.paragraphs = paragraphs;
  }

  public List<Paragraph> build(String... args) {
    List<Paragraph> p = new ArrayList<>();
    p.add(new InitialParagraph(args[0]));
    p.add(new IntermediateParagraph(args[1], "That tickled inside of her.", select(args, 1)));
    p.add(new IntermediateParagraph(args[2], "Absurd to swallow a " + args[2] + ".", select(args, 2)));
    p.add(new IntermediateParagraph(args[3], "He swallow a " + args[3] + " with fashion.", select(args, 3)));
    p.add(new IntermediateParagraph(args[4], "What a hog, to swallow a " + args[4] + " .", select(args, 4)));
    p.add(new IntermediateParagraph(args[5], "He's brother accidentally eat a " + args[5] + ", poor guy.", select(args, 5)));
    p.add(new FinalParagraph(args[args.length - 1]));
    return p;
  }

  static String[] select(String[] args, int i) {
    return Arrays.copyOfRange(args, 0, i + 1);
  }

  Song execute() {
    List<String> verse = new ArrayList<>();
    for (Paragraph paragraph : paragraphs) {
      verse.addAll(paragraph.generateContent());
    }
    return new Song(verse);
  }
}
