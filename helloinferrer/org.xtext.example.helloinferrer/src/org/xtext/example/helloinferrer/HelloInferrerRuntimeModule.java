/*
 * generated by Xtext
 */
package org.xtext.example.helloinferrer;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.xtext.example.helloinferrer.scoping.HelloInferrerScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the
 * Equinox extension registry.
 */
public class HelloInferrerRuntimeModule extends
		org.xtext.example.helloinferrer.AbstractHelloInferrerRuntimeModule {
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return HelloInferrerScopeProvider.class;
	}
}
