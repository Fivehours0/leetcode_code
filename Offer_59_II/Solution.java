package Offer_59_II;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class MaxQueue {
    private final Queue<Integer> storeData = new ArrayDeque<>();
    private final Deque<Integer> helper = new ArrayDeque<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (helper.isEmpty()) return -1;
        else return helper.peek();
    }

    public void push_back(int value) {
        while (!helper.isEmpty() && helper.peekLast() < value) {
            helper.removeLast();
            if (helper.isEmpty()) break;
        }
        helper.add(value);
        storeData.add(value);
    }

    public int pop_front() {
        if (storeData.isEmpty()) return -1;
        int value = storeData.remove();
        if (!helper.isEmpty() && helper.peek() == value) {
            helper.remove();
        }
        return value;
    }
}
