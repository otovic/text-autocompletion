package adapters.node.implementations;

import adapters.node.repositories.NodeRepository;
import entities.Node;

public class NodeService extends NodeRepository {
    @Override
    public Node addChild(Node node, String word) {
        if (word.isEmpty()) return node;
        char c = word.charAt(0);
        if (!node.getChildren().containsKey(c)) {
            node.getChildren().put(c, new Node());
            addChild(node.getChildren().get(c), word.substring(1));
        } else {
            addChild(node.getChildren().get(c), word.substring(1));
        }
        return node;
    }
}
