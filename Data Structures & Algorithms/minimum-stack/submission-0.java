class MinStack {

    List<int[]> res;

    public MinStack() {
        
      res = new ArrayList<>();  

    }
    
    public void push(int val) {
        
        int x[] = res.isEmpty() ? new int[]{val, val} : res.get(res.size()-1);

        int min = x[1];

        if(min > val)
        {
            min = val;
        }

        res.add(new int[]{val, min});
    }
    
    public void pop() {

        res.remove(res.size()-1);
        
    }
    
    public int top() {
        
        return res.isEmpty() ? -1 : res.get(res.size()-1)[0];
    }
    
    public int getMin() {
        
        return res.isEmpty() ? -1 : res.get(res.size()-1)[1];
    }
}
