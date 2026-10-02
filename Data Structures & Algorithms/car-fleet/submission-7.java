class Solution {
    public record Car(int position, int speed) {}
    public int carFleet(int target, int[] position, int[] speed) {
        
        // position [4, 1, 0, 7]
        // speed    [2, 2, 2, 1]
        int n = position.length;
        List<Car> fleet = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fleet.add(new Car(position[i], speed[i]));
        }

        Collections.sort(fleet, (a, b) -> Integer.compare(b.position, a.position));
        // [[0, 2], [1, 2], [4, 2], [7, 1]]
        Stack<Double> stack = new Stack<>(); // speeds

        for (Car car : fleet) {
            double time = (double) (target - car.position) / car.speed;
            if (stack.isEmpty()) stack.push(time);
            if (time > stack.peek()) {
                stack.push(time);
            }
        }

        return stack.size();
    }
}
