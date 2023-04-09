package powpaw.controller.impl;

import powpaw.controller.api.StatsController;

/**
 * StatsController implementation. For balance reason every stat have a minimum
 * of 5 and a max of 10.
 * 
 * @author Simone Collorà
 */
public class StatsControllerImpl implements StatsController {
    private final static int maxPoint = 10;
    private final static int minPoint = 5;
    private final static int plusMinus = 1;

    @Override
    public int increase(int stat) {
        if (stat < maxPoint) {
            stat += plusMinus;
        }
        return stat;
    }

    @Override
    public int decrease(int stat) {
        if (stat > minPoint) {
            stat -= plusMinus;
        }
        return stat;
    }

}
