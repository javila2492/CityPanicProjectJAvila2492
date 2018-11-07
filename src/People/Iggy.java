package People;

public class Iggy implements Character
{
    public static String name = "Iggy";
    public static String desc = "A boston terrier with the strange ability of manifesting sand.";
    public static int hp = 7;
    public static int atk = 8;
    public static Skills skill = new Skills("Sandstorm", 7, "Create a sandstorm to clear enemies in any chosen block. " +
            "Requires coordinates to indicate where you want to use it.");
    public static int sNum = 3;
}

