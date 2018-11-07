package Board;

import Game.Runner;
import People.Person;

public class Blocks {
    Person occupant;
    int xLoc,yLoc, eCo;
    String[] blockDesc = {"You enter a dark alleyway littered with trash.", "You enter the ruins of a shopping mall.", "You enter a dilapidated train station."};

    public Blocks(int x, int y, int enCount)
    {
        xLoc = x;
        yLoc = y;
        eCo = enCount;
        Monsters monsterRally[] = new Monsters[enCount];
        int r = 0;
        for(int i = 0; i < eCo; i++)
        {
            r = (int) (Math.random() * 5);
            if(r == 1)
                monsterRally[i] = new Monsters(Shambler.name, Shambler.hp, Shambler.atk);
            if(r == 2)
                monsterRally[i] = new Monsters(HardenedShambler.name, HardenedShambler.hp, HardenedShambler.atk);
            if(r == 3)
                monsterRally[i] = new Monsters(Speedster.name, Speedster.hp, Speedster.atk);
            if(r == 4)
                monsterRally[i] = new Monsters(ViciousSpeedster.name, ViciousSpeedster.hp, ViciousSpeedster.atk);
            if(r == 5 && (int) (Math.random() * 5) == 5)
                monsterRally[i] = new Monsters(Tank.name, Tank.hp, Tank.atk);
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
        if(this.eCo > 0)
        {
            Runner.battle = true;
            System.out.println("Battle start!");
        }
        x.setxLoc(this.xLoc);
        x.setyLoc(this.yLoc);
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
