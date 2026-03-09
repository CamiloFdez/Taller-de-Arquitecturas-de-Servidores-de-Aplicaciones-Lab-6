package edu.eci.MicroSpringBoot.framework;

import java.lang.reflect.Method;

import edu.eci.MicroSpringBoot.annotations.GetMapping;
import edu.eci.MicroSpringBoot.annotations.RequestParam;
import edu.eci.MicroSpringBoot.annotations.RestController;


public class MicroSpringBootApplication {

    public static void main(String[] args) throws Exception {

        System.out.println("Cargando componentes...");

        Class<?> c = Class.forName(args[0]);

        if (c.isAnnotationPresent(RestController.class)) {

            Object controllerInstance = c.getDeclaredConstructor().newInstance();

            for (Method m : c.getDeclaredMethods()) {

                if (m.isAnnotationPresent(GetMapping.class)) {

                    GetMapping annotation = m.getAnnotation(GetMapping.class);
                    String path = annotation.value();

                    System.out.println("Registrando endpoint: " + path);

                    HttpServer.get(path, (req, res) -> {
                        try {

                            var params = m.getParameters();
                            Object[] argsValues = new Object[params.length];

                            for (int i = 0; i < params.length; i++) {

                                if (params[i].isAnnotationPresent(RequestParam.class)) {

                                    RequestParam rp = params[i].getAnnotation(RequestParam.class);

                                    String paramName = rp.value();
                                    String defaultValue = rp.defaultValue();

                                    String value = req.getValue(paramName);

                                    if (value == null) {
                                        value = defaultValue;
                                    }

                                    argsValues[i] = value;
                                }
                            }

                            return (String) m.invoke(controllerInstance, argsValues);

                        } catch (Exception e) {
                            e.printStackTrace();
                            return "Error ejecutando método";
                        }
                    });
                }
            }
        }

        HttpServer.staticfiles("webroot/public");

        HttpServer.main(new String[]{});
    }
}