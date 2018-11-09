package Board;

import Game.Runner;
import People.Person;
/* Contains block constructors that have chances to contain bonuses or monsters */
public class Blocks {
    Person occupant;
    int xLoc;
    int yLoc;
    public int eCo;
    boolean restore;
    boolean trueRestore;
    boolean hasMap;
    String[] blockDesc = {"You enter a dark alleyway littered with trash.", "You enter the ruins of a shopping mall.", "You enter a dilapidated train station."};
    public Monsters[] monsterRally = null;
    String desc;

    public Blocks(int x, int y, int enCount)
    {
        xLoc = x;
        yLoc = y;
        restore = true;
        eCo = enCount;
        if(Runner.randomWithRange(0, 20) == 20)
        {
            hasMap = true;
            eCo = 0;
        }
        if(Runner.randomWithRange(0, 10) == 10)
            trueRestore = true;
        monsterRally = new Monsters[enCount];
        int r = 0;
        int r2 = 0;
        desc = blockDesc[Runner.randomWithRange(0, blockDesc.length - 1)];
        for(int i = 0; i < eCo; i++)
        {
            r = Runner.randomWithRange(1, 3);
            r2 = Runner.randomWithRange(1, 3);
            if(r == 1 && r2 != 3)
                monsterRally[i] = new Monsters(Shambler.name, Shambler.hp, Shambler.atk, Shambler.desc[Runner.randomWithRange(0, Shambler.desc.length - 1)]);
            if(r == 1 && r2 == 3)
                monsterRally[i] = new Monsters(HardenedShambler.name, HardenedShambler.hp, HardenedShambler.atk, HardenedShambler.desc[Runner.randomWithRange(0, HardenedShambler.desc.length - 1)]);
            if(r == 2 && r2 != 3)
                monsterRally[i] = new Monsters(Speedster.name, Speedster.hp, Speedster.atk, Speedster.desc[Runner.randomWithRange(0, Speedster.desc.length - 1)]);
            if(r == 2 && r2 == 3)
                monsterRally[i] = new Monsters(ViciousSpeedster.name, ViciousSpeedster.hp, ViciousSpeedster.atk, ViciousSpeedster.desc[Runner.randomWithRange(0, ViciousSpeedster.desc.length - 1)]);
            if(r == 3 && r2 == 3)
                monsterRally[i] = new Monsters(Tank.name, Tank.hp, Tank.atk, Tank.desc);
            if(r == 3 && r2 != 3)
                monsterRally[i] = new Monsters(Shambler.name, Shambler.hp, Shambler.atk, Shambler.desc[Runner.randomWithRange(0, Shambler.desc.length - 1)]);
        }
    }

    /**
     * Method controls the results when a person enters this room.
     * @param x the Person entering
     */
    public void enterBlocks(Person x)
    {
        if(restore)
        {
            x.mp++;
            restore = false;
        }
        if(trueRestore)
        {
            int hpR = Runner.randomWithRange(5, 10);
            System.out.println("This block has great energies. Your HP was restored by " + hpR + " points!");
            x.hp += hpR;
            trueRestore = false;
        }
        if(hasMap)
        {
            System.out.println("You find a map of the city on the wall. You take a look.");
            System.out.println(printGrid(Runner.player));
        }
        System.out.println(desc);
        occupant = x;
        if(this.eCo > 0)
        {
            Runner.battle = true;
            System.out.println("You see " + eCo + " monsters!");
            for(int i = 0; i < this.eCo; i++)
                System.out.println(this.monsterRally[i].desc);
        }
        else
            System.out.println("No monsters for now...");
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
    }
    public static String printGrid(Person p)
    {
        String h = "";
        for(int i = 0; i < Runner.cityGrid.length; i++)
        {
            for(int j = 0; j < Runner.cityGrid[i].length; j++)
            {
                if(i == p.getxLoc() && j == p.getyLoc())
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
