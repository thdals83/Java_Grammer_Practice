package Lambda;

/*
    - 객체 T 받아 R로 처리
    - andThen 기능 제공 => 함수가 실행 되고 다음 께 연이어 실행
    - compose 기능 제공 => 함수가 실행 이전에 먼저 실행
* */

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Lambda_Function {
    public static void main(String[] args) {
        Function<Integer, Integer> functionAdd = (num) -> num + 100;

        Function<Integer, Integer> functionMulti = (num) -> num * 50;

        System.out.println(functionAdd.apply(50));
        System.out.println(functionMulti.apply(50));

        //andThen 사용 예시
        System.out.println(functionAdd.andThen(functionMulti).apply(50));
        //compose 사용 예시
        System.out.println(functionAdd.compose(functionMulti).apply(50));
        
        //identity() 예시
        List<Integer> integerList = Arrays.asList(1,2,3);
        integerList.stream().map(Function.identity()).forEach(System.out::println);
        
        Function<String, Integer> strCount = x -> x.length();
        Integer res = strCount.apply("testTest");
        System.out.println(res);

        System.out.println("-------------------------");
        Case4.test();
        
    }
    
    static class Case4{
        static void test() {
            List<String> list = Arrays.asList("node", "c++", "java", "javascript");
            Map<String, Integer> map = listToMap(list, String::length);
            System.out.println(map);
        }
        
        static <T, R> Map listToMap(List<T> list, Function<T, R> func) {
            Map<T, R> result = new HashMap<>();
            for (T t : list) {
                result.put(t, func.apply(t));
            }
            return result;
        }
    }

}
