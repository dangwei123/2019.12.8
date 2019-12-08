给定一个无序的整数数组，找到其中最长上升子序列的长度
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] arr=new int[nums.length];
        int a=0;
        int l=0;
        int r=0;
        for(int i=0;i<nums.length;i++){
            l=0;
            r=a;
            while(l<r){
                int mid=(l+r)>>>1;
                if(arr[mid]<nums[i]){
                    l=mid+1;
                }else{
                    r=mid;
                }
            }
            arr[l]=nums[i];
            if(l==a){
                a++;
            }
        }
        return a;
    }
}

给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] res=new int[A.length+1][B.length+1];
        int maxlen=0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                    res[i+1][j+1]=A[i]==B[j]?res[i][j]+1:0;
                    maxlen=Math.max(maxlen,res[i+1][j+1]);
            }
        }
        return maxlen;
    }
}

如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：

n >= 3
对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/length-of-longest-fibonacci-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int[][] dp=new int[A.length][A.length];
        int res=0;
        for(int i=2;i<A.length;i++){
            int l=0;
            int r=i-1;
            while(l<r){
                int sum=A[l]+A[r];
                if(sum==A[i]){
                    dp[r][i]=dp[l][r]+1;
                    res=Math.max(res,dp[r][i]);
                    l++;
                    r--;
                }else if(sum<A[i]){
                    l++;
                }else{
                    r--;
                }
            }
        }
         return res==0?0:res+2;
    }
}


有一堆石头，每块石头的重量都是正整数。

每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

如果 x == y，那么两块石头都会被完全粉碎；
如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/last-stone-weight-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int i:stones){
            sum+=i;
        }
        int tmp=sum;
        sum/=2;
        int[] dp=new int[sum+1];
        for(int i=0;i<stones.length;i++){
            for(int j=sum;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return tmp-2*dp[sum];
    }
}


