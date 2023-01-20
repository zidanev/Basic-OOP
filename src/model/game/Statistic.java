package model.game;

import java.io.Serializable;

public class Statistic implements Serializable {

    private int totalDownload = 0;
    private int totalActiveUser = 0;

    public void setTotalActiveUser(int totalActiveUser) {
        this.totalActiveUser = totalActiveUser;
    }

    public void setTotalDownload(int totalDownload) {
        this.totalDownload = totalDownload;
    }

    public int getTotalActiveUser() {
        return totalActiveUser;
    }

    public int getTotalDownload() {
        return totalDownload;
    }
}
