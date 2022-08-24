public class Person {
    private String name;
    private Integer age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static String displayName(String name){
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() { return age; }
    public String getName() { return name; }
    public String toString() {
        return getName()+" => "+getAge();
    }
}
