package TicTacToe;

public class BoardBuilder {
    //TODO :  to ven
    private final String column = "column";
    //TODO :  to ven
    private final String space = " ";

    private String structure;
    private String size;
    private String template;

    //TODO :  to ven
    private String buildBoardStructure(String tokenVicinityPosition, String direction) {
        return space + tokenVicinityPosition + space + direction + space + column;
    }

    //TODO :  to ven
    private String buildBoardRepresentation(String typeOfBoard, String boardStructure) {
        return typeOfBoard + boardStructure;
    }

    //TODO :  to ven
    public Board build(String boardSize, String tokenVicinityPosition, String direction) {
        String boardStructure = buildBoardStructure(tokenVicinityPosition, direction);
        String board = buildBoardRepresentation(boardSize, boardStructure);
        return new Board(boardStructure, boardSize, board);
    }

    //TODO: kaj pa zgornje metode
    public BoardBuilder withStructure(String structure) {
        this.structure = structure;
        return this;
    }

    public BoardBuilder withSize(String size) {
        this.size = size;
        return this;
    }

    public BoardBuilder withboard(String template) {
        this.template = template;
        return this;
    }

    public Board build() {
        return new Board(structure, size, template);
    }
}
