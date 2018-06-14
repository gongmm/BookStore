package domain;

import java.io.Serializable;

public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    int adminId;
    String adminName;
    String adminPwd;
    int adminFlag;

    public Admin() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getAdminId() {
        return adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public int getAdminFlag() {
        return adminFlag;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public void setAdminFlag(int adminFlag) {
        this.adminFlag = adminFlag;
    }

    public Admin(int adminId, String adminName, String adminPwd, int adminFlag) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPwd = adminPwd;
        this.adminFlag = adminFlag;
    }
}
