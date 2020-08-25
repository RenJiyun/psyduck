package puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentSolvePuzzle {
    private ExecutorService executorService = Executors.newFixedThreadPool(4);
    private Puzzle puzzle;
    private Position position;
    private List<Position> seedList = new ArrayList<>();
    public ConcurrentSolvePuzzle(Puzzle puzzle,Position position){
        this.puzzle=puzzle;
        this.position=position;
    }

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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Puzzle puzzle =new Puzzle() {
            Position p=new Position(3);
            Position p1=new Position(4);
            Position p2=new Position(1);
            @Override
            public Position start() {
                return new Position(4);
            }

            @Override
            public List<Position> moveList(Position currentPosition) {
                List<Position> positions = new ArrayList<>();
                positions.add(p);
                positions.add(p1);
                positions.add(p2);
                return positions;
            }

            @Override
            public boolean end(Position currentPosition) {
                Position position = new Position(1);
                if (position.pos == currentPosition.pos) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        ConcurrentSolvePuzzle concurrentSolvePuzzle = new ConcurrentSolvePuzzle(puzzle, puzzle.start());
        for (int i = 0; i <= 5; i++) {
            Future<List<Position>> future=concurrentSolvePuzzle.newTask();
            if (future.get()!=null){
                System.out.println(future.get());
                break;
            }
        }

    }
}
