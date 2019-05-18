import java.io.FileReader;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

class DynamicInvocationHandler implements InvocationHandler{

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Invokeed: method" + method.getName() + " args:" + args);

        if("put".equals(method.getName())){
           System.out.println("You are puting something...");
           Stream.of(args).forEach(System.out::println); 
        }
        //System.out.println(this);
        return proxy;
    }
}

public class MainProxy{


    public static void main(String[] args){
        Map<String,String> proxyMap = (Map)Proxy.newProxyInstance(MainProxy.class.getClassLoader(), new Class[]{Map.class}, new DynamicInvocationHandler());

        proxyMap.put("Hello", "Yes");



    }
}