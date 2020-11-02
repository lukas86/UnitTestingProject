package TicTacToe;

public class Board {
    private String structure;
    private String size;
    private String template;

    public Board(String structure, String size, String template) {
        this.structure = structure;
        this.size = size;
        this.template = template;
    }

    public Board(String structure) {
        this.structure = structure;
    }

    public Board(String structure, String size) {
        this.structure = structure;
        this.size = size;
    }

    public String getStructure() {
        return structure;
    }

    public String getSize() {
        return size;
    }

    public String getTemplate() {
        return template;
    }

}
