public class Practice {
    private static void print(Node head){
        Node cur = head;
        for(cur = head;cur != null;cur = cur.next){
            System.out.printf("%d-->",cur.val);
        }
        System.out.println("null");
    }
    public static Node test(){
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        n1.random = null;
        n2.random = n1;
        n3.random = n3;
        n4.random = n3;
        return n1;
    }
    //复制链表
    public static Node copyList(Node head){
        Node cur = head;
        while(cur != null){
            Node next = cur.next;
            Node node = new Node(cur.val);
            cur.next = node;
            node.next = next;
            cur = next;
        }
        //复制random
        cur = head;
        Node last = cur.next;
        while(cur != null && last != null){
            if(cur.random != null) {
                    last.random = cur.random.next;
            }else{
                last.random = null;
            }
            cur = cur.next;
            //2
//            if(cur.random != null) {
//                cur.next.random = cur.random.next;
//            }else{
//                cur.next.random = null;
//            }
//            cur = cur.next.next;
        }
        //将两条链表分开
        Node resultHead = head;
        cur = head;
        while(cur != null){
            Node result = cur.next;
            cur.next = result.next;
            if(cur.next != null) {
                result.next = cur.next.next;
            }else{
                result.next = null;
            }
            cur = cur.next;

        }
        return resultHead;
    }



    public static void main(String[] args) {
        print(copyList(test()));
    }
}
