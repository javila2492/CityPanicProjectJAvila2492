package People;

import Board.Blocks;
import Game.Runner;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

/* Contains both a Skill constructor and a function to execute skills */
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
        if(p.mp < p.skill.cost)
        {
            System.out.println("You don't have enough MP for that skill. Gain MP by going to new blocks and beating foes.");
            return;
        }
        p.mp -= p.skill.cost;
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
                int b1 = parseInt(a1.trim());
                int b2 = parseInt(a2.trim());
                if((b1 > p.getxLoc() + 3 || b2 > p.getyLoc() + 3) || (b1 < p.getxLoc() - 3 || b2 < p.getyLoc() - 3))
                    System.out.println("That's too far. Vellisima can only teleport up to 3 blocks away.");
                if((b1 > Runner.cityGrid[0].length - 1 || b2 > Runner.cityGrid[0].length - 1) || (b1 < 0 || b2 < 0))
                    System.out.println("Vellisima wishes she could teleport out of the city, but she can't.");
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
                int b1 = parseInt(a1.trim());
                int b2 = parseInt(a2.trim());
                System.out.println("ZA FOOL! A sandstorm ravages " + b1 + ", " + b2 + " killing every monster in it!");
                Runner.cityGrid[b1][b2].eCo = 0;
                Runner.cityGrid[b1][b2].monsterRally = null;
                if(b1 == p.getxLoc() && b2 == p.getyLoc())
                    Runner.battle = false;
                pon = true;
            }
        }
        if(s == 4)
        {
            boolean pon = false;
            System.out.println("Machina loads up their gun.");
            while (!pon)
            {
                System.out.println("Enter coords perpendicular to your direction in x,y format.");
                a = in.nextLine().trim();
                String a1 = a.substring(0, a.indexOf(","));
                String a2 = a.substring(a.indexOf(",") + 1);
                int b1 = parseInt(a1.trim());
                int b2 = parseInt(a2.trim());
                if(b1 >= Runner.cityGrid[0].length)
                    b1 = Runner.cityGrid[0].length - 1;
                if(b2 >= Runner.cityGrid[0].length)
                    b2 = Runner.cityGrid[0].length - 1;
                if(p.getxLoc() == b1 || p.getyLoc() == b2)
                {
                    if(p.getxLoc() == b1 && p.getyLoc() > b2)
                    {
                        for(int i = b2; i <= Runner.cityGrid[b1].length; i++)
                        {
                            Runner.cityGrid[b1][i].monsterRally = null;
                            Runner.cityGrid[b1][i].eCo = 0;
                            p.hp--;
                        }
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].monsterRally = null;
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].eCo = 0;
                        Runner.battle = false;
                        System.out.println("Machina's firepower mows down everything in sight! But Machina takes " + (20 - p.hp) + " damage!");
                        pon = true;
                    }
                    if(p.getxLoc() == b1 && p.getyLoc() < b2)
                    {
                        for(int i = b2; i >= 0; i--)
                        {
                            Runner.cityGrid[b1][i].monsterRally = null;
                            Runner.cityGrid[b1][i].eCo = 0;
                            p.hp--;
                        }
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].monsterRally = null;
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].eCo = 0;
                        Runner.battle = false;
                        System.out.println("Machina's firepower mows down everything in sight! But Machina takes " + (20 - p.hp) + " damage!");
                        pon = true;
                    }
                    if(p.getyLoc() == b2 && p.getxLoc() > b1)
                    {
                        for(int i = b1; i <= Runner.cityGrid[b2].length; i++)
                        {
                            Runner.cityGrid[b2][i].monsterRally = null;
                            Runner.cityGrid[b2][i].eCo = 0;
                            p.hp--;
                        }
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].monsterRally = null;
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].eCo = 0;
                        Runner.battle = false;
                        System.out.println("Machina's firepower mows down everything in sight! But Machina takes " + (20 - p.hp) + " damage!");
                        pon = true;
                    }
                    if(p.getyLoc() == b2 && p.getxLoc() < b1)
                    {
                        for(int i = b1; i >= 0; i--)
                        {
                            Runner.cityGrid[b2][i].monsterRally = null;
                            Runner.cityGrid[b2][i].eCo = 0;
                            p.hp--;
                        }
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].monsterRally = null;
                        Runner.cityGrid[p.getxLoc()][p.getyLoc()].eCo = 0;
                        Runner.battle = false;
                        System.out.println("Machina's firepower mows down everything in sight! But Machina takes " + (20 - p.hp) + " damage!");
                        pon = true;
                    }
                }
            }
        }
    }
}