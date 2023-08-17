package com.afs.tdd;

import java.util.List;

public class MarsRover {

    private final Location location;

    public MarsRover(Location location) {
        this.location = location;
    }

    public void executeCommand(Command givenCommand) {
        if(givenCommand == Command.MOVE) {
            move();
        }else if(givenCommand == Command.TURN_LEFT){
            turnLeft();
        }else if(givenCommand == Command.TURN_RIGHT){
            turnRight();
        }
    }

    public void move(){
        int newX = location.getX();
        int newY = location.getY();

        switch(location.getDirection()){
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
        if(location.getDirection() == Direction.NORTH){
            location.setDirection(Direction.WEST);
        }else if(location.getDirection() == Direction.SOUTH){
            location.setDirection(Direction.EAST);
        }else if(location.getDirection() == Direction.EAST){
            location.setDirection(Direction.NORTH);
        }else{
            location.setDirection(Direction.SOUTH);
        }
    }

    private void turnRight() {
        if(location.getDirection() == Direction.NORTH){
            location.setDirection(Direction.EAST);
        }else if (location.getDirection() == Direction.SOUTH){
            location.setDirection(Direction.WEST);
        }else if (location.getDirection() == Direction.EAST){
            location.setDirection(Direction.SOUTH);
        }else{
            location.setDirection(Direction.NORTH);
        }
    }

    public Location getCurrentLocation() {
        return new Location(location.getX(), location.getY(), location.getDirection());
    }

    public void executeBatchCommand(List<Command> givenCommands) {
        givenCommands.forEach(this::executeCommand);
    }
}
