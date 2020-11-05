package TicTacToe;

public class BoardBuilder {
    private String structure;
    private String size;
    private String template;

    public BoardBuilder withStructure(String structure) {
        this.structure = structure;
        return this;
    }

    public BoardBuilder withSize(String size) {
        this.size = size;
        return this;
    }

    public BoardBuilder withTemplate(String template) {
        this.template = template;
        return this;
    }

    public Board build() {
        return new Board(structure, size, template);
    }
}
