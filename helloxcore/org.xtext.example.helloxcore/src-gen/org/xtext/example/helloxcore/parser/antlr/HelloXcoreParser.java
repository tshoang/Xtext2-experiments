/*
* generated by Xtext
*/
package org.xtext.example.helloxcore.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.xtext.example.helloxcore.services.HelloXcoreGrammarAccess;

public class HelloXcoreParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private HelloXcoreGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.xtext.example.helloxcore.parser.antlr.internal.InternalHelloXcoreParser createParser(XtextTokenStream stream) {
		return new org.xtext.example.helloxcore.parser.antlr.internal.InternalHelloXcoreParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}
	
	public HelloXcoreGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(HelloXcoreGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}