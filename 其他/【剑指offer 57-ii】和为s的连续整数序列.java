class Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        //最多只能是Math.sqrt(1+8*target)/2-0.5个数（从1开始，解方程），最少也得2个
        for(int i = (int)(Math.sqrt(1+8*target)/2-0.5);i > 1;i--){
            int[] res = fun(target,i);
            if(res != null) list.add(res);
        }
       
        return list.toArray(new int[list.size()][]);
        
    }

    //nums为连续数的个数
    public int[] fun(int target, int nums){
        int[] res = null;
        if(nums%2==1){//为奇数个数时
            if(target%nums == 0){//要想能够找到连续的奇数个数，target必须整除nums
                res = new int[nums];
                for(int i = 0;i < res.length;i++){
                    res[i] = (target/nums)-(nums-1)/2+i;
                }
            } 
        }else{//nums为偶数个数
            if(target % (nums / 2) == 0){//头尾两个数合成一组，所以target必须整除nums/2
                int midSum = target / (nums/2);//中间两个数的和
                if (midSum%2==1){//中间两个连续的数的和必为奇数
                    res = new int[nums];
                    int leftMid = midSum/2;
                    for(int i = 0;i < res.length;i++){
                        res[i] = leftMid - nums / 2 + 1 + i;
                    }
                }
            } 
        }
        return res;
    }
}
