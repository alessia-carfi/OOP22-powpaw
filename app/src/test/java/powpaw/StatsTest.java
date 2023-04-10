package powpaw;

import org.junit.jupiter.api.Test;

import powpaw.player.model.api.DamageMeter;
import powpaw.player.model.api.PlayerStats;
import powpaw.player.model.api.StatsBuilder;
import powpaw.player.model.impl.DamageMeterImpl;
import powpaw.player.model.impl.PlayerStatsImpl;
import powpaw.player.model.impl.StatsBuilderImpl;

import static org.junit.jupiter.api.Assertions.*;

public class StatsTest {

    private static final double ATTACK_DOUBLE = 0.5;
    private static final double DEFENCE_DOUBLE = 0.2;
    private static final double SPEED_DOUBLE = 0.7;
    private static final int ATTACK = 5;
    private static final int DEFENCE = 6;
    private static final int SPEED = 7;
    private static final int DAMAGE_ONE = 15;
    private static final int DAMAGE_TWO = 20;
    private static final int DAMAGE_EXPECTED = 35;

    @Test
    void getStats() {

        PlayerStats stats;
        PlayerStats stats_eq = new PlayerStatsImpl(ATTACK_DOUBLE, DEFENCE_DOUBLE, SPEED_DOUBLE);
        StatsBuilder builder = new StatsBuilderImpl();
        builder.setAttack(ATTACK);
        builder.setDefence(DEFENCE);
        builder.setSpeed(SPEED);
        stats = builder.build();
        assertEquals(stats_eq.getAttack(), stats.getAttack());
        assertEquals(stats_eq.getDefence(), stats.getDefence());
        assertEquals(stats_eq.getSpeed(), stats.getSpeed());
    }

    @Test
    void getDamage() {
        DamageMeter meter = new DamageMeterImpl();
        meter.setDamage(DAMAGE_ONE);
        meter.setDamage(DAMAGE_TWO);
        assertEquals(DAMAGE_EXPECTED, meter.getDamage());
    }
}
