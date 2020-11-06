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

    public String getTokenVicinityPosition(String token) {
        return "with " + token + " on";
    }

    public String buildBoardTemplate(String typeOfBoard, String boardStructure) {
        return typeOfBoard + boardStructure;
    }

    public String buildBoardStructure(String tokenVicinityPosition, String direction) {
        String column = "column"; String space = " ";
        return space + tokenVicinityPosition + space + direction + space + column;
    }

    public Board buildBoard(String boardOneByOne, String token, String direction) {
        String boardSize = boardOneByOne;
        String boardStructure = buildBoardStructure(getTokenVicinityPosition(token), direction);
        String boardTemplate = buildBoardTemplate(boardSize, boardStructure);

        return withStructure(boardStructure).withSize(boardSize).withTemplate(boardTemplate).build();
    }

    public Board buildBoard(String structure) {
        return withStructure(structure).build();
    }
}
