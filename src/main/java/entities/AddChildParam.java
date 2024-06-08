package entities;

public class AddChildParam {
    public final String word;
    public final Node node;

    public AddChildParam(Node node, String word) {
        this.node = node;
        this.word = word;
    }
}
