package People;

public class Vellisima implements Character
{
    public static String name = "Vellisima";
    public static String desc = "A dancer with a knack for witchery. Might know a thing or two about teleportation.";
    public static int hp = 7;
    public static int atk = 7;
    public static Skills skill = new Skills("Teleport", 2, "Teleport up to 3 blocks away from your destination. " +
            "Requires a set of coordinates that is no more than 3 blocks away.");
    public static int sNum = 2;
}
