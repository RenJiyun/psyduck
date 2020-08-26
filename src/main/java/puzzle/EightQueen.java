package puzzle;

import java.util.List;

public class EightQueen implements Puzzle {
    private int[][] lattice=new int[8][8];


    @Override
    public Position start() {


    }

    @Override
    public List<Position> moveList(Position currentPosition) {
        return null;
    }

    @Override
    public boolean end(Position currentPosition) {
        return false;
    }
}
