//package com.eggip.puzzle;
//
//import io.vavr.Tuple;
//import io.vavr.Tuple2;
//import io.vavr.Tuple3;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class NumberPuzzle implements Puzzle {
//    @Override
//    public Position start() {
//        return new Position();
//    }
//
//    @Override
//    public List<Position> moveList(Position currentPosition) {
//        List<Integer> numbers = getRemainIntegers();
//        Tuple3<Integer, Integer, Integer> t3 = findEarlyBlank(currentPosition);
//        removeXSampleNumber(currentPosition, t3._1, numbers);
//        removeYSampleNumber(currentPosition, t3._2, numbers);
//        removeNineCellSampleNumber(currentPosition, t3._1, t3._2, numbers);
//        return asMoveList(currentPosition, t3, numbers);
//    }
//
//    private Tuple3<Integer, Integer, Integer> findEarlyBlank(Position currentPosition) {
//        int index = 0;
//        for (Tuple3<Integer, Integer, Integer> t : currentPosition.getNumberPosition()) {
//            index++;
//            if (t._3 == null) {
//                return Tuple.of(t._1, t._2, index);
//            }
//        }
//        return null;
//    }
//
//    private void removeYSampleNumber(Position currentPosition, Integer y, List<Integer> numbers) {
//        for (Tuple3<Integer, Integer, Integer> t : currentPosition.getNumberPosition()) {
//            if (t._2 == y) {
//                numbers.remove(t._3);
//            }
//        }
//    }
//
//    private void removeXSampleNumber(Position currentPosition, Integer x, List<Integer> numbers) {
//        for (Tuple3<Integer, Integer, Integer> t : currentPosition.getNumberPosition()) {
//            if (t._1 == x) {
//                numbers.remove(t._3);
//            }
//        }
//    }
//
//    private void removeNineCellSampleNumber(Position currentPosition, Integer x, Integer y, List<Integer> numbers) {
//
//    }
//
//    private List<Position> asMoveList(Position currentPosition, Tuple3<Integer, Integer, Integer> t, List<Integer> numbers) {
//        List<Position> positions = new ArrayList<>();
//        List<Tuple3<Integer, Integer, Integer>> list = new ArrayList<>();
//        list.addAll(currentPosition.getNumberPosition());
//        for (Integer number : numbers) {
//            list.set(t._3, new Tuple3<>(t._1, t._2, number));
//            positions.add(new Position(list));
//        }
//        return positions;
//    }
//
//
//    private List<Integer> getRemainIntegers() {
//        List<Integer> numberList = new ArrayList<>();
//        numberList.add(1);
//        numberList.add(2);
//        numberList.add(3);
//        numberList.add(4);
//        numberList.add(5);
//        numberList.add(6);
//        numberList.add(7);
//        numberList.add(8);
//        numberList.add(9);
//        return numberList;
//    }
//
//    @Override
//    public boolean end(Position currentPosition) {
//        for (Tuple3<Integer, Integer, Integer> t : currentPosition.getNumberPosition()) {
//            if (t._3 == null) {
//                return false;
//            }
//        }
//        return true;
//    }
//}
