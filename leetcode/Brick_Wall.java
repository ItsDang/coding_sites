class Solution {
    public int leastBricks(List<List<Integer>> wall) {
//         Find the gaps in each level of the wall.
//         Store gapwidth and how many.
        int biggestGapWidth = 0;
        int biggestGapCount = 0;
        HashMap<Integer, Integer> gapcounts = new HashMap<Integer, Integer>();
        for(List<Integer> row : wall) {
            int gap = 0;
            row.remove(row.size()-1);
            for(Integer width : row) {
                // System.out.print(width+" ");
                gap = gap + width;
                if(!gapcounts.containsKey(gap)) {
                    gapcounts.put(gap,1);
                } else {
                    gapcounts.replace(gap,gapcounts.get(gap) + 1);
                }
                System.out.println(gap);
                if(gapcounts.get(gap) > biggestGapCount) {
                    biggestGapWidth = gap;
                    biggestGapCount = gapcounts.get(gap);
                }
            }
            System.out.println();
        }
        System.out.println(gapcounts);
        System.out.println(biggestGapWidth);
        System.out.println(biggestGapCount);
        return wall.size() - biggestGapCount;
    }
}