//Alexander Cox
//Wednesday, January 9 ,2019

import java.util.List;

public class FuelDepot {

    private FuelRobot filler;

    private List<FuelTank> tanks;

    public int nextTankToFill (int threshold)
    {
        int least = filler.getCurrentIndex();

        for (int i = 0; i < tanks.size(); i++)
        {
            if(tanks.get(i).getFuelLevel() < threshold && tanks.get(i).getFuelLevel() < tanks.get(least).getFuelLevel())
                least = i;
        }

        return least;
    }

    public void moveToLocation (int locIndex)
    {
        if (filler.getCurrentIndex() < locIndex && !filler.isFacingRight() || filler.getCurrentIndex() > locIndex && filler.isFacingRight())
            filler.changeDirection();

        filler.moveForward(Math.abs(filler.getCurrentIndex() - locIndex));
    }
}
