package Game;

import People.*;
import Board.Blocks;
import java.util.Scanner;

public class Runner
{
    private static boolean gameOn = true;
    public static boolean battle = false;

    public static void main(String[] args)
    {
        Blocks[][] cityGrid = null;
        Scanner in = new Scanner(System.in);
        boolean pon = false;
        System.out.println("How large do you want the board to be? Small, Medium, Large, or Deluxe?");
        while(!pon)
        {
            String a = in.nextLine();
            if(a.toLowerCase().contains("small"))
            {
                cityGrid = new Blocks[3][3];
            }
            if(a.toLowerCase().contains("medium"))
            {
                cityGrid = new Blocks[5][5];
            }
            if(a.toLowerCase().contains("large"))
            {
                cityGrid = new Blocks[8][8];
            }
            if(a.toLowerCase().contains("deluxe"))
            {
                cityGrid = new Blocks[15][15];
            }
        }

        //Fill the cityGrid with blocks
        for (int x = 0; x < cityGrid.length; x++)
        {
            for (int y = 0; y < cityGrid[x].length; y++)
            {
                cityGrid[x][y] = new Blocks(x,y, (int) Math.random() * 5);
            }
        }


        //Setup player and the input scanner
        Person player = null;
        boolean con = false;
        while(!con)
        {
            System.out.println("Please select which character you would like: Vinchezo, Vellisima, Machina, or Iggy.");
            String a = in.nextLine();
            if(a.contains("Vinchezo"))
            {
                System.out.println(Vinchezo.name);
                System.out.println(Vinchezo.desc);
                System.out.println("HP: " + Vinchezo.hp);
                System.out.println("ATK: " + Vinchezo.atk);
                System.out.println("SKILL: " + Vinchezo.skill.name + ", " + Vinchezo.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Vinchezo.name, Vinchezo.hp, Vinchezo.atk, Vinchezo.skill,0, 0, Vinchezo.sNum);
                    con = true;
                }
            }
            if(a.contains("Vellisima"))
            {
                System.out.println(Vellisima.name);
                System.out.println(Vellisima.desc);
                System.out.println("HP: " + Vellisima.hp);
                System.out.println("ATK: " + Vellisima.atk);
                System.out.println("SKILL: " + Vellisima.skill.name + ", " + Vellisima.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Vellisima.name, Vellisima.hp, Vellisima.atk, Vellisima.skill,0, 0, Vellisima.sNum);
                    con = true;
                }
            }
            if(a.contains("Iggy"))
            {
                System.out.println(Iggy.name);
                System.out.println(Iggy.desc);
                System.out.println("HP: " + Iggy.hp);
                System.out.println("ATK: " + Iggy.atk);
                System.out.println("SKILL: " + Iggy.skill.name + ", " + Iggy.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Iggy.name, Iggy.hp, Iggy.atk, Iggy.skill,0, 0, Iggy.sNum);
                    con = true;
                }
            }
            if(a.contains("Machina"))
            {
                System.out.println(Machina.name);
                System.out.println(Machina.desc);
                System.out.println("HP: " + Machina.hp);
                System.out.println("ATK: " + Machina.atk);
                System.out.println("SKILL: " + Machina.skill.name + ", " + Machina.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Machina.name, Machina.hp, Machina.atk, Machina.skill,0, 0, Machina.sNum);
                    con = true;
                }
            }
        }
        System.out.println("You have chosen " + player.name);
        cityGrid[0][0].enterBlocks(player);
        while(gameOn)
        {
            System.out.println("Where would you like to move? (Choose N, S, E, W)");
            String move = in.nextLine();
            if(validMove(move, player, cityGrid))
            {
                System.out.println("Your coordinates: row = " + player.getxLoc() + " col = " + player.getyLoc());

            }
            else {
                System.out.println("Please choose a valid move.");
            }


        }
        in.close();
    }

    /**
     * Checks that the movement chosen is within the valid game map.
     * @param move the move chosen
     * @param p person moving
     * @param map the 2D array of Blocks
     * @return
     */
    public static boolean validMove(String move, Person p, Blocks[][] map)
    {
        move = move.toLowerCase().trim();
        switch (move) {
            case "n":
                if(battle)
                {
                    System.out.println("You can't move blocks now! You're in a battle!");
                    return false;
                }
                if (p.getxLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveBlocks(p);
                    map[p.getxLoc()-1][p.getyLoc()].enterBlocks(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "e":
                if(battle)
                {
                    System.out.println("You can't move blocks now! You're in a battle!");
                    return false;
                }
                if (p.getyLoc()< map[p.getyLoc()].length -1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveBlocks(p);
                    map[p.getxLoc()][p.getyLoc() + 1].enterBlocks(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "s":
                if(battle)
                {
                    System.out.println("You can't move blocks now! You're in a battle!");
                    return false;
                }
                if (p.getxLoc() < map.length - 1)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveBlocks(p);
                    map[p.getxLoc()+1][p.getyLoc()].enterBlocks(p);
                    return true;
                }
                else
                {
                    return false;
                }

            case "w":
                if(battle)
                {
                    System.out.println("You can't move blocks now! You're in a battle!");
                    return false;
                }
                if (p.getyLoc() > 0)
                {
                    map[p.getxLoc()][p.getyLoc()].leaveBlocks(p);
                    map[p.getxLoc()][p.getyLoc()-1].enterBlocks(p);
                    return true;
                }
                else
                {
                    return false;
                }
            case "f":
                System.out.println("You are about to use your skill, " + p.skill.name + ". Where do you want to use it?");
                Scanner in = new Scanner(System.in);
                boolean con = false;
                while(!con)
                {
                    Skills.useSkill(p.skillNum, p);
                }
                return true;
            default:
                break;

        }
        return true;
    }
    public static void gameOff()
    {
        gameOn = false;
    }



}