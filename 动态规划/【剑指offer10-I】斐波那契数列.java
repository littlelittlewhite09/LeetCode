class Solution {
    private List<Integer> list;
    public Solution(){
        list = new ArrayList<>(2);
        list.add(0);
        list.add(1);
    }
    public int fib(int n) {
        if(n < 2) return list.get(n);
        int i = 0;
        while(i < n - 1){
            list.set(0,(list.get(0)+list.get(1))% 1000000007);
            i++;
            if(i < n - 1){
                list.set(1,(list.get(0)+list.get(1))% 1000000007);
                i++;
            }
        }
        return (((n-1)%2==0) ? list.get(1):list.get(0)) % 1000000007;
    }
}
