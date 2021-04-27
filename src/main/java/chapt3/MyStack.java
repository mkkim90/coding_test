package chapt3;

import java.util.EmptyStackException;

/**
 * pop() : 스택에서 제거
 * push(item) : item 하나를 스택의 가장 윗 부분에 추가
 * peek() : 스택이 비어 있을때에 true를 반환
 * @param <T>
 */
public class MyStack<T> {
    // inner class
    private static class StackNode<T> {
        private T data;
        private StackNode<T> next;
        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;
    public T pop() {
        if (top == null) throw new EmptyStackException();
        T item = top.data;
        top = top.next;
        return item;
    }

    public void push(T item) {
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public T peek() {
        if (top == null) throw new EmptyStackException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}
