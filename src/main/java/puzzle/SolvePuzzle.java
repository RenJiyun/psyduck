package puzzle;

import ch.qos.logback.classic.sift.AppenderFactoryUsingJoran;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class SolvePuzzle {
    public List<Position> solution(Puzzle puzzle, Position position) {
        if (puzzle.end(position)) {
            return Arrays.asList(position);
        } else {
            List<Position> nextPositions = puzzle.moveList(position);
            if (nextPositions.isEmpty()) {
                return new ArrayList<>();
            }

            for (Position nextPosition : nextPositions) {
                List<Position> temp = solution(puzzle, nextPosition);
                if (temp.isEmpty()) {
                    continue;
                }
                temp.add(0, position);
                return temp;
            }
            return new ArrayList<>();
        }
    }
}
