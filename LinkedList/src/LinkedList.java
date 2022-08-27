public class LinkedList {
    
    Node Root;
    Node tail;

    public LinkedList () {
        this.Root = null;
        this.tail = null;
    }

    public void AddNode (String data) {
        Node node = new Node(data);

        if (this.Root == null) {
            this.Root = node;
            this.tail = node;

        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void EscribirLista () {
        Node p = this.Root;

        while (p != null) {
            System.out.print(p.data+ " -> ");
            p = p.next;
        }
        System.out.println("null");
    }
}