public class Main {
    public static void main(String[] args) {
//        Stack st = new Stack(7);
//        st.display();
//        st.push(9);
//        st.push(8);
//        st.push(7);
//        st.display();
//        System.out.println(st.pop());
//        st.display();
        //System.out.println(st.peek());
//        Queue q = new Queue(8);
//        q.display();
//        q.remove();
//        q.add(5);
//        q.add(6);
//        q.add(7);
//        q.display();
//        System.out.println(q.remove());
////        q.display();
//        DynamicStack dst = new DynamicStack(5);
//        dst.push(9);
//        dst.push(8);
//        dst.push(7);
//        dst.push(6);
//        dst.push(8);
//        dst.push(6);
//        dst.display();
//        System.out.println(dst.pop());
//        dst.display();
//        System.out.println(dst.arr.length);
        Circularqueue que = new Circularqueue(5);
        que.insert(6);
        que.insert(7);
        que.insert(8);
        que.insert(9);
        que.insert(1);

        que.display();
        System.out.println(que.remove());
        que.display();
        que.insert(14);
        que.display();



    }
}
