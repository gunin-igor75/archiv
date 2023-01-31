package ru.gl.command;
import ru.gl.ConsoleHelper;


public class ExitCommand implements Command{

    @Override
    public void execute() throws Exception{
        ConsoleHelper.writeMessage("Gud By!!!!!");
    }
}
