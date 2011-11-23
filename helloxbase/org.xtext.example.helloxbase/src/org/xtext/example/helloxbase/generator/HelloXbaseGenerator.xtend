/*
 * generated by Xtext
 */
package org.xtext.example.helloxbase.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator
import org.eclipse.xtext.xbase.compiler.ImportManager
import org.xtext.example.helloxbase.helloXbase.Greeting

import static extension org.eclipse.xtext.xtend2.lib.ResourceExtensions.*
import org.eclipse.xtext.common.types.TypesFactory
import com.google.inject.Inject
import org.eclipse.xtext.xbase.XExpression
import org.eclipse.xtext.xbase.compiler.StringBuilderBasedAppendable
import org.eclipse.xtext.xbase.compiler.XbaseCompiler

class HelloXbaseGenerator implements IGenerator {
	
	@Inject extension HelloXbaseExtensions
	
	@Inject
  	protected XbaseCompiler xbaseCompiler
	
	override void doGenerate(Resource resource, IFileSystemAccess fsa) {
		for(greeting: resource.allContentsIterable.filter(typeof(Greeting))) {
		    fsa.generateFile(
                greeting.packageName + "/" + // package
                greeting.className + ".java", // class name
                greeting.compile)
		}
	}
	
	def getJvmType(Greeting greeting) {
	    val declaredType = TypesFactory::eINSTANCE.createJvmGenericType
	    declaredType.setSimpleName(greeting.className)
	    declaredType.setPackageName(greeting.packageName)
	    declaredType
	}
	
	def compile(Greeting greeting) '''
	«val importManager = new ImportManager(true, getJvmType(greeting))»
	«val mainMethod = compile(greeting, importManager)»
	package «greeting.packageName»;
	«IF !importManager.imports.empty»
	
	«FOR i : importManager.imports»
	   import «i»;
	«ENDFOR»
	«ENDIF»
	
	«mainMethod»
	'''

    def compile(Greeting greeting, ImportManager importManager) '''
    «val builder = compile(greeting.expression, importManager)»
    public class «greeting.className» {
        public static void main(String args[]) {
        	«builder»

        	Object expression = «builder.getName(greeting.expression)»;
            System.out.println("Hello «greeting.name» from " +
            	expression.toString());
        }
    }
    '''
    
    def compile(XExpression xExpression, ImportManager importManager) {
    	val result = new StringBuilderBasedAppendable(importManager)
    	result.declareVariable(xExpression, "expressionResult")
    	xbaseCompiler.toJavaStatement(xExpression, result, true)
    	result
    }
}
