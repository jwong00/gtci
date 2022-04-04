class PartitionSet {
    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,2,3,4}));
        System.out.println(canPartition(new int[]{1,1,3,4,7}));
        System.out.println(canPartition(new int[]{2,3,4,6}));
    }

    static boolean canPartition(int[] num) {
        int sum = 0;
        for(int i=0;i<num.length;i++) {
            sum+=num[i];
        }

        if(sum%2!=0) return false;

        Boolean[][] memo = new Boolean[num.length][sum/2 + 1];
        return helper(num,sum/2,0,memo);
    }

    static boolean helper(int[] num,int target,int index,Boolean[][] memo) {
        if(target<0 || index > num.length-1) return false;
        else if(memo[index][target]!=null) return memo[index][target];
        else if(target==0) {
            memo[index][target] = true;
            return true;
        }
        else return helper(num,target-num[index],index+1,memo) || helper(num,target,index+1,memo);
    }
}