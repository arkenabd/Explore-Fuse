
package emp.info.ws.main;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEmployeeInfoResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getEmployeeInfoResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://main.ws.info.emp/}empInfoResult" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmployeeInfoResponse", propOrder = { "_return" })
public class GetEmployeeInfoResponse {

    @XmlElement(name = "return")
    protected EmpInfoResult _return;

    /**
     * Gets the value of the return property.
     *
     * @return
     *     possible object is
     *     {@link EmpInfoResult }
     *
     */
    public EmpInfoResult getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value
     *     allowed object is
     *     {@link EmpInfoResult }
     *
     */
    public void setReturn(EmpInfoResult value) {
        this._return = value;
    }

}
