package adapters.local_data.repositories;

import java.util.List;

public interface WordReaderRepository {
    List<String> loadWords();
}
