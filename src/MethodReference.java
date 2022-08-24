import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface MyFunctionalInterface {
    Person getPerson(String name, int age);
}
interface Greeting{
    void greet();
}
public class MethodReference {
    public static int compareByAge(Person a, Person b) {
        return a.getAge().compareTo(b.getAge());
    }
    public void greet(){
        System.out.println("Hello!");
    }
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Zarine", 28));
        personList.add(new Person("Ada", 33));
        personList.add(new Person("Naseema", 18));
        /*  Reference to static method */
        System.out.println("Method reference to static method of main class");
        System.out.println("Sort By Age: ");
        personList.sort(MethodReference::compareByAge);
        personList.stream()
                .map(Person::getName)
                .forEach(System.out::println);
        Function<String, String> displayName = Person::displayName;
        System.out.println("Method reference to static method of person class");
        System.out.println(displayName.apply("Parvez"));
        System.out.println("Method reference to instance method");
        MethodReference methodReferenceDemo = new MethodReference();
        Greeting greeting = methodReferenceDemo::greet;
        greeting.greet();
        System.out.println("Method reference to constructor");
        MyFunctionalInterface mfi = Person::new;
        BiFunction<String, Integer, Person> f1 = Person::new;
        BiFunction<String, Integer, Person> f2 = Person::new;
        System.out.println(mfi.getPerson("Parvez", 27));
        System.out.println(f1.apply("Rahul", 22));
        System.out.println(f2.apply("Ashray", 30));
    }
}
