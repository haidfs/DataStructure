package LinkList.SingleLinkList;

import java.util.Stack;

/*
    1、单链表的创建和遍历
　　2、求单链表中节点的个数
　　3、查找单链表中的倒数第k个结点（剑指offer，题15）
　　4、查找单链表中的中间结点
　　5、合并两个有序的单链表，合并之后的链表依然有序【出现频率高】（剑指offer，题17）
　　6、单链表的反转【出现频率最高】（剑指offer，题16）
　　7、从尾到头打印单链表（剑指offer，题5）
　　8、判断单链表是否有环
　　9、取出有环链表中，环的长度
　　10、单链表中，取出环的起始点（剑指offer，题56）。本题需利用上面的第8题和第9题。
　　11、判断两个单链表相交的第一个交点（剑指offer，题37）
 */
public class LinkList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head;//头节点
    Node current;//当前节点

    //单链表的添加元素
    public LinkList add(int data) {
        if (head == null) {
            head = new Node(data);
            current = head;
        } else {
            current.next = new Node(data);
            current = current.next;
        }
        return this;
    }

    //单链表添加节点，用于创建单向循环链表
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (head == null) {
            head = node;
            current = head;
        } else {
            current.next = node;
            current = current.next;
        }
    }

    //单链表遍历打印
    public void print(Node head) {
        if (head == null) {
            return;
        }
        current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    //2、获取链表长度
    public int getLength(Node head) {
        if (head == null) {
            return 0;
        }
        int length = 0;
        current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    //3、查找链表的倒数第k个节点 基本思路：复制一个头节点current，先走k步，然后让他与头节点一起移动，那么current到尾部的时候，头节点的位置即为倒数第k个节点
    public Node getInverseKNode(Node head, int k) {
        int length = this.getLength(this.head);
        if (k <= 0 || k > length) {
            return null;
        }
        current = head;
        for (int i = 0; i < k; i++) {
            current = current.next;
        }
        while (current != null) {
            head = head.next;
            current = current.next;
        }
        return head;
    }

    //4、获取链表的中间节点，一样的利用一个辅助指针，辅助指针步长为2，头指针步长为1，辅助指针到尾部时，头指针所指元素即是中间元素
    //得到的是n/2-1个节点，需要注意的是链表长度为0,1,2时的处理
    public Node getMidNode(Node head) {
        //一般不要写head.next.next这样的式子，因为如果head.next为空，在if判断时就会触发空指针异常。
        if (head == null || head.next == null) {
            throw new RuntimeException("Your list's length is less than 2!");
        }
        current = head;
        while (current != null && current.next != null) {
            //如果只能再走一步，就break
            if (current.next.next == null) {
                break;
            }
            current = current.next.next;
            head = head.next;
        }
        return head;
    }

    //5、合并两个有序链表
    public Node mergeLinkList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node head;
        Node current;
        if (head1.data < head2.data) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                current = current.next;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }
        if (head2 != null) {
            current.next = head2;
        }
        if (head1 != null) {
            current.next = head1;
        }
        return head;

    }

    //6、单链表的反转:将原本的列表取出，每次插入到一个新链表里面去??？？单链表的反转还有待学习
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node current = head;
        Node next = null; //定义当前结点的下一个结点
        Node reverseHead = null; //反转后新链表的表头

        while (current != null) {
            next = current.next; //暂时保存住当前结点的下一个结点，因为下一次要用

            current.next = reverseHead; //将current的下一个结点指向新链表的头结点
            reverseHead = current;

            current = next; // 操作结束后，current节点后移
        }

        return reverseHead;
    }

    //7、从尾到头打印单链表，即逆序打印单链表。栈式打印，最简单地方法就是递归，递归的本质即是栈
    public void reversePrint1(Node head) {
        if (head == null) {//退出递归的条件
            return;
        }
        reversePrint1(head.next);
        System.out.print(head.data + " ");
    }

    //7、第二种方式，调用Java的栈
    public void reversePrint2(Node head) {
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();//新建一个栈
        Node current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        while (stack.size() > 0) {
            System.out.print(stack.pop().data + " ");
        }
        System.out.println("");
    }

    //8、判断单链表是否有环，与获取表的中间节点一样，新建两个node的辅助变量，一个一步，一个两步，如果相遇则有环。
    public boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }
        Node first = head;
        Node second = head;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }

    //返回值为Node,这种方法得出了一定在环中的一个节点，但不一定是环的头节点，可能是也可能不是
    public Node hasCycleNode(Node head) {
        if (head == null) {
            return null;
        }
        Node first = head;
        Node second = head;
        while (second != null && second.next != null) {
            second = second.next.next;
            first = first.next;
            if (first == second) {
                return first;
            }
        }
        return null;
    }

    //9、取出有环链表中，环的长度.首尾成环与 第二个节点与尾节点成环 的情况是不一样的，所以获取环的长度，入参需要是一定在环中的一个节点
    //这个参数由Node hasCycleNode(Node head)得到
    public int getCycleLength(Node node) {
        if (node == null) {
            return 0;
        }
        int length = 0;
        Node current = node;
        while (current != null) {
            current = current.next;
            length++;
            if (current == node) {
                return length;
            }
        }
        return 0;

    }

    public Node getCycleStart(Node head, int cycleLength) {
        if (head == null) {
            return null;
        }
        Node first = head;
        Node second = head;

        while (cycleLength > 0) {
            second = second.next;
            cycleLength--;
        }
        while (first != null && second != null) {
            if (first.data == second.data) {//先判断再后移，因为会有环长度与链表长度相同的情况
                return first;
            }
            first = first.next;
            second = second.next;

        }
        return null;
    }


    //11、判断两个单链表相交的第一个交点。不要遍历比较来判断节点是否重合，时间复杂度为O(len1*len2)
    //可以简单想象下，这是一个Y型的拓扑，而不是X型的拓扑。类似于先从尾部找起来，所以调用栈，最后一个相同的就是结果。
    //这里调用了两个辅助栈，时间复杂度和空间复杂度都是O(len1+len2).
    public Node getFirstCommonNode1(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node current1 = head1;
        Node current2 = head2;
        Node res = null;
        //对两个链表进行压栈
        while (current1 != null) {
            stack1.push(current1);
            current1 = current1.next;
        }
        while (current2 != null) {
            stack2.push(current2);
            current2 = current2.next;
        }
        while (stack1.size() > 0 && stack2.size() > 0) {
            res = stack1.pop();
            if (res.data != stack2.pop().data) {
                break;
            }
        }
        //返回不同值节点的后一个节点，即为第一个相同节点。
        return res.next;
    }

    //11、题采用快慢指针的方式实现，先获取链表的长度，在较长的链表上先走|len1-len2|步
    public Node getFirstCommonNode2(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node shortListHead;
        Node longListHead;
        int length1 = getLength(head1);
        int length2 = getLength(head2);
        int lengthDif = 0;
        if (length1 < length2) {
            shortListHead = head1;
            longListHead = head2;
            lengthDif = length2 - length1;
        } else {
            shortListHead = head2;
            longListHead = head1;
            lengthDif = length1 - length2;
        }
        while (lengthDif > 0) {
            longListHead = longListHead.next;
            lengthDif--;
        }
        while (shortListHead != null && longListHead != null) {
            /*
            这里还是需要注意一下==和equals的区别，这里开始时想使用longListHead == shortListHead，这肯定是不行的，因为：
            1、对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等； 如果作用于引用类型的变量，则比较的是所指向的对象的地址
            2、对于equals方法，注意：equals方法不能作用于基本数据类型的变量　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
            诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
             */
            if (longListHead.data == shortListHead.data) {
                return longListHead;
            }
            longListHead = longListHead.next;
            shortListHead = shortListHead.next;
        }
        return null;
    }


    public static void main(String[] args) {
        //创建第一个有序链表
        LinkList list = new LinkList();
        System.out.println("The list's length: " + list.getLength(list.head));
        for (int i = 0; i <= 10; i = i + 2) {
            list.add(i);
        }
        System.out.println("The list is shown as follows:");
        list.print(list.head);
        System.out.println("The list's length: " + list.getLength(list.head));
        System.out.println("The list's inversed kth node: " + (list.getInverseKNode(list.head, 3)).data);
        System.out.println("The list's mid node : " + (list.getMidNode(list.head)).data);

        //创建第二个有序链表
        LinkList list1 = new LinkList();
        for (int i = 1; i < 20; i += 2) {
            list1.add(i);
        }
        System.out.println("The list1 is shown as follows:");
        list1.print(list1.head);
        //两个链表合并测试
        LinkList list2 = new LinkList();
        list2.head = list2.mergeLinkList(list.head, list1.head);
        System.out.println("The list2 is shown as follows:");
        list2.print(list2.head);
        //创建单向循环链表
        //方法一：利用重载的add方法把头节点加到尾节点后
        LinkList cycleList1 = new LinkList();
        for (int i = 0; i < 4; i++) {
            cycleList1.add(i);
        }
        cycleList1.add(cycleList1.head);
        System.out.println("The cycleList1 has cycle ? " + cycleList1.hasCycle(cycleList1.head));
        System.out.println("The list has cycle ? " + list.hasCycle(list.head));
        //方法二创建一个新类，Node.next=this.

        //单链表反转调试测试
        LinkList list4 = new LinkList();
        for (int i = 0; i < 6; i++) {
            list4.add(i);
        }
        System.out.println("The initial list4 is shown as follows:");
        list4.print(list4.head);
        System.out.println("The list4 reversePrint1 is shown as follows:");
        list4.reversePrint1(list4.head);
        System.out.println("\nThe list4 reversePrint2 is shown as follows:");
        list4.reversePrint2(list4.head);
        System.out.println("The reversed list4 is shown as follows:");
        list4.print(list4.reverseList(list4.head));

        //环的长度测试，首尾成环：与第二个节点与尾节点成环的长度判断
        int cycleLength = cycleList1.getCycleLength(cycleList1.head);
        System.out.println("The cycle length is :" + cycleLength);
        //cycleList2第二个节点与尾节点成环
        LinkList cycleList2 = new LinkList();
        Node second = null;
        for (int i = 0; i < 4; i++) {
            cycleList2.add(i);
            if (i == 1) {
                second = cycleList2.current;
            }
        }
        cycleList2.add(second);
        Node cycleNode2 = cycleList2.hasCycleNode(cycleList2.head);
        System.out.println("The cycle length is :" + cycleList2.getCycleLength(cycleNode2));
        Node cycleNode1 = cycleList1.hasCycleNode(cycleList1.head);

        //第一个链表环的起始节点是第一个节点，为0
        Node cycleList1StartNode = cycleList1.getCycleStart(cycleList1.head, cycleList1.getCycleLength(cycleNode1));
        System.out.println("The cycleList1's start node is:" + cycleList1StartNode.data);

        //第二个链表环的起始节点是第一个节点，为1
        Node cycleList2StartNode = cycleList2.getCycleStart(cycleList2.head, cycleList2.getCycleLength(cycleNode2));
        System.out.println("The cycleList2's start node is:" + cycleList2StartNode.data);


        //创建两个相交链表进行比对。改写原本的public void add为public Node add，方便方法链的调用。
        LinkList lista = new LinkList();
        LinkList listb = new LinkList();
        lista.add(1).add(2).add(3).add(5).add(6).add(7);
        listb.add(0).add(4).add(5).add(6).add(7);
        System.out.println("The lista is shown as follows:");
        lista.print(lista.head);
        System.out.println("The listb is shown as follows:");
        listb.print(listb.head);
        int a = lista.getFirstCommonNode1(lista.head, listb.head).data;
        System.out.println("The first common node's value is :" + a);
        int b = lista.getFirstCommonNode2(lista.head, listb.head).data;
        System.out.println("The first common node's value is :" + b);
    }
}
