package com.softwareengineering.accountmanager.model.cache;

/**
 * Created by kehanyang on 15/6/14.
 */
public class CacheList<E> {

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E item) {
            this.item = item;
            this.prev = null;
            this.next = null;
        }

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    protected Node<E> head = null;

    protected Node<E> last = null;

    public Node<E> getHead() {
        return head;
    }

    public Node<E> getLast() {
        return last;
    }

    public Node<E> insertAfter(Node<E> prev, E item) {
        if (prev == null) {
            return null;
        }
        Node<E> next = prev.next;
        prev.next = new Node<E>(prev, item, next);
        if (next != null) {
            next.prev = prev.next;
        } else {
            // This situation indicate that prev == last
            last = prev.next;
        }
        return prev.next;
    }

    public Node<E> insertBefore(Node<E> next, E item) {
        if (next == null) {
            return null;
        }
        Node<E> prev = next.prev;
        next.prev = new Node<E>(prev, item, next);
        if (prev != null) {
            prev.next = next.prev;
        } else {
            // This situation indicate that next == head
            head = next.prev;
        }
        return next.prev;
    }

    public Node<E> addFirst(E item) {
        if (head == null) {
            last = head = new Node<E>(item);
            return head;
        } else {
            return insertBefore(head, item);
        }
    }

    public Node<E> addFirst(Node<E> node) {
        node.next = head;
        head = node;
        return node;
    }

    public Node<E> addLast(E item) {
        if (last == null) {
            last = head = new Node<E>(item);
            return last;
        } else {
            return insertAfter(last, item);
        }
    }

    public Node<E> addLast(Node<E> node) {
        node.prev = last;
        last = node;
        return node;
    }

    public Node<E> remove(Node<E> node) {
        if (node == null) {
            return null;
        }
        if (node == head) {
            head = node.next;
        }
        if (node == last) {
            last = node.prev;
        }
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        return node;
    }

    public Node<E> removeFirst() {
        return remove(head);
    }

    public Node<E> removeLast() {
        return remove(last);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> node = head;
        while (node != null) {
            result.append(node.item);
            if (node.next != null) {
                result.append(", ");
            }
            node = node.next;
        }
        return result.append("]").toString();
    }

}