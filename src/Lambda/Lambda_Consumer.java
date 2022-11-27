package Lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/*
    - 객체 T를 매개변수로 받아 사용
    - 반환값 없음
    - 매개변수 두개 받은 BiConsumer도 존재
* */

public class Lambda_Consumer {
    public static void main(String[] args) {
//        case1();
//        case2();
//        case3();
//        case4();
        case5();
    }

    public static void case1() {
        //일반 인자 호출
        Consumer<Integer> consumer1 =
                (num) -> System.out.println(num + " * 10 = " + (num * 10));
        Consumer<String> upperConsumer =
                (String) -> System.out.println(String.toUpperCase());

        consumer1.accept(100);
        upperConsumer.accept("hello world");
    }

    public static void case2() {
        //연속된 연산에 사용
        Consumer<Integer> consumerAdd =
                (num) -> System.out.println(num + " + 100 = " + (num + 100));

        Consumer<Integer> consumerMulti =
                (num) -> System.out.println(num + " - 100 = " + num * 100);

        consumerAdd.andThen(consumerMulti).accept(50);
    }

    public static void case3() {
        List<String> fruits = Arrays.asList("apple", "kiwi", "orange");
        
        Consumer<String> addUpperNumber = 
                str -> System.out.println(str.toUpperCase());
        
        fruits.forEach(addUpperNumber);
    }
    
    public static void case4() {
        List<String> fruits = Arrays.asList("apple", "kiwi", "orange");

        Consumer<List<String>> addNumber = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, (i + 1) + ". " + list.get(i));
            }
        };
        
        Consumer<List<String>> printlist = list -> {
            for (String fruit: list) {
                System.out.println(fruit);
            }
        };
        
        addNumber.andThen(printlist).accept(fruits);
    }
    
    public static void case5() {
        List<Student> students = Arrays.asList(
                new Student(1, 3, "john"),
                new Student(2, 4, "Jane"),
                new Student(3, 3,"Jack"));
        
        Consumer<Student> raiser = student -> {
            student.gpa = student.gpa * 2;
        };
        
        Student.raiseStudents(students, System.out::println);
        Student.raiseStudents(students, raiser.andThen(System.out::println));
        
    }
    
    static class Student {
        public int id;
        public double gpa;
        public String name;
        
        Student(int id, long gpa, String name) {
            this.id = id;
            this.gpa = gpa;
            this.name = name;
        }
        
        static void raiseStudents(List<Student> emoloyees,
                                  Consumer<Student> fx) {
            for (Student e: emoloyees) {
                fx.accept(e);
            }
        }
        
        @Override
        public String toString() {
            return id + "-> " + name + ": " + gpa;
        }
    }
}
