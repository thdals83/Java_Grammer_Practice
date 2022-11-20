package Lambda;

import java.util.function.Supplier;

/*
    - Supplier<T> 매개변수를 받지 않고 반환
    - get()을 통해 Lazy Evalutaion이 가능 (지연 초기화)
       Lazy Evalutaion: 불필요한 연산 지연
*/

public class Lambda_Supplier {
    public static void main(String[] args) {
        Supplier<String> helloSupplier = () -> "Hello ";
        System.out.println(helloSupplier.get() + "World");
    }
}


// 지연 초기화 예시
class SupplierTest<T> {
    public void isTrue(boolean isTrue, Supplier<T> supplier) {
        if (isTrue) {
            T obj = supplier.get();
            // ...
            return;
        }
    }
}