//package puzzle;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Set;
//import java.util.concurrent.*;
//
//public class ConcurrentSolvePuzzle {
//    private static ExecutorService executorService = Executors.newCachedThreadPool();
//    static ConcurrentHashMap<Position, Boolean> seedList = new ConcurrentHashMap<>();
//    static CompletionService<List<Position>> completionService = new ExecutorCompletionService<>(executorService);
//
//    public static class Solver implements Callable<List<Position>> {
//        private Puzzle puzzle;
//        public Position position;
//
//        public Solver(Puzzle puzzle, Position position) {
//            this.puzzle = puzzle;
//            this.position = position;
//        }
//
//        @Override
//        public List<Position> call() throws Exception {
//            if (puzzle.end(position)) {
//                List<Position> positions = new ArrayList<>();
//                positions.add(position);
//                return positions;
//            } else {
//                List<Position> nextPositions = puzzle.moveList(position);
//                if (seedList.putIfAbsent(position, true) == null) {
//                    for (Position nextPosition : nextPositions) {
//                        completionService.submit(new Solver(puzzle, nextPosition));
//                    }
//                    for (int i = 0; i < nextPositions.size(); i++) {
//                        Future<List<Position>> a = completionService.take();
//                        if (!a.get().isEmpty()) {
//                            a.get().add(0, position);
//                            return a.get();
//                        }
//                    }
//                }
//            }
//            return new ArrayList<>();
//        }
//    }
//
//
//    public static void main(String[] args) throws Exception {
//        Solver solver = new Solver(new EightQueen(), new Position());
//        System.out.println(solver.call());
//    }
//}
