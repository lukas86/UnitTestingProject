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


    public String buildBoardTemplate(String typeOfBoard, String boardStructure) {
        return typeOfBoard + boardStructure;
    }

    public String buildBoardStructure(String tokenVicinityPosition, String direction) {
        String column = "column"; String space = " ";
        return space + tokenVicinityPosition + space + direction + space + column;
    }

    public Board buildBoard(String boardOneByOne, String tokenVicinityPosition, String direction, BoardBuilder boardBuilder) {
        String boardSize = boardOneByOne;
        String boardStructure = buildBoardStructure(tokenVicinityPosition, direction);
        String boardTemplate = buildBoardTemplate(boardSize, boardStructure);

        return boardBuilder.withStructure(boardStructure).withSize(boardSize).withTemplate(boardTemplate).build();
    }

    public Board buildBoard(String structure, BoardBuilder boardBuilder) {
        return boardBuilder.withStructure(structure).build();
    }
}
