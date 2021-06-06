package com.cassini.sudha.restapi.steps;

public enum UriMapping {
    user_login("/api/login"),
    user_registration("/api/register"),
    list_resources("/api/unknown");


    String uri;
    UriMapping(String uri) {
        this.uri = uri;
    }

    public static String uriOfLabel(String label) {
        for (UriMapping e : values()) {
            if (e.name().equals(label)) {
                return e.uri;
            }
        }
        return null;
    }
}
