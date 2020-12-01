// the class of activation records of M() function for <assignmentList>

class ARMassignmentList extends ARassignmentList
{

    void M() // function to interpret this assignment list
    {
        Parser.assignment();
        Parser.assignmentList();
    }
}