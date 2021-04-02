import java.io.*;

// 1. You are given the code of our CustomStack class which mimics the java.util.Stack class.
// 2. Here is the list of functions that are written in the class
//     2.1. push -> Accepts new data if there is space available in the underlying array or 
//      print "Stack overflow" otherwise
//      2.2. pop -> Removes and returns last data if available or print "Stack underflow" 
//      otherwise and returns -1
//      2.3. top -> Return last data if available or print "Stack underflow" otherwise and 
//       returns -1
//      2.4. size -> Returns the number of elements available in the stack
//      2.5. display -> Print the elements of stack in LIFO manner (space-separated) 
//      ending with a line-break.
// 3. Input and Output are managed for you.
// 4. You are required to change the body of push function to accept the element even when the data array is completely full. In that case, you are required to reallocate the data array (to twice it's size). You should not print "Stack overflow" ever.

public class DynamicStack {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack st = new CustomStack(n);

        String str = br.readLine();
        while (str.equals("quit") == false) {
            if (str.startsWith("push")) {
                int val = Integer.parseInt(str.split(" ")[1]);
                st.push(val);
            } else if (str.startsWith("pop")) {
                int val = st.pop();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("top")) {
                int val = st.top();
                if (val != -1) {
                    System.out.println(val);
                }
            } else if (str.startsWith("size")) {
                System.out.println(st.size());
            } else if (str.startsWith("display")) {
                st.display();
            }
            str = br.readLine();
        }
    }
}