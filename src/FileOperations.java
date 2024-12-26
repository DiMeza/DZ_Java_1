import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class FileOperations {
    // Метод для записи списка студентов в файл
    public static void writeStudentsToFile(List<Student> students, String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.createDirectories(path.getParent()); // Создает директорию, если ее нет
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(students);
        }
    }

    // Метод для чтения списка студентов из файла
    public static List<Student> readStudentsFromFile(String filePath) throws IOException, ClassNotFoundException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            return new ArrayList<>();
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Student>) in.readObject();
        }
    }
}
