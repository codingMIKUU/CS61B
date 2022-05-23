public class LinkedListDeque<T> {
    public class Node{
        private T item;
        private Node pre,next;
        public Node(T n,Node ppre,Node nnext)
        {
            item=n;
            pre=ppre;
            next=nnext;
        }
        public Node()
        {
            pre=null;
            next=null;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque()
    {
        sentinel=new Node();
        size=0;
        sentinel.next=sentinel;
        sentinel.pre=sentinel;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public int size(){
        return size;
    }
    public void addFirst(T item)
    {
        Node newlist=new Node(item,sentinel,sentinel.next);
        sentinel.next.pre=newlist;
        sentinel.next=newlist;
        size++;
    }
    public void addLast(T item)
    {
        Node newlist =new Node(item,sentinel.pre,sentinel);
        sentinel.pre.next=newlist;
        sentinel.pre=newlist;
        size++;
    }
    public T removeFirst()
    {
        if(size==0)return null;
        Node now =sentinel.next;
        T item= now.item;
        sentinel.next=now.next;
        now.next.pre=sentinel;
        size--;
        return item;
    }
    public T removeLast()
    {
        if(size==0)return null;
        Node now =sentinel.pre;
        T item= now.item;
        sentinel.pre=now.pre;
        now.pre.next=sentinel;
        size--;
        return item;
    }
    public T get(int index){
        if(index>=size)return null;
        Node ptr = sentinel;
        for (int i = 0; i <= index; i++) {
            ptr = ptr.next;
        }
        return ptr.item;
    }
    public T getRecursive(int index){
        if(index>=size)return null;
        return getRecursiveHelper(index,sentinel.next);
    }
    private T getRecursiveHelper(int now,Node ptr)
    {

        if(now==0)return ptr.item;
        return getRecursiveHelper(now-1,ptr.next);

    }
    public void printDeque(){
        Node ptr=sentinel.next;
        for(int i=0;i<size;i++)
        {
           System.out.println(ptr.item+" ");
           ptr=ptr.next;
        }
    }

}

