package com.manikanta.transformation;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeanUtils;

/**
 * Created by Manikanta Tummalapenta on 03/08/20
 */
public class TransformerUtil {
    private static final Map<String, Map<Method, Method>> classMethodMap = new ConcurrentHashMap<String, Map<Method, Method>>();

    public static <T> T transformObject(Object obj, Class<T> type) {
        return transformObject(obj, type, null);
    }

    public static <T> T transformObject(Object fromObj, Class<T> toObjectClass, T o1) {
        if (fromObj != null) {
            String methodName;
            try {
                T toObject = null;
                if (o1 == null) {
                    toObject = toObjectClass.newInstance();
                } else {
                    toObject = o1;
                }
                Map<Method, Method> methodMap = classMethodMap.get(fromObj.getClass().getName() + "___" + toObjectClass.getName());
                if (methodMap == null) {
                    methodMap = new HashMap<Method, Method>();
                    for (Method entryClassMethod : fromObj.getClass().getMethods()) {
                        Class<?> returnClassType = entryClassMethod.getReturnType();
                        if (entryClassMethod.getName().startsWith("get") && entryClassMethod.getDeclaringClass() != Object.class) {
                            if (BeanUtils.isSimpleValueType(returnClassType)) {
                                methodName = "set" + entryClassMethod.getName().substring(3);
                                try {
                                    Method m = toObjectClass.getMethod(methodName, returnClassType);
                                    methodMap.put(entryClassMethod, m);
                                } catch (Exception e) {
                                    // no need to do anything
                                }
                            }
                        } else if (entryClassMethod.getName().startsWith("is") && entryClassMethod.getDeclaringClass() != Object.class) {
                            if (BeanUtils.isSimpleValueType(returnClassType)) {
                                methodName = "set" + entryClassMethod.getName().substring(2);
                                try {
                                    Method m = toObjectClass.getMethod(methodName, returnClassType);
                                    methodMap.put(entryClassMethod, m);
                                } catch (Exception e) {
                                    // no need to do anything
                                }
                            }
                        }
                    }
                    synchronized (TransformerUtil.class) {
                        classMethodMap.put(fromObj.getClass().getName() + "___" + toObjectClass.getName(), methodMap);
                    }
                }

                for (Method fromClassMethod : methodMap.keySet()) {
                    try {
                        Object o = fromClassMethod.invoke(fromObj);
                        if (o != null) {
                            Method toClassMethod = methodMap.get(fromClassMethod);
                            toClassMethod.invoke(toObject, o);
                        }
                    } catch (Exception ex) {
                        System.out.println();
                    }
                }
                return toObject;
            } catch (Exception e) {
                System.out.println();
            }
        }
        return null;
    }
}
