class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[]=new int[26];
        for(char task:tasks){
            count[task-'A']++;
        }

        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<26;i++)
        {
            if(count[i]>0){
                heap.add(count[i]);
            }
        }
        
        int time=0;
        Queue<int[]> queue=new LinkedList<>();

        while(!queue.isEmpty() || !heap.isEmpty()){
            time++;
            if(heap.isEmpty())
            {
                time=queue.peek()[1];
            }
            else{
                int cnt=heap.poll()-1;
                if(cnt>0)
                    queue.add(new int[]{cnt,time+n});
            }

            if(!queue.isEmpty() && queue.peek()[1]==time)
            {
                heap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}