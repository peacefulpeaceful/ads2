public class MyStack<T> {
    private T[] arr;
    private int capacity;
    private int top;

    @SuppressWarnings("unchecked")
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.arr = (T[]) new Object[capacity];
        this.top = -1;
    }

    public void push(T value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = value;
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return null;
        }
        return arr[top--];
    }

    public T peek() {
        if (top == -1) {
            System.out.println("Stack is Empty");
            return null;
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}