package com.eggip.pikachu;


import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * 为什么 WordCounterSpliterator《String》不行
 */
public class WordCounterSpliterator implements Spliterator<Character> {
    private int currentWordCounter;
    private final String word;

    public WordCounterSpliterator(String word) {
        this.word = word;
    }


    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        //吃掉得元素，下次循环还有吗，加入没有++
        action.accept(word.charAt(currentWordCounter++));
        return currentWordCounter > word.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        if (word.length() - currentWordCounter < 10) {
            return null;
        } else {
            int splitPos = (word.length() + currentWordCounter) / 2;
            for (int pos = splitPos; pos < word.length(); pos++) {
                if (Character.isWhitespace(word.charAt(pos))) {
                   Spliterator<Character> spliterator=new WordCounterSpliterator(word.substring(currentWordCounter,pos));
                    currentWordCounter = pos;
                    return spliterator;
                }
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return word.length() - currentWordCounter;
    }

    @Override
    public int characteristics() {
        return SIZED;
    }

    @Override
    public String toString() {
        return "WordCounterSpliterator{" +
                "currentWordCounter=" + currentWordCounter +
                ", word='" + word + '\'' +
                '}';
    }

    public static void main(String[] args){
        String word="adffgtggymim rj g g grisjaelo mjoeb jeon joeji jndeil jieng gj jo a l fmf hrg hod dms lep je o eo3m d p d dog";
        Stream<Character> characterStream= IntStream.range(0,word.length()).mapToObj(word::charAt);
        Spliterator<Character> wordCounterSpliterator=new WordCounterSpliterator(word);
       Stream<Character> stream= StreamSupport.stream(wordCounterSpliterator,true);
        LinkedList linkedList=new LinkedList();

    }
}
