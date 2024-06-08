package adapters.node.repositories;

import entities.Node;

public abstract class NodeRepository {
    public abstract Node addChild(Node node, String word);
}
