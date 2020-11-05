package TicTacToe;

import java.util.Objects;

public class Board {
    private final String structure;
    private final String size;
    private final String template;

    public Board(String structure, String size, String template) {
        this.structure = structure;
        this.size = size;
        this.template = template;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Board board = (Board) o;
        return Objects.equals(structure, board.structure) &&
                Objects.equals(size, board.size) &&
                Objects.equals(template, board.template);
    }

    @Override
    public int hashCode() {
        return Objects.hash(structure, size, template);
    }
}
