// John Clark
// Project 1: StackInterface3
// I did not copy code from other people or sources other than our CIS-221 textbook.
// I did not use any AI software to help write code.

/**
 * Implements StackInterface3 by filling array from the bottom to the top as necessary.
 * Moves items in array as necessary to create more space for each stack.
 * @author John Clark
 * @version 1
 */
public class TripleStack<T> implements StackInterface3<T>{
    protected final int DEFCAP = 100;
    protected final int NumOfStacks = 3;
    protected int maxSize;
    protected T[] elements;

    protected int[] bottomIndicies = {-1,-1,-1};
    protected int[] topIndicies = {-1,-1,-1};

    @SuppressWarnings("unchecked")
    public TripleStack(){
        maxSize = DEFCAP;
        elements = (T[]) new Object[maxSize];
    }

    @SuppressWarnings("unchecked")
    public TripleStack(int maxSize){
        this.maxSize = maxSize;
        elements = (T[]) new Object[maxSize];
    }

    public void push(T element,int numStack){
        // Throws an exception if the selected stack is full
        // Otherwise pushes element at the top of the chosen stack
        // Pushes elements of stacks above it to the right to make room

        if (!isFull(numStack)){
            int newTopIndex = topIndicies[numStack-1]+1;
            
            for(int i = maxSize-1;i>newTopIndex;i--){
                elements[i] = elements[i-1];
            }
            elements[newTopIndex] = element;

            for(int i = numStack-1;i<NumOfStacks;i++){
                topIndicies[i]++;
            }
            for(int i = numStack;i<NumOfStacks;i++){
                bottomIndicies[i]++;
            }

        } else {
            throw new StackOverflowException("Push attempted on a full stack.");
        }
    }
    
    public void pop(int numStack){
        // Throws an exception if the selected stack is empty
        // Otherwise pops element off top of the chosen stack
        // Pushes elements of stacks above it to the left to close the gap

        if (!isEmpty(numStack)){
            int newTopIndex = topIndicies[numStack-1]-1;

            for (int i = newTopIndex+1;i<maxSize-1;i++){
                elements[i]  = elements[i+1];
            }
            
            for(int i = numStack-1;i<NumOfStacks;i++){
                topIndicies[i]--;
            }
            for(int i = numStack;i<NumOfStacks;i++){
                bottomIndicies[i]--;
            }
        } else {
            throw new StackUnderflowException("Pop attempted on an empty stack.");
        }
    }

    public T top(int numStack){
        // Throws an exception if the selected stack is empty
        // Otherwise returns element at the top of selected stack
        if (!isEmpty(numStack)){
            return elements[topIndicies[numStack-1]];
        } else {
            throw new StackUnderflowException("Top attempted on empty stack.");
        }
    }

    public boolean isFull(int numStack){
        // Retuns true if the selected stack is full
        return (topIndicies[NumOfStacks-1]==maxSize-1);
    }

    public boolean isEmpty(int numStack){
        // Returns true if the selected stack is empty
        return (topIndicies[numStack-1]-bottomIndicies[numStack-1]==0);
    }

    // Application Program to test stack implementation.
    public static void main(String[] args){

        // Test 1
        TripleStack<String> myStacks = new TripleStack<String>(12);
        
        myStacks.push("Red",3);
        myStacks.push("Blue",3);
        myStacks.push("Yellow",3);

        System.out.println("Is stack 1 empty? "+myStacks.isEmpty(1));
        System.out.println("Is stack 2 empty? "+myStacks.isEmpty(2));
        System.out.println("Is stack 3 empty? "+myStacks.isEmpty(3));

        // Test 2
        //System.out.println(myStacks.top(1));

        // Test 3
        myStacks.push("Green Beans",2);
        myStacks.push("Orange",1);
        myStacks.push("Carrot",2);
        myStacks.push("Peas",2);
        myStacks.push("Apple", 1);
        myStacks.push("Pear",1);
        myStacks.push("A",1);
        myStacks.push("Office",2);
        myStacks.push("2",3);

        System.out.println("Is stack 1 full? "+myStacks.isFull(1));
        System.out.println("Is stack 2 full? "+myStacks.isFull(2));
        System.out.println("Is stack 3 full? "+myStacks.isFull(3));
        
        // Test 4
        System.out.println(myStacks.top(1));
        System.out.println(myStacks.top(2));
        System.out.println(myStacks.top(3));

        // Test 5
        //myStacks.push("Watermelon",1);

        // Test 6
        TripleStack<Integer> intStacks = new TripleStack<Integer>();

        intStacks.push(2,2);
        intStacks.push(3,1);
        intStacks.push(7,1);
        intStacks.push(100,3);
        intStacks.push(143,3);
        intStacks.push(4,2);
        intStacks.push(9,1);
        intStacks.push(174,3);
        
        System.out.println("Top of stack 1: "+intStacks.top(1));
        System.out.println("Top of stack 2: "+intStacks.top(2));
        System.out.println("Top of stack 3: "+intStacks.top(3));

        // Test 7
        intStacks.pop(1);
        intStacks.pop(2);
        intStacks.pop(1);

        System.out.println("Top of stack 1: "+intStacks.top(1));
        System.out.println("Top of stack 2: "+intStacks.top(2));
        System.out.println("Top of stack 3: "+intStacks.top(3));

        // Test 8
        //intStacks.pop(2);
        //intStacks.pop(2);

        // Test 9
        //intStacks.pop(1);
        //System.out.println(intStacks.top(1));
    }
}