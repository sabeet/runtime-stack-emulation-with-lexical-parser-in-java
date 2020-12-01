// the class of activation records of primary() function

import java.io.IOException;

class ARprimary extends AR {

    Primary returnVal;

    void primary(){

        try {
            RuntimeStack.output(InterpreterStack.argv2); //Primary is seen first so outputting here makes sense
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (LexArithArray.state) {
            case Id:

                Id id = new Id(LexArithArray.t);
                LexArithArray.getToken();
                returnVal = id;
                break;

            case Int:

                Int intElem = new Int(Integer.parseInt(LexArithArray.t));
                LexArithArray.getToken();
                returnVal = intElem;
                break;

            case Float:
            case FloatE:

                Floatp floatElem = new Floatp(Float.parseFloat(LexArithArray.t));
                LexArithArray.getToken();
                returnVal = floatElem;
                break;

            case LParen:

                LexArithArray.getToken();
                ARE are = new ARE();
                RuntimeStack.push(are);
                E e = are.returnVal;
                RuntimeStack.pop();
                if (LexArithArray.state == LexArithArray.State.RParen) {
                    LexArithArray.getToken();
                    returnVal = new Parenthesized(e);

                } else {
                    Parser.errorMsg(1);
                    returnVal = null;

                }
                break;

            default:

                Parser.errorMsg(2);
                returnVal = null;
                break;
        }
    }

}