package br.com.cas10.domain;

import java.beans.PropertyDescriptor;

public interface NameProvider {

	String getName(Class clazz);
	
	String getName(String className);
	
	String getName(Class clazz, String path);
	
	String getName(String className, String path);
	
	String getName(Class clazz, PropertyDescriptor prop);
	
}
