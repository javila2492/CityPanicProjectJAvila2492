package Board;

import Game.Runner;
import People.Person;

public class Blocks {
    Person occupant;
    int xLoc;
    int yLoc;
    public int eCo;
    String[] blockDesc = {"You enter a dark alleyway littered with trash.", "You enter the ruins of a shopping mall.", "You enter a dilapidated train station."};
    public Monsters[] monsterRally = null;

    public Blocks(int x, int y, int enCount)
    {
        xLoc = x;
        yLoc = y;
        eCo = enCount;
        monsterRally = new Monsters[enCount];
        int r = 0;
        for(int i = 0; i < eCo; i++)
        {
            r = (int) (Math.random() * 5);
            if(r == 1)
                monsterRally[i] = new Monsters(Shambler.name, Shambler.hp, Shambler.atk, Shambler.desc[(int) (Math.random() * Shambler.desc.length)]);
            if(r == 2)
                monsterRally[i] = new Monsters(HardenedShambler.name, HardenedShambler.hp, HardenedShambler.atk, HardenedShambler.desc[(int) (Math.random() * HardenedShambler.desc.length)]);
            if(r == 3)
                monsterRally[i] = new Monsters(Speedster.name, Speedster.hp, Speedster.atk, Speedster.desc[(int) (Math.random() * Speedster.desc.length)]);
            if(r == 4)
                monsterRally[i] = new Monsters(ViciousSpeedster.name, ViciousSpeedster.hp, ViciousSpeedster.atk, ViciousSpeedster.desc[(int) (Math.random() * ViciousSpeedster.desc.length)]);
            if(r == 5 && (int) (Math.random() * 5) == 5)
                monsterRally[i] = new Monsters(Tank.name, Tank.hp, Tank.atk, Tank.desc);
        }
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterBlocks(Person x)
    {
        System.out.println(blockDesc[(int) (Math.random() * 3)]);
        occupant = x;
        System.out.println(this.eCo);
        if(this.eCo > 0)
        {
            Runner.battle = true;
            System.out.println("Battle start!");
            for(int i = 0; i < this.eCo; i++)
                System.out.println(this.monsterRally[i].desc);
        }
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
    public static String printGrid()
    {
        String h = "";
        for(int i = 0; i < Runner.cityGrid.length; i++)
        {
            for(int j = 0; j < Runner.cityGrid[i].length; j++)
            {
                if(i == 0 && j == 0)
                    h += "[Y]";
                else
                {
                    if (Runner.cityGrid[i][j].eCo > 0) {
                        h += "[X]";
                    } else
                        h += "[ ]";
                }
            }
            h += "\n";
        }
        return h;
    }

    /**
     * Removes the player from the room.
     * @param x
     */
    public void leaveBlocks(Person x)
    {
        occupant = null;
    }

}
