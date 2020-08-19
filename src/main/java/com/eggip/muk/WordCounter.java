package com.eggip.muk;

import io.vavr.Tuple;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCounter {

    private static int countWords(Stream<Character> characterStream) {
        return characterStream.reduce(
                Tuple.of(0, true),
                (t, c) -> Character.isWhitespace(c) || !t._2 ? Tuple.of(t._1, Character.isWhitespace(c)) : Tuple.of(t._1 + 1, false),
                (t1, t2) -> Tuple.of(t1._1 + t2._1, false))._1;
    }

    public static int countWordsSeq(String s) {
        return countWords(IntStream.range(0, s.length()).mapToObj(s::charAt));
    }


    private static class CharSpliterator implements Spliterator<Character> {
        private String s;
        private int index;

        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            action.accept(s.charAt(index));
            index++;
            return index < s.length();
        }

        @Override
        public Spliterator<Character> trySplit() {
            return null;
        }

        @Override
        public long estimateSize() {
            return s.length();
        }

        @Override
        public int characteristics() {
            return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
        }
    }

    public static int countWordsPar(String s) {
        return countWords(StreamSupport.stream(new CharSpliterator(), true));
    }


    public static void main(String[] args) {
        System.out.println(countWordsPar("     abc  dev   fsgdf"));
    }

}
