class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 方法1：直接排序
        // if (n == 0){
        //     Arrays.sort(nums1);
        // }else{
        //     for (int i = m;i < nums1.length; i++){
        //         nums1[i] = nums2[i-m];
        //     }
        //     Arrays.sort(nums1);
        // }
    // 方法2：双指针
    // 复制num1
    int [] nums1_copy = new int[m];
    System.arraycopy(nums1, 0, nums1_copy, 0, m);

    // 创建两个指针
    int p1 = 0;
    int p2 = 0;

    // 该指针供num1修改用
    int p = 0;

    // 逐个比对，并修改num1中的数
    // and add the smallest one into nums1.
    while ((p1 < m) && (p2 < n))
      nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

    // if there are still elements to add
    if (p1 < m)
      System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
    if (p2 < n)
      System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }
}
