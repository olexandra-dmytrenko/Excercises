import java.util.stream.IntStream;

public class FizzBuzz {
    public static void main(String[] args) {
        fizzBuzz(16);
    }
    private static void fizzBuzz(int n) {
        IntStream.rangeClosed(1, n)
                .mapToObj(numb -> {
                    String result = "";
                    if (numb % 3 == 0) {
                        result += "Fizz";
                    }
                    if (numb % 5 == 0) {
                        result += "Buzz";
                    } else if (numb % 3 != 0) {
                        result += numb;
                    }
                    return result;
                })
                .forEach(System.out::println);
    }
}
