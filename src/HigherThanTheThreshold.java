import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class HigherThanTheThreshold {
    public static void main(String[] args) {
        System.out.println(reduceGifts(Arrays.asList(9,6,7,2,7,2), 2, 13));
    }
    public static int reduceGifts(List<Integer> prices, int k, int threshold) {
        int result = 0;
        Collections.sort(prices);
        System.out.println (" Prices" + prices);
        int size = prices.size();

        // that is weird but that's what is requested
        if (threshold < prices.get(0)){
            return size - k + 1;
        }

        int curLastInd = k - 1;
        int sum = 0;
        int j = -1;
        while(sum <= threshold && curLastInd < size){
            j = j + 1;
            curLastInd ++;
            System.out.println("J = " + j);
            System.out.println("curLastInd = " + curLastInd);
            sum = 0;
            for (int i = j; i <curLastInd; i++){
                sum += prices.get(i);
            }

            System.out.println("sum = " + sum);
        }

        result = sum > threshold ? size - curLastInd + 1 : 0 ;
        System.out.println(result);
        return result;
    }

    //TODO: solve in a binary search manner
    public static int reduceGifts1(List<Integer> prices, int k, int threshold) {
        System.out.println (" Prices" + prices);
        System.out.println (" k=" + k);
        System.out.println (" threashhold=" + threshold);
        Collections.sort(prices);
        int size = prices.size();

        int curLastInd = size;
        int sum = 0;
        for (int i = curLastInd; i > size - k; i--){
            sum +=i;
        }

        int exceed = 0;
        if (sum > threshold){
            exceed = sum - threshold;
            int maxAllowedPrice = prices.get(curLastInd - 1) - exceed;
            System.out.println (" maxAllowedPrice=" + maxAllowedPrice);

            int inclusion = Collections.binarySearch(prices, maxAllowedPrice);
            System.out.println (" inclusion=" + inclusion);
            if (inclusion < 0){
                curLastInd = Math.abs(inclusion) - 1;
            }
            else {
                curLastInd = inclusion;
            }
            System.out.println (" curLastInd=" + curLastInd);
        }

        int result = size - curLastInd;

        return result;
    }
}