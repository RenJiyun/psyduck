package puzzle;

import java.util.List;

public class Node {
    private  Position position;
    private  Node preNode;
    private List<Move> moveList;
    public Node(Position position,Node preNode,List<Move> moveList){
        this.position=position;
        this.preNode=preNode;
        this.moveList=moveList;
    }
    public List<Move> getMoveList(){
        return  moveList;
    }

    public boolean isGold(){
        return  true;
    }
}
