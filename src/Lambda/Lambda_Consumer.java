package Lambda;

import java.util.function.Consumer;
/*
    - 객체 T를 매개변수로 받아 사용
    - 반환값 없음
    - 매개변수 두개 받은 BiConsumer도 존재
* */

public class Lambda_Consumer {
    public static void main(String[] args) {
        Consumer<Integer> consumer =
                (num) -> System.out.println(num + " * 10 = " + (num * 10));
        
        consumer.accept(100);
        consumer.accept(200);
        consumer.accept(300);

        Consumer<Integer> consumerAdd =
                (num) -> System.out.println(num + " + 100 = " + (num + 100));

        Consumer<Integer> consumerMinus =
                (num) -> System.out.println(num + " - 100 = " + (num - 100));
        
        consumerAdd.andThen(consumerMinus).accept(50);
        
    }
}
