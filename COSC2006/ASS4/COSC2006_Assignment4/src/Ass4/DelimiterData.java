package Ass4;
/**
 * Author: Jeel Tikiwala
 * Student Id: 239659420
 * Ass4: Delimiter data
 * Any and All work in this file is my.
 **/

public class DelimiterData {
    private char character;
    private int line;
    private int column;


    public DelimiterData(char character, int line, int column) {
        this.character = character;
        this.line = line;
        this.column = column;
    }

    public char getCharacter() {
        return character;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }
}

