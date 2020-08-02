package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.Logic;
import usantatecla.tictactoe.views.MessageView;
import usantatecla.tictactoe.views.TokenView;
import usantatecla.utils.WithConsoleView;

class BoardView extends WithConsoleView {
    
    private Logic logic;

    BoardView(Logic logic) {
        this.logic = logic;
    }

    void write() {
        this.console.writeln(MessageView.SEPARATOR.getMessage());
		for (int i = 0; i < this.logic.getCoordinateDimension(); i++) {
			this.printRowBoard(i);
        }
        this.console.writeln(MessageView.SEPARATOR.getMessage());
	}

	private void printRowBoard(int row) {
        this.console.write(MessageView.VERTICAL_LINE_LEFT.getMessage());
		for (int j = 0; j < this.logic.getCoordinateDimension(); j++) {
			this.printSquareBoard(row, j);
		}
		this.console.writeln();
	}

	private void printSquareBoard(int row, int column) {
		if (this.logic.getToken(row, column) == null) {
            this.console.write(MessageView.EMPTY.getMessage());
		} else {
			this.console.write(new TokenView(this.logic.getToken(row, column)).getToken());
        }
        this.console.write(MessageView.VERTICAL_LINE_CENTERED.getMessage());
	}
}