package misc_questions;

public class DigitsCreationAtMostN {
    public static int atMostNGivenDigitSet(String[] digits, int n) { //500
        int t = n, d = 0, count = 0;
        int l = digits.length;

        while(t >= 1){
            d++;
            t = (t - t % 10) / 10;
        }
        for(int i = 1; i < d; i++) count += Math.pow(l,i);

        String min = "";
        for(int i = 0; i < d; i++) min += digits[0];

        String max = "";
        for(int i = 0; i < d; i++) max += digits[l-1];

        if(Integer.valueOf(min) <= n)
            count += countOfNumbers(min.toCharArray(), 0,
                Integer.valueOf(Math.min(Integer.valueOf(max),n)).toString().toCharArray(), 0, digits, d);
        return count;
    }

    public static int countOfNumbers(char[] min, int mini, char[] max, int maxi, String[] digits,
                                     int d){
        int l = digits.length;
        int c = 0;

        if(maxi == max.length-1){
            for(int i = 0; i < l; i++)
                if(digits[i].compareTo(String.valueOf(max[maxi])) <= 0 &&
                   digits[i].compareTo(String.valueOf(min[mini])) >= 0) c++;
            return c;
        }

        for(int i = 0; i < l; i++){
            if(digits[i].compareTo(String.valueOf(max[maxi])) < 0 &&
               digits[i].compareTo(String.valueOf(min[mini])) >= 0) c += Math.pow(l,(d-maxi-1));
            else if(digits[i].compareTo(String.valueOf(max[maxi])) == 0)
                c += countOfNumbers(min, mini+1, max, maxi+1, digits, d);
        }
        return c;
    }
}
