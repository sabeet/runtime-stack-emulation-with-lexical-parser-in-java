import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class RuntimeStack { //we are going to use this to manage our AR childrens

    static List<AR> stack = new LinkedList<>(); //I chose LL because I haven't worked on one in a long time

    static int ARCalls  = 0; //initiate the number of function calls
    static int sizeCall = 0; //we use this to check the size changes of the stack

    public static void push(AR ar){
        ARCalls++; //increment with each call
        stack.add(ar); //add to the LL stack
        System.out.println(stack + "\n");
        System.out.println(ar.toString());
        int size = stack.size();
        if(size > sizeCall){
            sizeCall = size; //we use this to make sure sizeCall stays consistent
        }


    }

    static void pop(){
        //System.out.println(stack); good for debugging
        stack.remove(stack.size() - 1); //LL stack pop
        System.out.println(stack.size()+1);
    }

    public static void output(String argv2) throws IOException { //static variable created in interpreterStack to add argument
            //See ARprimary as it is always the first item.
        FileWriter f = new FileWriter(new File(argv2), true); //true because appending needs to happen otherwise only last result shows

        int size = stack.size();
        f.write("------------------------------------------------------------------------" + "\n");
        f.write("The total number of function calls so far = " + ARCalls + "\n");
        f.write("The maximum stack size so far = " + sizeCall + "\n");
        f.write("\n"+ "The ARs of the runtime stack will be displayed from top to bottom: " + "\n");
        int i = size - 1;
        while (i >= 0) { //we go backwards otherwise nothing prints
            f.write(stack.get(i).toString()  + "\n");
            i--;
        }

        f.close(); //close the fileWriter

    }
//breakpoints -- debugging
}
