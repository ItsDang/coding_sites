class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int largestDist = 0;
        ArrayList<Integer> closest = new ArrayList<Integer>();
        for(int ind = 0; ind < arr.length; ind++) {
            int elem = arr[ind];
            int dist = Math.abs(x-elem);
            // System.out.println(elem + " " + dist + " " + largestDist);
            if(closest.size() < k) {
                if(dist > largestDist) {
                    largestDist = dist;
                }
                closest.add(elem);
            } else {
                if(dist < largestDist) {
                    closest.remove(0);
                    int firDist = Math.abs(x-closest.get(0));
                    if(firDist > dist) {
                        largestDist = firDist;
                    } else {
                        largestDist = dist;
                    }
                    closest.add(elem);
                }
            }
        }
        return closest;
    }
}