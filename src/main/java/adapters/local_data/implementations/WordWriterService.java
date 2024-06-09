package adapters.local_data.implementations;

import adapters.local_data.repositories.WordWriterRepository;

import java.io.FileWriter;
import java.io.IOException;

public class WordWriterService implements WordWriterRepository {
    @Override
    public Void saveWord(String word) {
        try {
            FileWriter fileWriter = new FileWriter("words.txt", true);
            fileWriter.write(word + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
