package yagotome.testepraticomobile.domain;

/**
 * Classe de modelo para uma foto.
 */
public class Picture {
    private String url;
    private String description;

    public Picture() {
    }

    public Picture(String url, String description) {
        this.url = url;
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public Picture setUrl(String url) {
        this.url = url;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Picture setDescription(String description) {
        this.description = description;
        return this;
    }
}
