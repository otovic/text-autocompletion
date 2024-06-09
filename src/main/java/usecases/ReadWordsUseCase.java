package usecases;
import adapters.local_data.implementations.WordReaderService;
import config.UseCaseNoParams;

import java.util.List;

public class ReadWordsUseCase extends UseCaseNoParams<List<String>> {
    final WordReaderService wordReaderService = new WordReaderService();

    @Override
    public List<String> call() {
        return wordReaderService.loadWords();
    }
}
