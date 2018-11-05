package Board;

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
        for(int i = 0; i < eCo; i++)
        {

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
