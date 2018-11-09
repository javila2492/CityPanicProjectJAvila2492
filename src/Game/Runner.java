package Game;

import Board.Monsters;
import People.*;
import Board.Blocks;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Runner
{
    public static Blocks[][] cityGrid = null;
    private static boolean gameOn = true;
    public static boolean battle = false;
    public static Person player = null;

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        boolean pon = false;
        while(!pon)
        {
            System.out.println("How large do you want the board to be? Small, Medium, Large, or Deluxe?");
            String a = in.nextLine();
            if(a.toLowerCase().contains("small"))
            {
                cityGrid = new Blocks[4][4];
                System.out.println("The board is now as small as your will to fight.");
                pon = true;
            }
            if(a.toLowerCase().contains("medium"))
            {
                cityGrid = new Blocks[6][6];
                System.out.println("The board is now as average as you are.");
                pon = true;
            }
            if(a.toLowerCase().contains("large"))
            {
                cityGrid = new Blocks[9][9];
                System.out.println("The board is now large, like your fighting spirit.");
                pon = true;
            }
            if(a.toLowerCase().contains("deluxe"))
            {
                cityGrid = new Blocks[15][15];
                System.out.println("The board is now deluxe. May the lord have mercy on your soul.");
                pon = true;
            }
        }
        pon = false;
        int monSpawn = 0;
        while(!pon)
        {
            System.out.println("How difficult do you want your experience to be? Easy, Medium, Hard, or Nightmare?");
            String a = in.nextLine();
            if(a.toLowerCase().contains("easy"))
            {
                monSpawn = 2;
                System.out.println("How pathetic.");
                pon = true;
            }
            if(a.toLowerCase().contains("medium"))
            {
                monSpawn = 4;
                System.out.println("Better than easy, I guess.");
                pon = true;
            }
            if(a.toLowerCase().contains("hard"))
            {
                monSpawn = 6;
                System.out.println("Good luck. You'll need it. Lots of it.");
                pon = true;
            }
            if(a.toLowerCase().contains("nightmare"))
            {
                monSpawn = 10;
                System.out.println("You won't win.");
                pon = true;
            }
        }

        //Fill the cityGrid with blocks
        for (int x = 0; x < cityGrid.length; x++)
        {
            for (int y = 0; y < cityGrid[x].length; y++)
            {
                if(x <= 1 && y <= 1)
                    cityGrid[x][y] = new Blocks(x,y, 0);
                else
                    cityGrid[x][y] = new Blocks(x,y, randomWithRange(0, monSpawn));
            }
        }

        //Setup player and the input scanner
        boolean con = false;
        while(!con)
        {
            System.out.println("Select which character you would like: Vinchezo, Vellisima, Machina, or Iggy.");
            String a = in.nextLine();
            if(a.contains("Vinchezo"))
            {
                System.out.println(Vinchezo.name);
                System.out.println(Vinchezo.desc);
                System.out.println("HP: " + Vinchezo.hp);
                System.out.println("ATK: " + Vinchezo.atk);
                System.out.println("SKILL: " + Vinchezo.skill.name + ", " + Vinchezo.skill.cost + "MP, " + Vinchezo.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Vinchezo.name, Vinchezo.hp, Vinchezo.atk, Vinchezo.skill,0, 0, Vinchezo.sNum, 10);
                    con = true;
                }
            }
            if(a.contains("Vellisima"))
            {
                System.out.println(Vellisima.name);
                System.out.println(Vellisima.desc);
                System.out.println("HP: " + Vellisima.hp);
                System.out.println("ATK: " + Vellisima.atk);
                System.out.println("SKILL: " + Vellisima.skill.name + ", " + Vellisima.skill.cost + "MP, " + Vellisima.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Vellisima.name, Vellisima.hp, Vellisima.atk, Vellisima.skill,0, 0, Vellisima.sNum, 10);
                    con = true;
                }
            }
            if(a.contains("Iggy"))
            {
                System.out.println(Iggy.name);
                System.out.println(Iggy.desc);
                System.out.println("HP: " + Iggy.hp);
                System.out.println("ATK: " + Iggy.atk);
                System.out.println("SKILL: " + Iggy.skill.name + ", " + Iggy.skill.cost + "MP, " + Iggy.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Iggy.name, Iggy.hp, Iggy.atk, Iggy.skill,0, 0, Iggy.sNum, 10);
                    con = true;
                }
            }
            if(a.contains("Machina"))
            {
                System.out.println(Machina.name);
                System.out.println(Machina.desc);
                System.out.println("HP: " + Machina.hp);
                System.out.println("ATK: " + Machina.atk);
                System.out.println("SKILL: " + Machina.skill.name + ", " + Machina.skill.cost + "MP, " + Machina.skill.desc);
                System.out.println("Are you sure you want to pick this character?");
                if((in.nextLine().toLowerCase()).contains("yes"))
                {
                    player = new Person(Machina.name, Machina.hp, Machina.atk, Machina.skill,0, 0, Machina.sNum, 10);
                    con = true;
                }
            }
        }
        System.out.println(Blocks.printGrid(player));
        System.out.println("You have chosen " + player.name);
        TimeUnit.SECONDS.sleep(2);
        System.out.println("The city you know and love is in shambles.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("A terrible plague has taken over. You are the last survivor.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Fight your way to the beacon on the other side of the board.");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("(Remember, choose N, S, E, W to move. F to use skill.)");
        TimeUnit.SECONDS.sleep(2);
        cityGrid[0][0].enterBlocks(player);
        while(gameOn)
        {
            System.out.println("Your HP: " + player.hp);
            System.out.println("Your MP: " + player.mp);
            String move = in.nextLine();
            if(validMove(move, player, cityGrid))
            {
                if(!battle)
                    System.out.println("Your coordinates: row = " + player.getxLoc() + " col = " + player.getyLoc());
                if(battle)
                {
                    while(battle)
                    {
                        System.out.println("Type atk to do a regular attack, stk to do a super attack, or f to use your skill!");
                        System.out.println("Your HP: " + player.hp);
                        System.out.println("Your MP: " + player.mp);
                        move = in.nextLine().trim().toLowerCase();
                        if(move.contains("atk"))
                        {
                            battleMove(move, player);
                        }
                        if(move.contains("stk"))
                        {
                            battleMove(move, player);
                        }
                        if(move.contains("f"))
                            validMove(move, player, cityGrid);
                    }
                    if(player.hp > 0)
                    {
                        System.out.println("You can move freely once more.");
                    }
                }
            }
            else
            {
                System.out.println("Please choose a valid move.");
            }
            if(player.getxLoc() == cityGrid[0].length - 1 && player.getyLoc() == cityGrid[0].length - 1)
            {
                System.out.println("Salvation! You've made it to the beacon!");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("You finally escape the city...but at what cost?");
                TimeUnit.SECONDS.sleep(2);
                if(player.hp <= 4)
                    System.out.println("You are heavily wounded.");
                TimeUnit.SECONDS.sleep(2);
                if(player.hp == 1)
                    System.out.println("You are so wounded that you are on the verge of death.");
                System.out.println("You look back and bid farewell to the ruined streets.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("It's time to start your new life.");
                gameOff();
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
                boolean con = false;
                while(!con)
                {
                    Skills.useSkill(p.skillNum, p);
                    con = true;
                }
                return true;
            default:
                break;

        }
        return false;
    }

    public static void gameOff()
    {
        gameOn = false;
    }

    public static int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }

    public static void battleMove(String move, Person p)
    {
        move = move.toLowerCase().trim();
        Monsters currentFoe = cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[0];
        if(move.contains("atk"))
        {
            int pAtk = p.atk + randomWithRange(1, 6);
            int fAtk = currentFoe.atk + randomWithRange(0, currentFoe.atk);
            if(pAtk > fAtk)
            {
                currentFoe.hp -= p.atk;
                System.out.println("You dealt " + p.atk + " damage to the " + currentFoe.name + "!");
                if(currentFoe.hp <= 0)
                {
                    System.out.println("You've defeated the " + currentFoe.name + "!");
                    p.mp += 1;
                    cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[0] = null;
                    for(int i = 0; i < cityGrid[p.getxLoc()][p.getyLoc()].monsterRally.length; i++)
                    {
                        if(!(i + 1 >= cityGrid[p.getxLoc()][p.getyLoc()].monsterRally.length))
                        {
                            cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[i] = cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[i + 1];
                            cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[i + 1] = null;
                        }
                    }
                    currentFoe = cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[0];
                    if(currentFoe == null)
                    {
                        System.out.println("You've defeated all the foes!");
                        battle = false;
                    }
                    else
                    {
                        System.out.println(currentFoe.desc);
                    }
                }
            }
            else
            {
                if (pAtk < fAtk)
                {
                    p.hp -= fAtk - pAtk;
                    System.out.println("You took " + (fAtk - pAtk) + " damage from " + currentFoe.name + "!");
                    if (p.hp <= 0)
                    {
                        System.out.println("You've been defeated by the " + currentFoe.name + "...");
                        battle = false;
                        gameOff();
                    }
                }
                if(pAtk == fAtk)
                    System.out.println("It's a power draw!");
            }
        }
        if(move.contains("stk"))
        {
            if(p.mp <= 0)
            {
                System.out.println("You don't have enough MP for a super attack. Gain MP by going to new blocks and beating foes.");
                return;
            }
            p.mp--;
            int pAtk = p.atk + randomWithRange(1, 6) + randomWithRange(1, p.atk);
            int fAtk = currentFoe.atk + randomWithRange(0, currentFoe.atk);
            if(pAtk > fAtk)
            {
                currentFoe.hp -= p.atk;
                System.out.println("You dealt " + p.atk + " damage to the " + currentFoe.name + "!");
                if(currentFoe.hp <= 0)
                {
                    System.out.println("You've defeated the " + cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[0].name + "!");
                    for(int i = 0; i < cityGrid[p.getxLoc()][p.getyLoc()].monsterRally.length; i++)
                    {
                        if(!(i + 1 >= cityGrid[p.getxLoc()][p.getyLoc()].monsterRally.length))
                        {
                            cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[i] = cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[i + 1];
                            cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[i + 1] = null;
                        }
                    }
                    currentFoe = cityGrid[p.getxLoc()][p.getyLoc()].monsterRally[0];
                    if(currentFoe == null)
                    {
                        System.out.println("You've defeated all the foes!");
                        battle = false;
                    }
                    else
                    {
                        System.out.println(currentFoe.desc);
                    }
                }
            }
            else
            {
                if (pAtk < fAtk)
                {
                    p.hp -= fAtk - pAtk;
                    System.out.println("You took " + (fAtk - pAtk) + " damage from " + currentFoe.name + "!");
                    if (p.hp <= 0)
                    {
                        System.out.println("You've been defeated by the " + currentFoe.name + "...");
                        battle = false;
                        gameOff();
                    }
                }
                if(pAtk == fAtk)
                    System.out.println("It's a power draw!");
            }
        }
    }
}