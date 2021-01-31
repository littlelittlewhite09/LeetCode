class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        //方法一：遍历二维数组中的一维数组，查看是否有target，使用Arrays.binarySearch(int[] arr, int key)
        int ind = -1;
        for(int i = 0;i < matrix.length;i++){
            ind = Arrays.binarySearch(matrix[i],target);
            if (ind >= 0){
                break;
            }
        }
        return (ind >=0)? true:false;
    }
}
