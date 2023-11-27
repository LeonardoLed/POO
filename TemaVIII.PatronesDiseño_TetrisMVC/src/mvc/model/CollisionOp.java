package mvc.model;

public class CollisionOp {

    //this could also be a boolean, but we want to be explicit about what we're doing
    public enum Operation {
        ADD, REMOVE
    }

    //members
    private Movable mMovable;
    private Operation mOperation;

    //constructor
    public CollisionOp(Movable movable, Operation op) {
        mMovable = movable;
        mOperation = op;
    }


    //getters
    public Movable getMovable() {
        return mMovable;
    }

    public Operation getOperation() {
        return mOperation;
    }

}
