package People;

import Game.Runner;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Skills
{
    public String name;
    public int cost;
    public String desc;
    public Skills(String name, int cost, String desc)
    {
        this.name = name;
        this.cost = cost;
        this.desc = desc;
    }
    public static void useSkill(int s, Person p)
    {
        Scanner in = new Scanner(System.in);
        String a;
        if(s == 1)
        {
            Runner.cityGrid[p.getxLoc()][p.getyLoc()].eCo = 0;
            Runner.cityGrid[p.getxLoc()][p.getyLoc()].monsterRally = null;
            Runner.battle = false;
            System.out.println("With a wicked shred of the guitar, all the monsters around you collapse and turn into dust.");
        }
        if(s == 2)
        {
            boolean pon = false;
            System.out.println("Vellsima readies herself for teleportation. Where would you like to go? (Enter coords in x,y format)");
            while(!pon)
            {
                a = in.nextLine().trim();
                String a1 = a.substring(0, a.indexOf(","));
                String a2 = a.substring(a.indexOf(",") + 1);
                int b1 = parseInt(a1);
                int b2 = parseInt(a2);
                if((b1 > p.getxLoc() + 3 || b2 > p.getyLoc() + 3) || (b1 < p.getxLoc() - 3 || b2 < p.getyLoc() - 3))
                    System.out.println("That's too far. Vellisima can only teleport up to 3 blocks away.");
                else
                {
                    System.out.println("SHAZAM! You have been warped to " + b1 + ", " + b2);
                    Runner.battle = false;
                    Runner.cityGrid[p.getxLoc()][p.getyLoc()].leaveBlocks(p);
                    Runner.cityGrid[b1][b2].enterBlocks(p);
                    pon = true;
                }
            }
        }
        if(s == 3)
        {
            boolean pon = false;
            System.out.println("Iggy swirls sand around him. Choose where to use the sandstorm.");
            while(!pon)
            {
                System.out.println("Enter coords in x,y format.");
                a = in.nextLine().trim();
                String a1 = a.substring(0, a.indexOf(","));
                String a2 = a.substring(a.indexOf(",") + 1);
                int b1 = parseInt(a1);
                int b2 = parseInt(a2);
                System.out.println("ZA FOOL! A sandstorm ravages " + b1 + ", " + b2 + " killing everything in it!");
                Runner.cityGrid[b1][b2].eCo = 0;
                Runner.cityGrid[b1][b2].monsterRally = null;
                if(b1 == p.getxLoc() && b2 == p.getyLoc())
                    Runner.battle = false;
                pon = true;
            }
        }
    }
}