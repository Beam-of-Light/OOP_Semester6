package app.servlets;

import java.util.*;

public class SecurityConfig {

    public static final String admin = "admin";
    public static final String dispatcher = "dispatcher";
    private static final Map<String, List<String>> mapConfig = new HashMap<>();

    static {
        init();
    }

    private static void init() {

        List<String> urlPatterns1 = new ArrayList<>();

        urlPatterns1.add("/airports");
        urlPatterns1.add("/flights");
        urlPatterns1.add("/employees");

        mapConfig.put(admin, urlPatterns1);

        List<String> urlPatterns2 = new ArrayList<>();

        urlPatterns2.add("/employees");
        urlPatterns2.add("/flights");
        urlPatterns2.add("/airports");

        mapConfig.put(dispatcher, urlPatterns2);
    }

    public static Set<String> getAllAppRoles() {
        return mapConfig.keySet();
    }

    public static List<String> getUrlPatternsForRole(String role) {
        return mapConfig.get(role);
    }

}