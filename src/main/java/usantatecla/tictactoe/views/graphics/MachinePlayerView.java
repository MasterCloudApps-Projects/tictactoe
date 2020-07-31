package usantatecla.tictactoe.views.graphics;

import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.types.Error;
import usantatecla.tictactoe.models.Player;
import usantatecla.tictactoe.views.PlayerView;

class MachinePlayerView extends PlayerView {

	MachinePlayerView(Player player) {
		super(player);
	}

	@Override
	public Coordinate readCoordinateToPut() {
		Coordinate coordinate = new Coordinate();
		Error error;
		do {
			coordinate.random();
			error = controlErrorsPutCoordinate(coordinate);
		} while (error != null);
		return coordinate;
	}

	@Override
	public Coordinate[] readCoordinatesToMove() {
		Coordinate originCoordinate = new Coordinate();
		Error error;
		do {
			originCoordinate.random();
			error = controlErrorsMoveOriginCoordinate(originCoordinate);
		} while (error != null);
		Coordinate targetCoordinate = new Coordinate();
		do {
			targetCoordinate.random();
			error = controlErrorsMoveTargetCoordinate(originCoordinate, targetCoordinate);
		} while (error != null);
		Coordinate[] coordinates = new Coordinate[2];
		coordinates[0] = originCoordinate;
		coordinates[1] = targetCoordinate;
		return coordinates;
	}

}