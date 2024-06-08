package adapters.local_data.implementations;

import adapters.local_data.repositories.WordReaderRepository;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WordReaderService implements WordReaderRepository {
    @Override
    public List<String> loadWords() {
        try {
            return Files.readAllLines(Paths.get("words.txt"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
