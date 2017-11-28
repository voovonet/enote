package net.voovo.enote.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Vector;

public class JavaBean2HashMap {
	
	public static HashMap<Object,Object> javaBean2HashMap(Vector<Object> vo){
		
		HashMap<Object,Object> result = new HashMap<Object,Object>();
		for(Object o : vo) {
			
			result.putAll(javaBean2HashMap(o));
		}
		
		return result;
	}

	public static HashMap<Object,Object> javaBean2HashMap(Object o){
		
		if(o == null) return null;
		Class<? extends Object> c = o.getClass();
		
		HashMap<Object,Object> result = new HashMap<Object,Object>();
		
		/* 获取所有实例成员变量 */
		Field[] fields = c.getDeclaredFields();
		
		PropertyDescriptor desc = null;
		Method method = null;
		Object val = null;
		String name = "";
		try {
			
			for(Field f : fields) {
				name = f.getName();
				desc = new PropertyDescriptor(name, c);
				method = desc.getReadMethod();
				val = method.invoke(o);
				
				result.put(name, val);
			}
		}catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			result.clear();
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			result.clear();
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			result.clear();
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			result.clear();
			e.printStackTrace();
		}
		
		return result;
	}
}