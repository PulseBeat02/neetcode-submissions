class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int gasSum = 0;
        for (int g : gas) gasSum += g;

        int costSum = 0;
        for (int c : cost) costSum += c;

        if (costSum > gasSum) {
            return -1;
        }

        int total = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                index = i + 1;
            }
        }
        
        return index;
    }
}
