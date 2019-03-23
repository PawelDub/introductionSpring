package it.stacja.app.factory.context;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleContext {

  private Map<Class<?>, Object> instances = new HashMap<>();
  private final String prefix;

  public SimpleContext(String prefix) {
    this.prefix = prefix;
    init();
  }

  private void init() {
    Reflections reflections = new Reflections(this.prefix);

    Set<Class<?>> annotatedWith = reflections.getTypesAnnotatedWith(Component.class);


  }

  private Object resolve(Class<?> classType) {
    Constructor<?>[] constructors = classType.getConstructors();

    if (instances.containsKey(classType)) {
      return instances.get(classType);
  }

    Constructor constructor = constructors[0];
    try {

      Class[] types = constructor.getParameterTypes();
      Object[] parameters = Arrays.stream(types).map(this::resolve).toArray();

      Object instance = constructor.newInstance(parameters);

      if (!classType.isAnnotationPresent(Prototype.class)){
        instances.put(classType, instance);
      }

//      instances.put(classType, instance);
      return instance;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

  public <T> T getElement(Class<T> aClass) {
    return (T) this.resolve(aClass);
  }

}