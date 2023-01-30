package ch17.sec10;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        OptionalDouble optionalDouble = list.stream().mapToInt(Integer::intValue).average();
        if(optionalDouble.isPresent())
        {
            System.out.println("방법1_평균: "+optionalDouble.getAsDouble());
        }else{
            System.out.println("방법1_평균: 0.0");
        }
    }
}
