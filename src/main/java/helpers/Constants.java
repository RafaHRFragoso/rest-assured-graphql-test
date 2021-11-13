package helpers;

public class Constants {
    public static final String BASE_URL = "https://countries.trevorblades.com/";
    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_APPLICATION = "application/json";
    public static final String BODY_LANGUAGE_SUCCESSFUL = "{\"query\":\"query {\\r\\n  language(code: \\\"pt\\\") { \\r\\n    name\\r\\n    native\\r\\n    rtl\\r\\n  }\\r\\n}\\r\\n\",\"variables\":{}}\n";
    public static final String BODY_LANGUAGE_INCORRECT_ATTRIBUTE_NAME = "{\"query\":\"query {\\r\\n  language(code: \\\"pt\\\") { \\r\\n    nome\\r\\n    native\\r\\n    rtl\\r\\n  }\\r\\n}\\r\\n\",\"variables\":{}}\n";
    public static final String ERROR_MESSAGE = "\"errors\":[{\"message\":\"Cannot query field \\\"nome\\\" on type \\\"Language\\\". Did you mean \\\"name\\\" or \\\"code\\\"?\"";
}
