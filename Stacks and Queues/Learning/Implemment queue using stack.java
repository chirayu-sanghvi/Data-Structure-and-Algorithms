/*
Coding Ninja: https://www.codingninjas.com/studio/problems/day-25-:-queue-using-stack_799482?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=SUBMISSION
Leet Code: https://leetcode.com/problems/implement-queue-using-stacks/

Problem statement
Implement a queue data structure which follows FIFO(First In First Out) property, using only the instances of the stack data structure.



Note:
1. To implement means you need to complete some predefined functions, which are supported by a normal queue such that it can efficiently handle the given input queries which are defined below.


2. The implemented queue must support the following operations of a normal queue: 

a. enQueue(data) : This function should take one argument of type integer and place the integer to the back of the queue.

b. deQueue(): This function should remove an integer from the front of the queue and also return that integer. If the queue is empty, it should return -1.

c. peek(): This function returns the element present in the front of the queue. If the queue is empty, it should return -1.

d. isEmpty(): This function should return true if the queue is empty and false otherwise.


3. You will be given q queries of 4 types:

a. 1 val - For this type of query, you need to insert the integer val to the back of the queue.

b. 2 - For this type of query, you need to remove the element from the front of the queue, and also return it.

c. 3 - For this type of query, you need to return the element present at the front of the queue(No need to remove it from the queue).

d. 4 - For this type of query, you need to return true if the queue is empty and false otherwise.


4. For every query of type:

a. 1, you do not need to return anything.

b. 2, return the integer being deQueued from the queue.

c. 3, return the integer present in the front of the queue.

d. 4, return “true” if the queue is empty, “false” otherwise.
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
    static class Queue {
        // Define the data members(if any) here.
        Stack<Integer> input;
        Stack<Integer> output;
        Queue() {
            // Initialize your data structure here.
            input = new Stack<Integer>();
            output = new Stack<Integer>();
        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            while(!input.isEmpty()){
                output.push(input.peek());
                input.pop();
            }
            input.push(val);
            while(!output.isEmpty()){
                input.push(output.peek());
                output.pop();
            }
        }

        int deQueue() {
            if(!input.isEmpty())
            return input.pop();
            return -1;
            // Implement the dequeue() function.
        }

        int peek() {
            if(!input.isEmpty())
            return input.peek();
            return -1;
            // Implement the peek() function here.
        }

        boolean isEmpty() {
            return input.isEmpty();
            // Implement the isEmpty() function here.
        }
    }
}
