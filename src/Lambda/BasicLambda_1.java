package Lambda;

/*
- 람다식으로 만들어진 순수 함수는 함수형 인터페이스로만 선언이 가능
- @FunctionalInterface는 해당 인터페이스가 1개의 함수만 선언하게 제한
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface MyLambdaImpl {
    int max(int a, int b);
}

public class BasicLambda_1 {
    public static void main(String[] args) {
        //기존의 익명 함수
        System.out.println(new MyLambdaFunction() {
            public int max(int a, int b) {
                return a > b ? a: b;
            }
        }.max(2, 3));
        
        //람다식 이용한 익명 함수
        MyLambdaImpl myLambda = (a, b) -> a > b ? a : b;
        System.out.println(myLambda.max(3, 5));
        
        //더블 콜론
        //람다식이 건내는 파라미터와 받는 쪽 파라미터 동일하면 가능
        List<String> names = Arrays.asList("123", "456");
        names.forEach((x) -> System.out.println(x));
        names.forEach(x -> System.out.println(x));
        names.forEach(System.out::println);
    }
}

class MyLambdaFunction {
    
}