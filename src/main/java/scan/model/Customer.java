package scan.model;

import java.io.Serializable;

public class Customer implements Serializable {
    private int uid;//顾客id
    private String name;//顾客姓名
    private String email;//顾客邮箱
    private String password;//顾客密码
    private int status;//用户激活状态：0代表用户未激活，1代表激活
    private String uuid;//唯一激活码

    public Customer() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "customer{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
