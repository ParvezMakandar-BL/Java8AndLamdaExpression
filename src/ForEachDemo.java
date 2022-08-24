import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("BMW");
        list.add("Rolls Royce");
        list.add("ALTO");
        list.add("Ferrari");
        System.out.println("Using ITERATOR: ");
        Iterator itr = list.iterator();
        while (itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.println("\nUsing forEach Loop : ");
        list.forEach(item -> System.out.print(item+" "));
    }
}
