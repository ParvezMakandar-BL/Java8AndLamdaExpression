public class Optional {
    public static void main(String[] args) {
        String[] str = new String[10];
        str[5] = "Java optional class example!";
        java.util.Optional<String> checkNull = java.util.Optional.of(str[5]);
        System.out.print(checkNull.get());
    }
}
