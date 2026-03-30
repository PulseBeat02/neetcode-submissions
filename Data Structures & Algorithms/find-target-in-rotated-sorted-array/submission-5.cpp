class Solution {
public:
    int search(vector<int>& nums, int target) {

        //        |
        // 6 [1 2 3 4 5] (right)

        //    |
        // [3 4 5 6] 1 2 (left)


        // 0 1 2 3 4 5
        
        // 2
int n = nums.size();
int left = 0;
int right = n - 1;

while (left <= right) {
    int mid = left + (right - left) / 2;

    if (nums[mid] == target)
        return mid;

    // Right half is sorted
    if (nums[mid] <= nums[right]) {
        if (nums[mid] < target && target <= nums[right]) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }
    // Left half is sorted
    else {
        if (nums[left] <= target && target < nums[mid]) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }
}

return -1;

        return -1;
    }
};
