package array;

/**
 * @author wsh
 * @date 2024/1/5
 */
public class GasStationNo134 {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int n = gas.length;
        while (start < n) {
            int sumGas = 0;
            int sumCost = 0;
            int counter = 0;
            while (counter < n) {
                int j = (counter + start) % n;
                sumGas += gas[j];
                sumCost += cost[j];

                if (sumCost > sumGas) {
                    break;
                }
                counter++;
            }

            if (counter == n) {
                return start;
            } else {
                start = start + counter + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
