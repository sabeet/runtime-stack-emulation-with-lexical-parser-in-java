// the class of activation records of E() function

/*

public static E E()

	// <E> --> <term> | <term> + <E> | <term> - <E>

	{
		Term term = term();
		if ( state == State.Plus )
		{
			getToken();
			E e = E();
			return new AddE(term, e);
		}
		else if ( state == State.Minus )
		{
			getToken();
			E e = E();
			return new SubE(term, e);
		}
		else
			return new SingleTerm(term);
	}

 */

class ARE extends AR
        // <E> --> <term> | <term> + <E> | <term> - <E>
{
    E e;
    Term term;
    E returnVal;

    void E()
    {
     ARterm art = new ARterm();
     RuntimeStack.push(art);
     art.term();
     term = art.returnVal;
     RuntimeStack.pop();

        if ( LexArithArray.state == LexArithArray.State.Plus )
        {
            LexArithArray.getToken();

            ARE are = new ARE();
            RuntimeStack.push(are);
            are.E();
            e = are.returnVal;
            RuntimeStack.pop();

            returnVal = new AddE(term, e);
        }

        else if (  LexArithArray.state == LexArithArray.State.Minus )
        {
            LexArithArray.getToken();

            ARE are = new ARE();
            RuntimeStack.push(are);
            are.E();
            e = are.returnVal;
            RuntimeStack.pop();

            returnVal = new SubE(term,e);
        }

        else
            {
                returnVal = new SingleTerm(term);
            }
    }

}