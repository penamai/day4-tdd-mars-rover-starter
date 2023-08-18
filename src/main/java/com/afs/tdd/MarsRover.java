package com.afs.tdd;

import java.util.HashMap;
import java.util.List;

public class MarsRover {

    private final Location location;
    private final HashMap<Direction, Direction> clockwiseMap = new HashMap<>();
    private final HashMap<Direction, Direction> counterClockwiseMap = new HashMap<>();

    public MarsRover(Location location) {
        this.location = location;
        initializeCounterClockwiseMap();
        initializeClockwiseMap();
    }

    private void initializeCounterClockwiseMap() {
        this.counterClockwiseMap.put(Direction.NORTH, Direction.WEST);
        this.counterClockwiseMap.put(Direction.SOUTH, Direction.EAST);
        this.counterClockwiseMap.put(Direction.EAST, Direction.NORTH);
        this.counterClockwiseMap.put(Direction.WEST, Direction.SOUTH);
    }

    private void initializeClockwiseMap(){
        this.clockwiseMap.put(Direction.NORTH, Direction.EAST);
        this.clockwiseMap.put(Direction.SOUTH, Direction.WEST);
        this.clockwiseMap.put(Direction.EAST, Direction.SOUTH);
        this.clockwiseMap.put(Direction.WEST, Direction.NORTH);
    }

    public void executeCommand(Command givenCommand) {
        if (givenCommand == Command.MOVE) {
            move();
        } else if (givenCommand == Command.TURN_LEFT) {
            turnLeft();
        } else if (givenCommand == Command.TURN_RIGHT) {
            turnRight();
        }
    }
    //TODO: can use .equals() to compare

    public void move() {
        int newX = location.getX();
        int newY = location.getY();

        switch (location.getDirection()) {
            case NORTH:
                newY += 1;
                break;
            case SOUTH:
                newY -= 1;
                break;
            case EAST:
                newX += 1;
                break;
            case WEST:
                newX -= 1;
                break;
        }

        location.setX(newX);
        location.setY(newY);
    }

    private void turnLeft() {
        location.setDirection(counterClockwiseMap.get(location.getDirection()));
    }

    private void turnRight() {
        location.setDirection(clockwiseMap.get(location.getDirection()));
    }


    public Location getCurrentLocation() {
        return new Location(location.getX(), location.getY(), location.getDirection());
    }

    public void executeBatchCommand(List<Command> givenCommands) {
        givenCommands.forEach(this::executeCommand);
    }
}
