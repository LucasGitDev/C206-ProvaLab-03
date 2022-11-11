package Controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class FileController {
    public static List<String> readAllLines(String path) {
        Path filePath = Paths.get(path);

        try {
            return Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeAllLines(String path, List<String> lines) {
        Path filePath = Paths.get(path);

        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getFilesInFolder(String path) {

        try {
            Path filePath = Paths.get(path);
            Stream<Path> files = Files.list(filePath);
            return files.map(Path::toString).toList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
