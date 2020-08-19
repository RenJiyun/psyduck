package com.eggip.pikachu;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class WordCounter {

    private int counter;
    public boolean lastCharacter;

    public WordCounter(int counter, boolean lastCharacter) {
        this.counter = counter;
        this.lastCharacter = lastCharacter;
    }
    public WordCounter stringToCounter(Character c) {
            if (Character.isWhitespace(c)) {
                return lastCharacter ? this : new WordCounter(counter, true);
            } else {
                return lastCharacter ? new WordCounter(counter + 1, false) : this;
            }
    }

    public WordCounter combiner(WordCounter wordCounter){
        return new WordCounter(counter+wordCounter.counter,wordCounter.lastCharacter);
    }

    public int getCounter() {
        return counter;
    }

    public static void main(String[] args) {
        String a = "def def gtyh jyj";
        Stream<Character> characterStream= IntStream.range(0,a.length()).mapToObj(m->a.charAt(m));
        WordCounter wordCounter = new WordCounter(0, true);
        WordCounter wordCounter1 = characterStream.reduce(wordCounter, WordCounter::stringToCounter, WordCounter::combiner);
//        for(Character c:a.toCharArray()){
//            wordCounter=wordCounter.stringToCounter(c);
//        }
//        int counter = wordCounter.getCounter();
        System.out.println("字符串得字数是：" + wordCounter1.getCounter());


    }

}
