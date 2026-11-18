package evCharger;

import java.util.Vector;
import java.util.Iterator;

public class EVChargerMgmt {

    private Vector<ChargerSession> sessions =
            new Vector<ChargerSession>();

    public void addChargerSession(ChargerSession cs) {
        if (cs != null) {
            this.sessions.add(cs);
        }
    }

    public void updateChargerStatus(
            int sessionID, ChargerStatus newStatus) {

        Iterator<ChargerSession> iterator =
                this.sessions.iterator();

        ChargerSession theSession = null;

        while (iterator.hasNext()) {
            ChargerSession currentSession =
                    iterator.next();

            if (currentSession.getSessionID() == sessionID) {
                theSession = currentSession;
                break;
            }
        }

        if (theSession != null) {
            theSession.setStatus(newStatus);
        }
    }

    public int countNumberOf(ChargerStatus aStatus) {
        Iterator<ChargerSession> iterator =
                this.sessions.iterator();

        int count = 0;

        while (iterator.hasNext()) {
            if (iterator.next().getStatus() == aStatus) {
                count++;
            }
        }

        return count;
    }

    public int getSessionCount() {
        return this.sessions.size();
    }
}
