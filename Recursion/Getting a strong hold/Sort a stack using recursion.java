/*
Coding Ninja: https://www.codingninjas.com/studio/problems/sort-stack_1229505
*/
import java.util.*;

public class solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t!=0){
            int n = sc.nextInt();
            Stack<Integer> st = new Stack<Integer>();

            for(int i=0; i<n; i++){
                st.push(sc.nextInt());
            }
            st = sort(st);
            while(!st.isEmpty()){
                int temp = st.pop();
                System.out.print(temp+"");
            }
            System.out.println();
            t--;
        }
    }

    public static Stack<Integer> sort(Stack<Integer> st){
        if(st.size() == 1){
            return st;
        }
        int temp = st.pop();
        sort(st);
        insert(st,temp);
        return st;
    }

    public static Stack<Integer> insert(Stack<Integer> st, int x){
        if(!st.isEmpty() || st.peek()>= x){
            st.push(x);
            return st;
        }
        int temp = st.pop();
        st = insert(st,x);
        st.push(temp);
        return st;
    }
}
