package programming;


import com.sun.istack.internal.NotNull;

/**
 * Created by admin on 2017/4/1.
 * 单链表反转
 */
public class ReverseSingledLinkedList {

    /**
     * 非递归解法：
     * 反转:把preNode变量存储到 head 的next属性中
     * 1.缓存原下一节点到tempNode;
     * 2.设置preNode为新下一节点;
     * 3.更新head为新的preNode;
     * 4.更新tempNode为新的当前节点;
     *
     * @param head 当前节点,入参节点要非空校验或使用注解限定
     * @return preNode 反转后的头节点，也就是原尾节点
     */
    public static ListNode reverse(ListNode head) {
        //记录前一个节点的变量
        ListNode preNode = null;
        //记录后一个节点的变量
        ListNode tempNode;

        //当前节点 存在后续节点才要反转
        do {
            tempNode = head.getNext();
            head.setNext(preNode);
            preNode = head;
            head = tempNode;
        } while (null != head);
        return preNode;
    }


    /**
     * 递归解法：
     * 从后一个节点开始向外返回，最后的节点为新的头节点
     *
     * @param head
     * @return
     */
    /*public static ListNode[] recursiveReverse1(ListNode head) {
    ListNode nextNode;
    ListNode[] nodes = {null, head};
    if (null != head && null != (nextNode = head.getNext())) {
    nodes[0] = nextNode;
    if (null != nextNode.getNext()) {
    nodes = recursiveReverse1(nextNode);
    //续尾
    nodes[0].setNext(head);
    //断原来的尾
    head.setNext(null);
    //存进nodes并返回
    nodes[0] = head;
    return nodes;
    } else {
    nextNode.setNext(head);
    //新的头节点
    nodes[1] = nextNode;
    //head原来的下一个没有了,现在head是尾了
    head.setNext(null);
    nodes[0] = head;
    return nodes;
    }
    }
    return nodes;
    }*/
    public static ListNode[] recursiveReverse2(ListNode head) {
        ListNode nextNode;
        ListNode[] nodes = {null, head};
        if (null != head && null != (nextNode = head.getNext())) {
            nodes[0] = nextNode;
            if (null != nextNode.getNext()) {
                nodes = recursiveReverse2(nextNode);
            } else {
                //新的头节点
                nodes[1] = nextNode;
            }
            //续尾
            nodes[0].setNext(head);
            //断原来的尾
            head.setNext(null);
            //存进nodes并返回
            nodes[0] = head;
            return nodes;
        }
        return nodes;
    }

    public static ListNode recursiveReverse1(ListNode head) {
        ListNode nextNode;
        if (null != head && null != (nextNode = head.getNext())) {
            ListNode newHeadNode = recursiveReverse1(nextNode);
            //续尾
            nextNode.setNext(head);
            //断原来的尾
            head.setNext(null);
            return newHeadNode;
        }
        return head;
    }

    /**
     * 反转递归思想：递拆线，归接线，返回头节点归返回头节点，连线归连线
     *
     * @param head
     * @return
     */
    public static ListNode recursiveReverse(ListNode head) {
        ListNode nextNode;
        if (null == head || null == (nextNode = head.getNext())) {
            return head;
        }
        //至少有两个节点
        head.setNext(null);
        ListNode newHeadNode = recursiveReverse(nextNode);
        //接线要在递归之后，不然会破坏原来的递归路线
        nextNode.setNext(head);
        return newHeadNode;
    }

    /**
     * 遍历打印单链表
     *
     * @param head
     */
    public static void showNodes(@NotNull ListNode head) {
        System.out.print("\n从头遍历依次是：");
        do {
            System.out.print(head.getVal());
        } while (null != (head = head.getNext()));
    }

    public static void main(String[] args) {
        ListNode nextNode = null;
        ListNode headNode = null;
        //初始测试数据
        for (int i = 5; i > 0; i--) {
            headNode = new ListNode(i);
            headNode.setNext(nextNode);
            nextNode = headNode;
        }
        showNodes(headNode);
        //反转
        /*ListNode newHeadNode = reverse(headNode);
        showNodes(newNodes);*/

        /*ListNode[] newNodes = recursiveReverse2(headNode);
        showNodes(newNodes[1]);*/

        ListNode newHeadNode = recursiveReverse1(headNode);
        showNodes(newHeadNode);
    }

}

