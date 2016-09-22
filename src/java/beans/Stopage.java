
package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class Stopage {

    private int stopageId;
    private String stopageName;
    private int stopageLocId;
    private int operatorId;
    public Stopage() {
    }

    public int getStopageId() {
        return stopageId;
    }

    public void setStopageId(int stopageId) {
        this.stopageId = stopageId;
    }

    public String getStopageName() {
        return stopageName;
    }

    public void setStopageName(String stopageName) {
        this.stopageName = stopageName;
    }

    public int getStopageLocId() {
        return stopageLocId;
    }

    public void setStopageLocId(int stopageLocId) {
        this.stopageLocId = stopageLocId;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }
    
}
