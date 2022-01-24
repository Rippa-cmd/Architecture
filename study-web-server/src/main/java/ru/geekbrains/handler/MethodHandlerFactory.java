package ru.geekbrains.handler;

import org.reflections.Reflections;
import ru.geekbrains.config.Config;
import ru.geekbrains.service.ResponseSerializer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class MethodHandlerFactory {

    private static Map<String, Class<?>> methodHandlers;
    private static final Class<?>[] params = {String.class, MethodHandler.class, ResponseSerializer.class, Config.class};

    private static void init() {
        if (methodHandlers == null) {
            methodHandlers = new HashMap<>();
            Reflections reflections = new Reflections(MethodHandler.class.getPackage().getName());
            reflections.getTypesAnnotatedWith(Handler.class)
                    .forEach(methodHandler -> {
                        methodHandlers.put(methodHandler.getAnnotation(Handler.class).methodName(), methodHandler);
                    });
        }
    }

    public static MethodHandler create(ResponseSerializer responseSerializer, Config config) {
        init();
        MethodHandler handler = null;
        try {

            for (Map.Entry<String, Class<?>> stringClassEntry : methodHandlers.entrySet()) {
                Constructor<?> constructor = stringClassEntry.getValue().getDeclaredConstructor(params);
                constructor.setAccessible(true);
                handler = (MethodHandler) constructor
                        .newInstance(stringClassEntry.getKey(), handler, responseSerializer, config);
            }
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return handler;
    }
}
