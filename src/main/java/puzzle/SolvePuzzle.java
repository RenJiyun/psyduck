package puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolvePuzzle {
    public List<Position> solution(Puzzle puzzle, Position position) {
        if (puzzle.end(position)) {
            return Arrays.asList(position);
        } else {
            List<Position> list=new ArrayList<>();
            List<Position> moveList = puzzle.moveList(position);
            for (Position position1 : moveList) {
                list=solution(puzzle,position1);
               if (list==null){
                   continue;
               }else {
                   list.add(0,position);
               }
            }
            return list;
        }

    }

}
