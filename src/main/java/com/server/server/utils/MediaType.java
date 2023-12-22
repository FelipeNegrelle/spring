package com.server.server.utils;

public class MediaType {
    public static final String APPLICATION_JSON = "application/json";
    public static final String APPLICATION_XML = "application/xml";
    public static final String APPLICATION_X_YAML = "application/x-yaml";

    public static String[] getMediaTypes() {
        final String[] mediaTypes = {APPLICATION_JSON, APPLICATION_XML, APPLICATION_X_YAML};
        return mediaTypes;
    }
}
