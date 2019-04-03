/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dyslexia.grammar;

import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.antlr.v4.runtime.*;

/**
 *
 * @author Gaming
 */
public class DyslexiaParserErrorListener extends BaseErrorListener{
    public ArrayList<String> errors = new ArrayList<>();
    
    @Override
	public void syntaxError(Recognizer<?, ?> recognizer,
				Object offendingSymbol,
				int line, int charPositionInLine,
				String msg,
				RecognitionException e)
    {
        // prints out multiple dialogs for multiple errors
        List<String> stack = ((Parser)recognizer).getRuleInvocationStack();
        Collections.reverse(stack);
        StringBuilder buf = new StringBuilder();
        buf.append("rule stack: "+stack+" ");
        buf.append("line "+line+":"+charPositionInLine+" at "+
                   offendingSymbol+": "+msg);
        
        errors.add(buf.toString());
    }
}
