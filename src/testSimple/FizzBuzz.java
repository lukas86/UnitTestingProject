package testSimple;

public class FizzBuzz {
    public String play(int number) {
        String result = "";
        if(number % 3 == 0) {
            result += "Fizz";
        }
        if(number % 5 == 0) {
            result += "Buzz";
        }

        if(result.isEmpty()){
            result = String.valueOf(number);
        }
        return result;

        /*
        if(number % 15 == 0) {
            return "testSimple.FizzBuzz";
        }
        if(number % 5 == 0) {
            return "Buzz";
        }
        if(number % 3 == 0) {
            return "Fizz";
        }
        */
    }
}
