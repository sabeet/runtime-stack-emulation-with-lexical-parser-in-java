import java.io.File;
import java.util.*;

public abstract class InterpreterStack extends ParserStack
{
	public static HashMap<String, Val> varState = new HashMap<String, Val>(); 
	              // program state, i.e., virtual memory for variables
		
	public static String argv2;

	public static void main(String argv[]) {
		// argv[0]: input file containing an assignment list
		// argv[1]: output file displaying the parse tree
		// argv[2]: output file displaying runtime stack data
		// The interpretation result will be displayed on the terminal.

		//Writing to file will for whatever reason appends to text file if text file already exists. This deletes text file if file exists
		File myObj = new File(argv[2]);
		if (myObj.delete()) {
			System.out.print(""); //took out text because debugging was over but otherwise would tell you file was successfully deleted
		} else {
			System.out.print(""); //took out text because debugging was over but otherwise it would tell you that file failed at deleting
		}

		Interpreter.main(argv); //redirected the Interpreter output to here

		argv2 = argv[2]; //making sure this variable stays accessible for ARprimary
		setIO( argv[0], argv[2] ); //setting this argv[2] prints out the output for argv[1] and i'm not sure why
		setLex();

		getToken();

//		AssignmentList assignmentList = Parser.assignmentList(); // build a parse tree
		ARassignmentList arassignmentList = new ARassignmentList(); //instantiating
		RuntimeStack.push(arassignmentList);
		arassignmentList.assignmentList();
		RuntimeStack.pop();



//		if ( ! t.isEmpty() )
//			displayln(t + " : Syntax Error, unexpected symbol where id expected");
//		else if ( ! errorFound )
//		{
//			assignmentList.printParseTree("");       // print the parse tree in linearly indented form in argv[1] file
//			assignmentList.M();              // interpret the assignment list
//			System.out.println(varState.toString()); // print the program state on the terminal
//		}

		//assignmentList.traversal(); // perform depth-first traversal from assignmentList
		//System.out.println(assignmentList);

	}
}
