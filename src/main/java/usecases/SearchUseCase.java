package usecases;

import adapters.node.implementations.NodeService;
import config.UseCaseWithParams;
import entities.AddChildParam;
import entities.Node;

import java.util.List;

public class SearchUseCase extends UseCaseWithParams<List<String>, AddChildParam> {
    NodeService nodeService = new NodeService();
    @Override
    public List<String> call(AddChildParam params) {
        return nodeService.search(params.node, params.word);
    }
}
