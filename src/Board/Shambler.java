package Board;

public class Shambler extends Monsters
{
    public static String name = "Shambler";
    public static int hp = 3;
    public static int atk = 1;
    public static String desc[] = {"A Shambler shambles up to you.", "The stench of a Shambler fills the area."};

    public Shambler(String name, int hp, int atk, String desc) {
        super(name, hp, atk, desc);
    }
}
