package huffman;

import huffman.tree.Leaf;
import huffman.tree.Node;
import java.util.ArrayList;
import java.util.List;
/**
 * A priority queue of @Node@ objects. Each node has an int as its label representing its frequency.
 * The queue should order objects in ascending order of frequency, i.e. lowest first.
 */
public class PQueue {

    private final List<Node> queue;


    public PQueue() {
        queue = new ArrayList<>();
    }

    /**
     * Add a node to the queue. The new node should be inserted at the point where the frequency of next node is
     * greater than or equal to that of the new one.
     * @param n The node to enqueue.
     */
    public void enqueue(Node n) {
        // when queue is empty add node to o index
        if (queue.isEmpty()) {
            queue.add(n);
            return;
        }
        int freq = n.getFreq();
        //when queue only has one node to compare to
        if (queue.size()==1){
            // if new node is less than old node add to start of arraylist
            if (queue.get(0).getFreq()>freq){
                queue.add(0,n);
            // if new node is greater than old node add to 2nd position in queue
            }else {
                queue.add(1,n);
            }
            return;
        }
        // if new node is bigger than current biggest node in queue
        if(queue.get(queue.size()-1).getFreq()<freq){
            int u=queue.size();
            queue.add(u, n);
            return;
        }
        // if queue has more than one node to compare to
        if (queue.size()>1){
            // updating int for index
            int u=0;
            // for loop cycles through queue
            for (Node c : queue) {
                int cFreq = c.getFreq();
                // if new node freq is greater than current node increment u by 1
                 if (freq > cFreq) {
                    u++;
                // if new node freq is less than current node break out of for loop to avoid cycling through whole queue
                }else break;
            }
            // node added at position in queue
            queue.add(u,n);
        }
    }

    /**
     * Remove a node from the queue.
     * @return  The first node in the queue.
     */
    public Node dequeue() {
        if (queue.isEmpty()) return null;
       return queue.remove(0);
    }

    /**
     * Return the size of the queue.
     * @return  Size of the queue.
     */
    public int size() {
        return queue.size();
    }


        // ignore just testing methods
    public void printPQueue() {
        System.out.print(queue);
    }
    public Node peek(){
        if (queue.isEmpty())return null;
        return queue.get(0);
    }

    public static class pQueueApp {
        public static void main(String[] args) {
            PQueue pq = new PQueue();
            pq.enqueue(new Leaf('a', 42));
            pq.enqueue(new Leaf('b', 1));
            pq.enqueue(new Leaf('c', 101));
            pq.enqueue(new Leaf('d', -101));
            pq.enqueue(new Leaf('e', 1000));
            pq.enqueue(new Leaf('f', 900));
            pq.printPQueue();
            System.out.println(pq.size());

        }
    }
}
