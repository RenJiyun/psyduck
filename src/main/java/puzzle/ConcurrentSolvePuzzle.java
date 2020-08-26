package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class ConcurrentSolvePuzzle {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    ConcurrentHashMap<Position, Boolean> seedList = new ConcurrentHashMap<>();
    CompletionService<List<Position>> completableFuture = new ExecutorCompletionService<>(executorService);

    public class Solver implements Callable<List<Position>> {
        private Puzzle puzzle;
        public Position position;
        List<Position> list = new ArrayList<>();

        public Solver(Puzzle puzzle, Position position) {
            this.puzzle = puzzle;
            this.position = position;
        }

        @Override
        public List<Position> call() throws Exception {
            if (puzzle.end(position)) {
                list.add(position);
                return list;
            } else {
                List<Position> nextPositions = puzzle.moveList(position);
                if (!seedList.putIfAbsent(position, true)) {
                    for (Position nextPosition : nextPositions) {
                        completableFuture.submit(new Solver(puzzle, nextPosition));
                    }
                    for (int i = 0; i < nextPositions.size(); i++) {
                        Future<List<Position>> a = completableFuture.take();
                        if (!a.get().isEmpty()) {
                            list = a.get();
                            list.add(0, position);
                            return list;
                        }
                    }
                }
            }
            return new ArrayList<>();
        }
    }


    public static void main(String[] args) {

    }
}
