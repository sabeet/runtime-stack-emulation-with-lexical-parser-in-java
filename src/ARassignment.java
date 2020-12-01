// the class of activation records of assignment() function
// String id = LexArithArray.Id;
// LexArithArray.getToken();

class ARassignment extends AR
{
    // <assignment> --> <id> = <E> ";"
    E e;
    Assignment returnVal;

    void assignment()
    {
        if(LexArithArray.state == LexArithArray.State.Id)
        {

            String id = LexArithArray.t;
            LexArithArray.getToken();

            if( LexArithArray.state == LexArithArray.State.Assign)
            {
                LexArithArray.getToken();

                ARE are = new ARE();
                RuntimeStack.push(are);
                are.E();
                e = are.returnVal;
                RuntimeStack.pop();

                if( LexArithArray.state == LexArithArray.State.Semicolon)
                {
                    LexArithArray.getToken();
                    returnVal = new Assignment(id, e);
                }
                else{ Parser.errorMsg(4);;}
            }
            else{ Parser.errorMsg(3);;}
        }
        else{ Parser.errorMsg(5); returnVal = null;}
    }

}