class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /*

        1 2 3 4 
        2 2 4 1
        
        -1 0 -1 3

        */
        int n = gas.length;
        int[] weights = new int[n];
        int gasTotal = 0;
        int costTotal = 0;
        for (int i = 0; i < n; i++) {
            weights[i] = gas[i] - cost[i];
            gasTotal += gas[i];
            costTotal += cost[i];
        }

        if (costTotal > gasTotal) return -1;

        int index = 0;
        int tank = 0;
        for (int i = 0; i < n; i++) {
            tank += weights[i];
            if (tank < 0) {
                tank = 0;
                index = i + 1;
            }
        }

        return index;
    }
}
