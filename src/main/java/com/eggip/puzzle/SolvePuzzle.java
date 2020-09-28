//package com.eggip.puzzle;
//
//import java.util.*;
//
//public class SolvePuzzle {
//
//    public static List<Position> solution(Puzzle com.eggip.puzzle, Position position, Set<Position> seeDList) {
//        if (com.eggip.puzzle.end(position)) {
//            List<Position> temp = new ArrayList<>();
//            temp.add(position);
//            return temp;
//        } else {
//            List<Position> nextPositions = com.eggip.puzzle.moveList(position);
//            if (nextPositions.isEmpty()) {
//                return new ArrayList<>();
//            }
//            if (!seeDList.contains(position)) {
//                seeDList.add(position);
//                for (Position nextPosition : nextPositions) {
//                    List<Position> temp = solution(com.eggip.puzzle, nextPosition, seeDList);
//                    if (temp.isEmpty()) {
//                        continue;
//                    }
//                    temp.add(0, position);
//                    return temp;
//                }
//            }
//            return new ArrayList<>();
//        }
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(solution(new EightQueen(), new Position(), new HashSet<>()));
//    }
//}
