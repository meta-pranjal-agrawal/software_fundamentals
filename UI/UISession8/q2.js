// remove repeated characters

var iterator;
var flag = 0;
var stringInput = prompt("enter the input string")

for (iterator = 0; iterator < stringInput.length - 1; iterator++) {
    var startPosition = iterator;
    while (stringInput.charAt(iterator) == stringInput.charAt(iterator + 1)) {
        flag = 1;
        iterator++;
    }
    if (flag == 1) {
        var substring = stringInput.substr(startPosition, iterator - startPosition + 1);
        stringInput = stringInput.replace(substring, '');
        iterator = -1;
        flag = 0;
    }
}

console.log(stringInput);

// queue implementation
class Queue {
    constructor() {
        this.items = [];
    }
    enqueue(element) {
        this.items.push(element);

    }
    dequeue() {
        this.items.shift();
    }
    getFront() {
        console.log(this.items[0]);
    }
    getRear() {
        console.log(this.items[this.items.length - 1]);
    }
    print() {
        console.log(this.items);
    }
}
var queue = new Queue();
queue.enqueue(4);
queue.enqueue(5);
queue.dequeue();
queue.print();

// stack implementation

class Stack {
    constructor() {
        this.items = [];
    }
    push(element) {
        this.items.push(element);
    }
    pop() {
        this.items.pop();
    }
    peep() {
        console.log(this.items[this.items.length - 1]);
    }
}

var stack = new Stack();
stack.push(2);
stack.push(4);
stack.push(5);
stack.pop();
stack.peep();



//repeatify

String.prototype.repeatify = function(numberOfTimes) {
    if (numberOfTimes <= 0) {
        console.log("cannot be negative");
        return -1;
    }
    if (this.length <= 0) {
        console.log("no string")
        return -1;
    }
    var i;
    var newString = "";
    for (i = 0; i < numberOfTimes; i++) {
        newString = newString + this;
    }
    return newString;

}
var input = prompt("enter input");
var times = parseInt(prompt("enter number of times"))
console.log(input.trim().repeatify(times))