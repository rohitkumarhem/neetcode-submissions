class MedianFinder {
    
    List<Integer> res;
    public MedianFinder() {

        this.res= new ArrayList<>();
        
    }
    
    public void addNum(int num) {
       res.add(num);
    }
    
    public double findMedian() {

       Collections.sort(res);

       int n = res.size();

       if((n & 1) == 1)
       {
         return res.get(n/2);
       } 
       else
       {
          return (res.get(n/2) + res.get(n/2-1)) /2.0;
       }
    }
}
