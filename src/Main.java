import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Создаем список студентов
        List<Student> students = new ArrayList<>();

        // Добавляем студентов разными способами
        students.add(new Student("Иван", 20, Student.Gender.MALE));
        students.add(new Student("Марина", 22, Student.Gender.FEMALE));
        students.add(Student.builder().setName("Сергей").setAge(25).setGender(Student.Gender.MALE).build());

        String currentDir = System.getProperty("user.dir");
        // Запись списка студентов в файл
        String filePath = currentDir + "/students.txt";
        FileOperations.writeStudentsToFile(students, filePath);

        // Чтение списка студентов из файла
        List<Student> loadedStudents = FileOperations.readStudentsFromFile(filePath);

        // Вывод на экран студентов определенного пола (например, мужского)
        System.out.println("Студенты мужского пола:");
        for (Student student : loadedStudents) {
            if (student.getGender() == Student.Gender.MALE) {
                System.out.println(student);
            }
        }
    }
}
