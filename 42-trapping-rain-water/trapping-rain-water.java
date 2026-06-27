class Solution {
    public int trap(int[] height) {
        int lmb[]=new int[height.length];  //lmb = left max boundary;
        int rmb[]=new int[height.length];  //arm = right max boundary;
        rmb[0]=height[0];
        lmb[height.length-1]=height[height.length-1];

        for(int i=1;i<height.length;i++){
            rmb[i]=Math.max(height[i],rmb[i-1]);
            
        }

        for(int i=height.length-2;i>=0;i--){
           lmb[i]=Math.max(height[i],lmb[i+1]);
        }

        int sum=0;
        for(int i=0;i<height.length;i++){
            int min=Math.min(lmb[i],rmb[i]);
            sum=sum+(min-height[i]);
        }
        return sum;
    }
}