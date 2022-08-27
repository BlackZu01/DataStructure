public class Node {
    String data;
    Node next = null;

    public Node (String data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "[data: " +this.data+ " next: " +this.next+ "]";
    }
}