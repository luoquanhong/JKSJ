package com;

import org.apache.commons.io.FileUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class JKMain extends ClassLoader{

    private static String resultStr;

    private static byte[] resultByte;

    public static void main(String[] args) {
        try {
//            FileInputStream fileInputStream = FileUtils.openInputStream(new File(String.format("%s/%s", System.getProperty("user.dir"), "src/main/resources/Hello.xlass")));
            FileInputStream fileInputStream = FileUtils.openInputStream(new File("C:\\Users\\ELUOMIK\\Desktop\\ELUOMIK\\workDocuments\\IdeaProjects\\JKSJ\\Java\\Week01\\src\\main\\resources\\Hello.xlass"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fileInputStream.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fileInputStream.close();
            bos.close();
            byte[] buffer = bos.toByteArray();
//            System.out.println(Arrays.toString(buffer));
            resultByte = new byte[buffer.length];
            for (int i = 0; i <= buffer.length - 1; i++) {
                resultByte[i] = (byte) (255 - buffer[i]);
            }
            resultStr = new String(resultByte);
//            System.out.println("the result is:\n" + Arrays.toString(resultByte));
//            System.out.println("the string result is:\n" + resultStr);
            Class helloClass = new JKMain().findClass("Hello");
            helloClass.getMethod("hello").invoke(helloClass.newInstance());
        } catch (IOException | ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
       return defineClass(name, resultByte, 0, resultByte.length);
    }
}
