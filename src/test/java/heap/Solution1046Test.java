package heap;

import java.util.PriorityQueue;

public class Solution1046Test {
    public static void main(String[] args) {
//        Solution1046 solution1046 = new Solution1046();
        int[] stones = {4,5,8,2,1,67,21};
        PriorityQueue<Integer> queue = new PriorityQueue<>(stones.length);
        for (int i=0;i<stones.length;i++){
            queue.offer(stones[i]);
        }
//        Iterator<Integer> iterator = queue.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
        while (queue.size()>0){
            System.out.println(queue.poll());
        }


//        int weight = solution1046.lastStoneWeight(stones);
//        System.out.println(weight);
    }

}