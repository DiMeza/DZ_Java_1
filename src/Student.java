import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
public class Student implements Serializable {
    private String name;
    private int age;
    private Gender gender;

    // Перечисление для гендера
    public enum Gender { MALE, FEMALE };

    // Конструктор без параметров
    public Student() {}

    // Конструктор с параметрами
    public Student(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Статический метод для создания экземпляра через Builder
    public static StudentBuilder builder() {
        return new StudentBuilder();
    }

    // Внутренний класс Builder
    public static class StudentBuilder {
        private String name;
        private int age;
        private Gender gender;

        public StudentBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StudentBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public StudentBuilder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public Student build() {
            return new Student(name, age, gender);
        }
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    // Переопределенный метод toString()
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }
}
