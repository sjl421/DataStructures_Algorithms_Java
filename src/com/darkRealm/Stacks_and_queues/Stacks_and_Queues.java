package com.darkRealm.Stacks_and_queues;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jayam on 12/7/2016.
 */
public class Stacks_and_Queues {
  private final static Logger dLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

  static {
    dLogger.setLevel(Level.INFO);
    dLogger.info("logger initialized  for " + Stacks_and_Queues.class);
  }


  /*  [Prob 3.5]
  * Q) To sort a stack such that samllest items are on top.
  *     Constraint is we can use only another additional temporary stack not any array.
  * A) Use 2 stack, use push & oping between 2 stacks sch that the 2nd stack is sorted in reverse order,
  *   & at the end empty the sorted temp stack in to the original stack, this will fill it in the reverse order
  *   thus making smallest element appear on the top
  *
  * @param    a MyStack object that has to be sorted, of type Integer
  * @return   same MyStack object but now sorted in ascending order
  * */
  public static MyStack SortStack(MyStack stack) {
    MyStack<Integer> minStack = new MyStack();
    int minStackWindow = 0;
    int temp, minPeek;
    while (!stack.isEmpty()) {
      int element = (int) stack.pop();
      if (minStack.isEmpty()) {
        minStack.push(element);
        dLogger.info("First insertion in minStack " + element);
      } else {
        if (element >= minStack.peek()) {
          minStack.push(element);
          dLogger.info("pushing in minStack as element " + element + " >= " + minStack.peek() + " minPeek ");
        } else { // shall empty min stack in the original stack, insert the smaller element and then push all the elements.
          while (!minStack.isEmpty() && element < minStack.peek()) { // pull all elements out of stack that will be greater than the upcoming element
            minPeek = minStack.peek();
            temp = minStack.pop();
            stack.push(temp);
            minStackWindow++;
            dLogger.info("popoing from minStack was element " + element + " < " + minPeek + " minPeek ");
          }

          // now we are ready to push the poped out element in the minStack
          minStack.push(element);
          dLogger.info("pushing the popped element into minStack as all bigger pooped out " + element);

          // now lets pull out all the minStack Elements that we pushed on to the main Stack
          while (minStackWindow > 0) {
            temp = (int) stack.pop();
            minStack.push(temp);
            minStackWindow--;
          }
        }
      }
    }

    // as the main Stack isEmptied we can pull out the elements from the minStack and push on to the main Stack (reverse)
    dLogger.info("refilling from the minStack for reverse order");
    while (!minStack.isEmpty()) {
      temp = minStack.pop();
      stack.push(temp);
    }
    return stack;
  }


  /*  [Prob 3.1]
  * Q) Describe how you could use a single array to implement 3 Stacks
  * A) will have to keep track of capacity of each stack & shift them when required,
  * when shifting a stack reduce its capacity with 1.
  *
  * @return  void
  * @param  void
  * */
  public static void ThreeStacksInArray() {
    int size = 10;
    int noOfStacks = 3;
    int s1, s2, s3; //sizes of each stack
    s1 = s2 = (int) (size / noOfStacks);
    s3 = size - (s1 + s2);  //3rd is slightly bigger
    int[] arr = new int[size];

  }
}