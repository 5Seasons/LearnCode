package cn.Sparking.com.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class HelloworldImpl implements Helloworld {

	@Override
	public void say() {
		System.out.println("Hello");
	}
	
	public static void main(String args[]){
		Helloworld a = new HelloworldImpl();
		InvocationHandler handler=new HelloWorldHandler(a);
		ClassLoader a_l = a.getClass().getClassLoader();
		Class<?>[] a_c = a.getClass().getInterfaces();
		Helloworld b = (Helloworld) Proxy.newProxyInstance(a_l, a_c, handler);
		b.say();
	}
}
