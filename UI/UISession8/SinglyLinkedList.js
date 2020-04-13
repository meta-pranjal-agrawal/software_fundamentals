class Node {
    constructor(element) {
        this.element = element;
        this.next = null;
    }
}
class SinglyLinkedList {
    constructor() {
        this.head = null;
        this.size = 0;
    }
    add(element) {
        var node = new Node(element);
        var current;
        if (this.head == null) {
            this.head = node;
        } else {
            current = this.head;

            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        this.size++;
    }
    printNodes() {
        var curr = this.head;
        while (curr != null) {
            console.log(curr.element);
            curr = curr.next;
        }

    }
    remove(element) {
        var current = this.head;
        var previousNode = null;

        while (current != null) {

            if (current.element == element) {
                if (previousNode == null) {
                    this.head = current.next;
                } else {
                    previousNode.next = current.next;
                }
                this.size--;

            }
            previousNode = current;
            current = current.next;
        }

    }
}
var sll = new SinglyLinkedList();
sll.printNodes();
sll.add(10);
sll.add(20);
sll.add(30);
sll.add(10);
sll.remove(10);
sll.printNodes();