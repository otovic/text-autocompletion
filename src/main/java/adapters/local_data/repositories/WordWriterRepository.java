package adapters.local_data.repositories;

import java.util.List;

public interface WordWriterRepository {
    void saveWord(String word);
    void saveWords(List<String> words);
}
