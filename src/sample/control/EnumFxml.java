package sample.control;

public enum EnumFxml {

    J19000("fxml/main.fxml"),
    J19001("fxml/J19001.fxml"),
    J19002("fxml/J19002.fxml"),
    J19003("fxml/J19003.fxml");

    private String url;

    EnumFxml(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
