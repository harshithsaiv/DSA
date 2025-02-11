class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> leftHeap= new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        long totalCost=0;
        int left=0,right=costs.length - 1;

        for(int i =0 ;i<candidates;i++){
            leftHeap.add(costs[i]);
            left++;
        }

        for(int i=Math.max(candidates,costs.length-candidates);i<costs.length;i++){
            rightHeap.add(costs[i]);
            right--;
        }

        for (int i = 0; i < k; i++) {
            if (!leftHeap.isEmpty() && (rightHeap.isEmpty() || leftHeap.peek() <= rightHeap.peek())) {
                totalCost += leftHeap.poll();
                if (left <= right) {
                    leftHeap.add(costs[left]);
                    left++;
                }
            } else {
                totalCost += rightHeap.poll();
                if (left <= right) {
                    rightHeap.add(costs[right]);
                    right--;
                }
            }
        }

        return totalCost;
        }

        
    }