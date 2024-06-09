package adapters.node.implementations;

import adapters.node.repositories.NodeRepository;
import entities.Node;

import java.util.List;

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

    @Override
    public List<String> search(Node node, String word) {
        Node foundNode = findNode(node, word);
        if (foundNode == null) return new java.util.ArrayList<>();
        List<String> words = composeWords(foundNode, word);
        return words;
    }

    @Override
    protected List<String> composeWords(Node node, String word) {
        List<String> words = new java.util.ArrayList<>(List.of());
        if (node.getChildren().isEmpty()) {
            words.add(word);
            return words;
        }
        for (char c : node.getChildren().keySet()) {
            if (!node.getChildren().containsKey(c)) {
                words.add(word + c);
            } else {
                List<String> h = composeWords(node.getChildren().get(c), word + c);
                words.addAll(h);
            }
        }
        return words;
    }

    @Override
    protected Node findNode(Node node, String word) {
        if (word.isEmpty()) return node;
        char c = word.charAt(0);
        if (!node.getChildren().containsKey(c)) {
            return null;
        } else {
            return findNode(node.getChildren().get(c), word.substring(1));
        }
    }
}
