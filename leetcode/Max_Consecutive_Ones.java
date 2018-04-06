class Max_Consecutive_Ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        int fin = 0;
        int consec = 0;
        for(int index = 0; index < nums.length; index++) {
            if(nums[index] == 1) {
                consec = consec + 1;
                if(consec > fin) {
                    fin = consec;
                }
            } else {
                consec = 0;
            }
        }
        return fin;
    }
    public static void main(String args[]) {
        int num = findMaxConsecutiveOnes([0,1,,0,0,1,1,0,1,0,1,1,1,1]);
        System.out.println(num);
    }
}