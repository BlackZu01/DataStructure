public class App {
    public static void main(String[] args) throws Exception {
        
        LinkedList lista = new LinkedList();

        // Prueba de la clase Node
        Node node = new Node("Pedrinho");
        node.next = new Node("Megumin");

        lista.AddNode("Moisés");
        lista.AddNode("Luis");
        lista.AddNode("Maria");
        lista.AddNode("Francesca");
        lista.AddNode("Gabriela");
        lista.AddNode("Steven");

        lista.ShowList();
        System.out.println(node);
    }
}