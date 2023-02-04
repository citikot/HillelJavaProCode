package lesson20.annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class MainAnnotation {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        Class<DemoClass> demoClassObj = DemoClass.class;
        readJavaFileInfoAnnotation(demoClassObj);
        
        Method method = demoClassObj.getMethod("printString");
        readJavaFileInfoAnnotation(method);
    }

    static void readJavaFileInfoAnnotation(AnnotatedElement element) {
        try {
            System.out.println("Search JavaFileInfo annotation in " + element.getClass()
                    .getName());
            JavaFileInfo javaFileInfo = element.getAnnotation(JavaFileInfo.class);
            if (javaFileInfo != null) {
                System.out.println("Author: " + javaFileInfo.name());
                System.out.println("Version: " + javaFileInfo.value() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
