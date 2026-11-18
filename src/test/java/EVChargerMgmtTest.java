

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import evCharger.ChargerSession;
import evCharger.ChargerStatus;
import evCharger.EVChargerMgmt;

public class EVChargerMgmtTest {

    @Test
    public void addChargerSessionTestFunction1() {

        // Step 1: Create management object
        EVChargerMgmt mgmt = new EVChargerMgmt();

        // Step 2: Create charger sessions
        ChargerSession s1 = new ChargerSession(101);
        ChargerSession s2 = new ChargerSession(102);
        ChargerSession s3 = new ChargerSession(103);
        ChargerSession s4 = new ChargerSession(104);
        ChargerSession s5 = new ChargerSession(105);

        mgmt.addChargerSession(s1);
        mgmt.addChargerSession(s2);
        mgmt.addChargerSession(s3);

        // Step 3: Record initial count
        int countBefore = mgmt.getSessionCount();
        assertEquals(3, countBefore);

        // Step 4: Add sessions and test the result
        mgmt.addChargerSession(s4);
        mgmt.addChargerSession(s5);

        int countAfter = mgmt.getSessionCount();
        assertEquals(5, countAfter);
    }

    @Test
    public void addChargerSessionTestFunction2() {

        // Step 1: Create management object
        EVChargerMgmt mgmt = new EVChargerMgmt();

        // Step 2: Create a charger session
        ChargerSession s1 = new ChargerSession(201);
        mgmt.addChargerSession(s1);

        // Step 3: Record initial count
        int countBefore = mgmt.getSessionCount();
        assertEquals(1, countBefore);

        // Step 4: Try adding a null session
        mgmt.addChargerSession(null);

        int countAfter = mgmt.getSessionCount();
        assertEquals(1, countAfter);
    }

    @Test
    public void updateChargerStatusTestFunction1() {

        // Step 1: Create management object
        EVChargerMgmt mgmt = new EVChargerMgmt();

        // Step 2: Create charger sessions
        ChargerSession s1 = new ChargerSession(301);
        ChargerSession s2 = new ChargerSession(302);
        ChargerSession s3 = new ChargerSession(303);

        mgmt.addChargerSession(s1);
        mgmt.addChargerSession(s2);
        mgmt.addChargerSession(s3);

        // Step 3: Record initial charging count
        int initialCharging =
                mgmt.countNumberOf(ChargerStatus.CHARGING);
        assertEquals(0, initialCharging);

        // Step 4: Update status and test the result
        mgmt.updateChargerStatus(302, ChargerStatus.CHARGING);

        int updatedCharging =
                mgmt.countNumberOf(ChargerStatus.CHARGING);
        assertEquals(1, updatedCharging);
    }

    @Test
    public void updateChargerStatusTestFunction2() {

        // Step 1: Create management object
        EVChargerMgmt mgmt = new EVChargerMgmt();

        // Step 2: Create charger sessions
        ChargerSession s1 = new ChargerSession(401);
        ChargerSession s2 = new ChargerSession(402);

        mgmt.addChargerSession(s1);
        mgmt.addChargerSession(s2);

        // Step 3: Record initial available count
        int availableBefore =
                mgmt.countNumberOf(ChargerStatus.AVAILABLE);
        assertEquals(2, availableBefore);

        // Step 4: Update status and test the result
        mgmt.updateChargerStatus(401, ChargerStatus.COMPLETED);

        int availableAfter =
                mgmt.countNumberOf(ChargerStatus.AVAILABLE);
        int completedAfter =
                mgmt.countNumberOf(ChargerStatus.COMPLETED);

        assertEquals(1, availableAfter);
        assertEquals(1, completedAfter);
    }
}

