/*
Coding Ninja Link: https://www.codingninjas.com/studio/problems/stack-using-queue_795152?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
Leet Code Link: https://leetcode.com/problems/implement-stack-using-queues/
Problem Statement: 
Implement a Stack Data Structure specifically to store integer data using two Queues.
There should be two data members, both being Queues to store the data internally. You may use the inbuilt Queue.

Implement the following public functions :

1. Constructor:
It initializes the data members(queues) as required.

2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.

3. pop() :
It pops the element from the top of the stack and, in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.

4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.

5. size() :
It returns the size of the stack at any given instance of time.

6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.
Operations Performed on the Stack:
Query-1(Denoted by an integer 1): Pushes an integer data to the stack. (push function)

Query-2(Denoted by an integer 2): Pops the data kept at the top of the stack and returns it to the caller. (pop function)

Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the top of the stack but doesn't remove it, unlike the pop function. (top function)

Query-4(Denoted by an integer 4): Returns the current size of the stack. (size function)

Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the stack is empty or not. (isEmpty function)
Example
Operations: 
1 5
1 10
2
3
4

Enqueue operation 1 5: We insert 5 at the back of the queue.
  Queue: [5]

Enqueue operation 1 10: We insert 10 at the back of the queue.
  Queue: [5, 10]

Dequeue operation 2: We remove the element from the front of the queue, which is 5, and print it.
  Output: 5
  Queue: [10]

Peek operation 3: We return the element present at the front of the queue, which is 10, without removing it.
  Output: 10
  Queue: [10]

IsEmpty operation 4: We check if the queue is empty.
  Output: False
  Queue: [10]

*/

import java.util.*;
public class Solution{
    static class Stack {
        // Define the data members.
    Queue<Integer> q;
        public Stack() {
            // Implement the Constructor.
            q = new LinkedList<>();

        }

        /*----------------- Public Functions of Stack -----------------*/

        public int getSize() {
            // Implement the getSize() function.
            return q.size();
        }

        public boolean isEmpty() {
            // Implement the isEmpty() function.
            return q.isEmpty();
        }

        public void push(int element) {
            // Implement the push(element) function.
            q.add(element);
            for(int i=0;i<q.size()-1;i++){
                q.add(q.remove());
            }
        }

        public int pop() {
            // Implement the pop() function.
            if(!q.isEmpty())
            return q.remove();
        return -1;
        }

        public int top() {
            // Implement the top() function.
            if(!q.isEmpty())
            return q.peek();
            return -1;
        }
    }
}
