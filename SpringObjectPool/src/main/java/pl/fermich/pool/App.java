package pl.fermich.pool;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PoolableObject pooledObject = (PoolableObject) context.getBean("poolableObject");

        List<Integer> integers = new ArrayList<>();
        for (int i=0; i<9; i++) integers.add(i + 1);

        integers.parallelStream().forEach(a -> {
            pooledObject.printObjectRef();
        });
    }

}
