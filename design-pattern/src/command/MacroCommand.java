package command;

public class MacroCommand implements Command{

    Command[] commands;

    public MacroCommand(Command[] commands){
        this.commands = commands;
    }

    public void execute(){
        for(Command command : commands){
            command.execute();
        }
    }
}
