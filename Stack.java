class Stack {

    private int arr[];
    private int top;
    private int capacity;

    // construction of the stack
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
        //I consider the top pointer to be the last element in the stack
        //I could also consider it as the first free index
    }


    public void push(int x) {
        if (isFull()) {
            /// check whether it overflow the capacity
            System.out.println("Stack OverFlow");
            System.exit(1);
        }

        /// otherwise we can insert another item into the stack
        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    public int pop() {
        if (isEmpty()) {
            /// check whether it underflow the capacity
            System.out.println("STACK EMPTY");
            System.exit(1);
        }
        /// otherwise we can delete the last item in the stack and decrease the top pointer
        return arr[top--];
    }

    public int getSize() {
        return top + 1;
    }
    public int peek(){
        return arr[top];
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == capacity - 1;
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + ", ");
        }
    }
}