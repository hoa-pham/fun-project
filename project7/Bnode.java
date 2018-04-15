import java.util.Random;

class Bnode {
    Bnode left, right;
    int data;

    /* Constructor */
    public Bnode() {
        left = null;
        right = null;
        data = 0;
    }

    /* Constructor */
    public Bnode(int n) {
        left = null;
        right = null;
        data = n;
    }

    /* Function to set left node */
    public void setLeft(Bnode n) {
        left = n;
    }

    /* Function to set right node */
    public void setRight(Bnode n) {
        right = n;
    }

    /* Function to get left node */
    public Bnode getLeft() {
        return left;
    }

    /* Function to get right node */
    public Bnode getRight() {
        return right;
    }

    /* Function to set data to node */
    public void setData(int d) {
        data = d;
    }

    /* Function to get data from node */
    public int getData() {
        return data;
    }
}


