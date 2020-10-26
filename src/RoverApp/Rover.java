package RoverApp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Rover {
    private String facing;

    public Rover(String facing) {
        this.facing = facing;
    }

    public String getFacing() {
        return facing;
    }

    public void go(String instructions) {
        if (instructions.equals("R")) {
            right();
        } else if (instructions.equals("L")) {
            left();
        }
    }

    private void right() {
        turn(1);
    }

    private void left() {
        turn(3);
    }

    //TODO: refactor
    //  String[] compass = new String[]{"N", "E", "S", "W"};
    //  int index = Arrays.asList(compass).indexOf(facing);
    //  facing = compass[(index + 4 - 1) % 4];
    private void turn(int direction) {
        String[] compass = new String[]{"N", "E", "S", "W"};
        int index = Arrays.asList(compass).indexOf(facing);
        facing = compass[(index + direction) % 4];
    }

//    TODO: different refactor approach
//      public void go(String instructions) {
//        if(instructions.equals("R")) {
//            right();
//        } else {
//            left();
//        }
//      }
//      private void left() {
//        turn(new String[]{"N", "W", "S", "E"});
//      }
//      private void right() {
//        turn(new String[]{"N", "E", "S", "W"});
//      }
//      private void turn(String[] compass) {
//        int index = Arrays.asList(compass).indexOf(facing);
//        facing = compass[(index + 1) % 4];
//      }

//TODO: advanced rover code
//    public Runnable mapToCommand(Character instruction) {
//        Map<Character, Runnable> commands = new HashMap<>();
//        commands.put('F', this::forward);
//        commands.put('B', this::back);
//        commands.put('R', this::right);
//        commands.put('L', this::left);
//        return commands.get(instruction);
//    }
//
//    public void go(String instructions) {
//        instructions.chars().forEach(c -> mapToCommand((char)c).run());
//    }
//
//    private class Gear {
//        public static final int FORWARD = 1;
//        public static final int REVERSE = -1;
//    }

}
