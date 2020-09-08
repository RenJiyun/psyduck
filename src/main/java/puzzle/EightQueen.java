//package puzzle;
//
//import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
//import io.vavr.Tuple;
//import io.vavr.Tuple2;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Stack;
//
//public class EightQueen implements Puzzle {
//
//    @Override
//    public Position start() {
//        return new Position();
//    }
//
//    @Override
//    public List<Position> moveList(Position currentPosition) {
//        List<Position> result = new ArrayList<>();
//        int x = currentPosition.state.size();
//        for (int y = 0; y < 8; y++) {
//            Tuple2<Integer, Integer> candidate = Tuple.of(x, y);
//            if (isValid(candidate, currentPosition.state)) {
//                Stack<Tuple2<Integer, Integer>> temp = new Stack<>();
//                copy(currentPosition.state, temp);
//                temp.push(candidate);
//                result.add(new Position(temp));
//            } else {
//                continue;
//            }
//        }
//        return result;
//    }
//
//    private boolean isValid(Tuple2<Integer, Integer> candidate, Stack<Tuple2<Integer, Integer>> state) {
//        for (Tuple2<Integer, Integer> t : state) {
//            if (t._2 == candidate._2 || (t._1 - t._2) == (candidate._1 - candidate._2) || (t._1 + t._2) == (candidate._1 + candidate._2)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//
//    private static <E> void copy(Stack<E> s1, Stack<E> s2) {
//        s2.addAll(s1);
//    }
//
//
//    @Override
//    public boolean end(Position currentPosition) {
//        return currentPosition.state.size() == 8;
//    }
//}
