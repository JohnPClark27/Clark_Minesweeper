// John Clark
// Project 1: StackInterface3
// I did not copy code from other people or sources other than our CIS-221 textbook.
// I did not use any AI software to help write code.

/**
 * Interface for organizing 3 stacks in 1 array.
 * @author John Clark
 * @version 1
 */
public interface StackInterface3<T> {

    /**
     * Pushes element onto chosen stack.
     * 
     * Preconditions:
     *  - Object element should be of the same type as the stack.
     *  - numStack must be an integer from 1 to 3.
     * 
     * Postconditions:
     *  - Inserts element into array corresponding to numStack.
     * 
     * @param element
     * @param numStack
     * @throws StackOverflowException
     */
    void push(T element,int numStack) throws StackOverflowException;

    /**
     * Pops element off the top of the selected stack.
     * 
     * Preconditions:
     *  - numStack must be an integer from 1 to 3.
     * 
     * Postconditions:
     *  - Removes item off of top of desired stack.
     * 
     * @param numStack
     * @throws StackUnderflowException
     */
    void pop(int numStack) throws StackUnderflowException;

    /**
     * Returns the top value of the selected stack.
     * 
     * Preconditions:
     *  - numStack must be an integer from 1 to 3.
     * 
     * Postconditions:
     *  - Returns the element on top of the desired stack.
     * 
     * @param numStack
     * @return top element of desired stack.
     * @throws StackUnderflowException
     */
    T top(int numStack) throws StackUnderflowException;

    /**
     * Checks if the selected stack is empty.
     * 
     * Preconditions:
     *  - numStack must be an integer from 1 to 3.
     * 
     * Postconditions:
     *  - Returns true if the stack is empty.
     * 
     * @param numStack
     * @return boolean value of true if the stack is empty.
     */
    boolean isEmpty(int numStack);

    /**
     * Checks if the desired stack is full.
     * 
     * Preconditions:
     *  - numStack must be an integer from 1 to 3.
     * 
     * PostConditions:
     *  - Returns true if the stack is full.
     * 
     * @param numStack
     * @return boolean value of true if the stack is full.
     */
    boolean isFull(int numStack);
}