package usecases;

import adapters.node.implementations.NodeService;
import config.UseCaseWithParams;
import entities.AddChildParam;
import entities.Node;

public class AddChildUseCase extends UseCaseWithParams<Node, AddChildParam> {
    NodeService nodeService = new NodeService();
    @Override
    public Node call(AddChildParam params) {
        return nodeService.addChild(params.node, params.word);
    }
}
