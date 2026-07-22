class Solution {
    public int mostBooked(int n, int[][] meetings) {
          Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

       int[] roomCount = new int[n];
       PriorityQueue<Integer> freeRoom = new PriorityQueue<>();

       for(int i = 0; i < n; i++) {
           freeRoom.offer(i);
       }

       PriorityQueue<Long[]> usedRoom = new PriorityQueue<>((a, b) -> {
           if (!a[0].equals(b[0])) {
               return Long.compare(a[0], b[0]); 
           }
           return Long.compare(a[1], b[1]); 
       });

       for(int[] meeting : meetings) {
           long start = meeting[0];
           long end = meeting[1];
           long duration = end - start;

           while(!usedRoom.isEmpty() && usedRoom.peek()[0] <= start) {
               Long[] finishRoom = usedRoom.poll(); 
               freeRoom.offer(finishRoom[1].intValue()); // Convert Long to int
           } 

           if(!freeRoom.isEmpty()) {
               int room = freeRoom.poll();
               roomCount[room]++;
               usedRoom.offer(new Long[]{end, (long) room});
           }
           else {
              
               Long[] earliestRoom = usedRoom.poll();
               long newStart = earliestRoom[0];
               long newEnd = newStart + duration;
               int room = earliestRoom[1].intValue();
               roomCount[room]++;

               usedRoom.offer(new Long[]{newEnd, (long) room});
           }
       }

       int maxMeeting = -1;
       int resultRoom = -1;

       for(int i = 0; i < n; i++) {
           if(roomCount[i] > maxMeeting) {
               maxMeeting = roomCount[i];
               resultRoom = i;
           }
       }

       return resultRoom;
    }
}