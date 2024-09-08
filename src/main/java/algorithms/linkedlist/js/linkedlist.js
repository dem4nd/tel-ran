
class Link {
    constructor(value, next = null) {
        this.value = value
        this.next = next      
    }
}

class MyLinkedList {
    constructor() {
        this.head = null
    }

    pushToHead(value) {
        let nextHead = new Link(value, this.head)
        this.head = nextHead
    }

    pushToTail(value) {
        if (this.head == null) {
            pushToHead(value)
        } else {
          let curLink = this.head
          while (curLink.next != null)
            curLink = curLink.next

          curLink.next = new Link(value)
        }
    }

    pushToIndex(index, value) {
        // реализовать
    }

    removeFirst() {
        // реализовать
    }

    removeLast() {
        // реализовать
    }

    removeAtIndex(index) {
        // реализовать
    }

    getByIndex(index) {
        let curLink = this.head

        for(let i=0; i < index; i++) {
            curLink = curLink.next
        }

        return curLink.value
    }

    getIndexByValue(value) {
        let index = 0
        let curLink = this.head

        while(curLink != null) {
            if (curLink.value == value)
                return index
            curLink = curLink.next
            index++;
        }
        // не нашли
        return -1;
    }

    size() {
        let i = 0
        let curLink = this.head;
        while (curLink != null) {
            i++
            curLink = curLink.next
        }
        return i;
    }

    print() {
        let result = ""
        if (this.head == null) {
            result = "<empty>"
        } else {
            result = "|-> " + this.head.value.toString()
            let current = this.head.next
            while (current != null) {
                result = result + ", " + current.value.toString()
                current = current.next
            }
        }
        return result
    }
}

function main() {
    let list = new MyLinkedList()

    console.log(list.print())

    list.pushToHead(10)
    list.pushToHead(20)
    list.pushToHead(30)
    list.pushToTail(40)

    console.log(list.print())
    console.log("15 at: " + list.getIndexByValue(15).toString())
    console.log("20 at: " + list.getIndexByValue(20).toString())
}

main()