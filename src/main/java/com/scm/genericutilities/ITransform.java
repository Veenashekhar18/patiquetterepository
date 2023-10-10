package com.scm.genericutilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class ITransform implements IAnnotationTransformer{
	
	@Override
	public void transform(ITestAnnotation annotation,Class testclass, Constructor testconnstructor,Method testmethod)
	{
		annotation.setRetryAnalyzer(com.scm.genericutilities.Retryimplementationclass.class);
	}

}
