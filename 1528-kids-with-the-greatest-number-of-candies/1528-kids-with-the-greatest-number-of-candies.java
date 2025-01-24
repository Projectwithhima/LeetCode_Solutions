class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       List<Boolean> list =new ArrayList<>();
       int maxcandy =0;
       for(int candy : candies){
        maxcandy= Math.max(maxcandy,candy);
       }
       for ( int candy : candies){
        if(candy + extraCandies>=maxcandy){
            list.add(true);
        }
        else{
        list.add(false);
       }
        }
       return list;
    }

}