package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflectBob {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        //包路径，反射只能获取当前包下的吗？
        Class c = Class.forName("reflect.Bob");
        Bob b = (Bob) c.newInstance();
        System.out.println("Class name is "+ c.getName());
        Method sayHello = c.getDeclaredMethod("sayHello", String.class);
        Object o1 = sayHello.invoke(b,"everyOne");
        System.out.println(o1);
        Method intro = c.getDeclaredMethod("introduction", String.class);
        intro.setAccessible(true);
        intro.invoke(b,"I am ");
        Field name = c.getDeclaredField("name");
        name.setAccessible(true);
        name.set(b, "Qinxiaoyu");
        intro.invoke(b,"I am ");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }
}
