package usecases;

import adapters.local_data.implementations.WordWriterService;
import config.UseCaseNoParams;
import config.UseCaseWithParams;

public class SaveWordUseCase extends UseCaseWithParams<Void, String> {
    WordWriterService wordWriterService = new WordWriterService();
    @Override
    public Void call(String word) {
        return wordWriterService.saveWord(word);
    }
}
