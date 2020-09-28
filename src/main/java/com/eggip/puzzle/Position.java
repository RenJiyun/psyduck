//package com.eggip.puzzle;
//
//import io.vavr.Tuple2;
//import io.vavr.Tuple3;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
//public class Position {
//
//    private List<Tuple3<Integer, Integer, Integer>> numberPosition = new ArrayList<>();
//
//    public Position(List<Tuple3<Integer, Integer, Integer>> numberPosition) {
//        this.numberPosition = numberPosition;
//    }
//
//    public Position() {
//    }
//
//    public List<Tuple3<Integer, Integer, Integer>> getNumberPosition() {
//        return numberPosition;
//    }
//
//    public Stack<Tuple2<Integer, Integer>> state = new Stack<>();
//
//    public Position() {
//    }
//
//    public Position(Stack<Tuple2<Integer, Integer>> state) {
//        this.state = state;
//    }
//
//    @Override
//    public String toString() {
//        return "Position{" +
//                "state=" + state +
//                '}';
//    }
//
//    @Override
//    public int hashCode() {
//        int temp = 0;
//        for (int i = 0; i < state.size(); i++) {
//            temp = temp + state.get(i)._1 + state.get(i)._2;
//        }
//        return temp % 31;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Position position = (Position) o;
//
//        if (position.state.size() != this.state.size()) return false;
//        if (position.state.size() == 0) return true;
//
//        for (int i = 0; i < state.size(); i++) {
//            if (!position.state.get(i).equals(this.state.get(i))) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//}
