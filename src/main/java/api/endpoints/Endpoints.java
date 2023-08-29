package api.endpoints;

public enum Endpoints {
    CREATE_USER("/user"),
    RETRIEVE_USER("/user/{userName}");
    private final String endpoint;

    Endpoints(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getValue() {
        return endpoint;
    }
}
