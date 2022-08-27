public class LinkedList {
    Node Root;
    Node tail;

    public LinkedList () {
        this.Root = null;
        this.tail = null;
    }

    public void AddNode (String data) {
        Node node = new Node(data);

        if (this.Root != null) {
            tail.next = node;
            tail = node;
            return;
        }
        this.Root = node;
        this.tail = node;
    }

    public void ShowList () {      
        Node p = this.Root;

        while (p != null) {
            System.out.print(p.data+ " --> ");
            p = p.next;
        }
        System.out.println("null");
    }
}