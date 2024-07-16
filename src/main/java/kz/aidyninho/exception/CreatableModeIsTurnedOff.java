package kz.aidyninho.exception;

public class CreatableModeIsTurnedOff extends RuntimeException {

    public CreatableModeIsTurnedOff() {
        super("Creatable mode is turned off in properties.");
    }
}
