package People;

public class Machina implements Character
{
    public static String name = "Machina";
    public static String desc = "A cold machine with a minigun built into its torso";
    public static int hp = 20;
    public static int atk = 4;
    public static Skills skill = new Skills("Bullet Rain", 5, "Clear all enemies in any direction. " +
            "You take recoil though. Requires set of coordinates perpendicular to you to indicate attack direction.");
    public static int sNum = 4;
}
