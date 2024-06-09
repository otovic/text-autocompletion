package adapters.node.repositories;

import entities.Node;

import java.util.List;

public abstract class NodeRepository {
    public abstract Node addChild(Node node, String word);
    public abstract List<String> search(Node node, String word);
    protected abstract Node findNode(Node node, String word);
    protected abstract List<String> composeWords(Node node, String word);
}
