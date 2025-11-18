class Solution {
        public int trap(int[] height) {
    if (height == null || height.length == 0) return 0;

    int left = 0; 
    int right = height.length - 1;
    
    int leftMax = 0; 
    int rightMax = 0;
    
    int totalWater = 0;

    while (left < right) {
        // Compare the heights at the two pointers
        if (height[left] < height[right]) {
            // If current bar is taller than leftMax, update leftMax
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                // Otherwise, we trap water!
                // Water = limit - current height
                totalWater += leftMax - height[left];
            }
            left++; // Move left pointer inward
        } else {
            // If current bar is taller than rightMax, update rightMax
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                // Otherwise, we trap water!
                totalWater += rightMax - height[right];
            }
            right--; // Move right pointer inward
        }
    }
    
    return totalWater;
}
    
}