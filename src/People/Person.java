package People;

/**
 * Person represents the player as they move through the game.
 */
public class Person {
    public String name;
    public int hp;
    public int atk;
    public Skills skill;
    public int xLoc, yLoc;
    public int skillNum;


    public int getxLoc() {
        return xLoc;
    }

    public void setxLoc(int xLoc) {
        this.xLoc = xLoc;
    }

    public int getyLoc() {
        return yLoc;
    }

    public void setyLoc(int yLoc) {
        this.yLoc = yLoc;
    }

    public Person (String name, int hp, int atk, Skills skill, int xLoc, int yLoc, int skillNum)
    {
        this.name = name;
        this.hp = hp;
        this.atk = atk;
        this.skill = skill;
        this.xLoc = xLoc;
        this.yLoc = yLoc;
        this.skillNum = skillNum;
    }


}
