class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        int[] target = new int[nums.length];  // Initialize the target array with the same length as nums
        
        // Iterate over the nums and index arrays
        for (int i = 0; i < nums.length; i++) {
            int insertIndex = index[i];  // The position where we need to insert nums[i]
            
            // Shift elements to the right to make room for the new element at insertIndex
            for (int j = i; j > insertIndex; j--) {
                target[j] = target[j - 1];
            }
            
            // Insert the element at the specified index
            target[insertIndex] = nums[i];
        }
        
        return target;
    }
}
