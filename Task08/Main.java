//package test.HW8;

import test.Primary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Main class of application
 */
public class Main {
    /**
     * @param args - command line parameters
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CreateData data = new CreateData();
        data.createData();

        while (true) {
            System.out.print("Enter your command: ");
            String str = reader.readLine();
            if (str.equals("exit")) break;
            if (str.isEmpty()) continue;
            callCommands(str, heapOfCommand(), data);
        }
    }

    /**
     * @return List of commands
     */
    public static ArrayList<PrimaryCommandClass> heapOfCommand() {
        ArrayList<PrimaryCommandClass> commands = new ArrayList<>();
        commands.add(new CountAll());
        commands.add(new CountTypes());
        commands.add(new AveragePrice());
        commands.add(new AveragePriceOfType());
        return commands;
    }

    /**
     * @param str  the name of command
     * @param list list of commands
     * @param cd   data stores object
     */
    public static void callCommands(String str, ArrayList<PrimaryCommandClass> list, CreateData cd) {
        for (PrimaryCommandClass se : list) {
            se.commandName(str, cd);
        }
    }
}
