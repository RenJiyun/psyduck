package puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ConcurrentSolvePuzzle {
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private Puzzle puzzle;
    private Position position;
    private List<Position> seedList = new ArrayList<>();

    public Future<List<Position>> newTask() {
        SolvePuzzle solvePuzzle = new SolvePuzzle();
        Future<List<Position>> future = executorService.submit(solvePuzzle);
        return future;
    }

    public class SolvePuzzle implements Callable<List<Position>> {
        private puzzle.SolvePuzzle solvePuzzle = new puzzle.SolvePuzzle();

        @Override
        public List<Position> call() throws Exception {
            return solvePuzzle.solution(puzzle, position, seedList);
        }
    }

    public static void main(String[] args) {
        ConcurrentSolvePuzzle concurrentSolvePuzzle = new ConcurrentSolvePuzzle();
        List<Future<List<Position>>> futures = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            futures.add(concurrentSolvePuzzle.newTask());
        }
    }
}
