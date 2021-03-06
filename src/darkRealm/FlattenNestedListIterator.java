package darkRealm;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class FlattenNestedListIterator {

//  #341. Flatten Nested List Iterator
//  Given a nested list of integers, implement an iterator to flatten it.
//  Each element is either an integer, or a list -- whose elements may also be integers or other lists.
//      Example 1:
//  Given the list [[1,1],2,[1,1]],
//  By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
//  Example 2:
//  Given the list [1,[4,[6]]],
//  By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].

  public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  public static class NestedIterator implements Iterator<Integer> {
    Stack<ListIterator<NestedInteger>> stack;

    public NestedIterator(List<NestedInteger> nestedList) {
      stack = new Stack<>();
      stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
      hasNext();
      return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
      while (!stack.isEmpty()) {
        ListIterator<NestedInteger> nit = stack.peek();
        if (!nit.hasNext()) stack.pop();
        else {
          nit = stack.peek();
          NestedInteger n = nit.next();
          if (n.isInteger()) {
            nit.previous();// resuming the top of stack to have integer, so next() works
            return true;
          }
          stack.push(n.getList().listIterator()); // pushing the list iterator on stack
        }
      }
      return false;
    }
  }


  public static void main(String[] args) {

  }
}