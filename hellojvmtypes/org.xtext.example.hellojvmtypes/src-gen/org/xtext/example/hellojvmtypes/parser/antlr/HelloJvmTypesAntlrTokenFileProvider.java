/*
* generated by Xtext
*/
package org.xtext.example.hellojvmtypes.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class HelloJvmTypesAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/xtext/example/hellojvmtypes/parser/antlr/internal/InternalHelloJvmTypes.tokens");
	}
}
