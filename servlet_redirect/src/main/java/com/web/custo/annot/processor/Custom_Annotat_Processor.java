package com.web.custo.annot.processor;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

public class Custom_Annotat_Processor extends AbstractProcessor{

	@Override
	public boolean process(Set<? extends TypeElement> annotations,
			RoundEnvironment roundEnv) {
		Messager messager = processingEnv.getMessager();
		for (TypeElement te : annotations) {
		      for (Element e : roundEnv.getElementsAnnotatedWith(te)) {
		    	  messager.printMessage(Diagnostic.Kind.NOTE,
                          "Printing: " + e.toString());
		      }
	    }
	    return true;
	  }

}
