package command;

import java.util.ArrayList;
import java.util.List;

public class RemoteControl {
    Command[] onCommands;
    Command[] offCommands;

    public  RemoteControl(){
        onCommands = new Command[7];
        offCommands = new Command[7];

        Command noCommand = new NoCommand();

        for (int i=0; i<onCommands.length; i++){
            onCommands[i]=(noCommand);
            offCommands[i]=(noCommand);
        }
    }

    public void setCommand (int slot, Command onCommand, Command offCommand){
        onCommands[slot]=onCommand;
        offCommands[slot]=onCommand;
    }

    public void  onButtonWasPushed(int slot){
        onCommands[slot].execute();
    }
    public void  offButtonWasPushed(int slot){
        offCommands[slot].execute();

    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("\n------리모컨------\n");
        for (int i=0; i< onCommands.length; i++){
            stringBuffer.append("[slot"+i+"]"+ onCommands[i].getClass().getName()+"     "+offCommands[i].getClass().getName()+"|n");
        }

        return stringBuffer.toString();
    }
}
