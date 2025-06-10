import java.util.ArrayDeque;

public class StackDemo {

    static class CustomStack {
        ArrayDeque<Integer> container = new ArrayDeque<>();

        void insert(int data) {
            container.push(data);
            System.out.println("Inserted: " + data);
        }

        int remove() {
            if (!container.isEmpty()) {
                int top = container.pop();
                System.out.println("Removed: " + top);
                return top;
            } else {
                System.out.println("Stack is empty!");
                return -1;
            }
        }

        int topElement() {
            if (!container.isEmpty()) {
                int peekVal = container.peek();
                System.out.println("Top element: " + peekVal);
                return peekVal;
            } else {
                System.out.println("Stack is empty!");
                return -1;
            }
        }

        boolean isStackEmpty() {
            boolean status = container.isEmpty();
            System.out.println("Is stack empty? " + status);
            return status;
        }
    }

    public static void main(String[] args) {
        CustomStack cs = new CustomStack();

        cs.insert(100);
        cs.insert(200);
        cs.insert(300);

        cs.topElement();

        cs.remove();
        cs.remove();

        cs.isStackEmpty();
    }
}
