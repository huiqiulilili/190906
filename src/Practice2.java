import java.util.*;

public class Practice2 {
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
    //利用Map集合
    public static Node copyList(Node head){
        Node cur = head;
        Node result = null;
        Node last = null;
        Map<Node,Node> map = new HashMap<>();
        while(cur != null){
            Node node = new Node(cur.val);
            map.put(cur,node);
            if(result == null){
                result = node;
            }else{
                last.next = node;
            }
            last = node;
            cur = cur.next;
        }
        cur = head;
        last = result;
        while(cur != null){
            last.random = map.get(cur.random);
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        print(copyList(test()));
    }
}
