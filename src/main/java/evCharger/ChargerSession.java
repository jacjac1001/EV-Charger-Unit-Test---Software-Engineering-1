package evCharger;

public class ChargerSession {
    private int sessionID;
    private int chargerID;
    private ChargerStatus status;

    public ChargerSession(int sessionID) {
        this.status = ChargerStatus.AVAILABLE;
        this.sessionID = sessionID;
    }

    public void setStatus(ChargerStatus newStatus) {
        this.status = newStatus;
    }

    public ChargerStatus getStatus() {
        return this.status;
    }

    public int getSessionID() {
        return this.sessionID;
    }
}
