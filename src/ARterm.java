public class ARterm extends AR
{
/*
public static Term term()

	// <term> --> <primary> | <primary> * <term> | <primary> / <term>

	{
		Primary primary = primary();
		if ( state == State.Times )
		{
			getToken();
			Term term = term();
			return new MulTerm(primary, term);
		}
		else if ( state == State.Div )
		{
			getToken();
			Term term = term();
			return new DivTerm(primary, term);
		}
		else
			return new SinglePrimary(primary);
	}
 */

    Primary primary;
    Term term;
    Term returnVal;

    void term(){
        // <term> --> <primary> | <primary> * <term> | <primary> / <term>
        ARprimary arp = new ARprimary();
        RuntimeStack.push(arp);
        arp.primary();
        primary = arp.returnVal;
        RuntimeStack.pop();

        if( LexArithArray.state == LexArithArray.State.Times)
        {
            LexArithArray.getToken();

            ARterm art = new ARterm();
            RuntimeStack.push(art);
            art.term();
            term = art.returnVal;
            RuntimeStack.pop();

            returnVal = new MulTerm(primary, term);
        }

        else if( LexArithArray.state == LexArithArray.State.Div)
        {
            LexArithArray.getToken();

            ARterm art = new ARterm();
            RuntimeStack.push(art);
            art.term();
            term = art.returnVal;
            RuntimeStack.pop();

            returnVal = new DivTerm(primary, term);
        }

        else
            {
                returnVal = new SinglePrimary(primary);
            }
    }
}
