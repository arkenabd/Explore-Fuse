
package emp.info.ws.main;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getEmployeeInfo complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="getEmployeeInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Request" type="{http://main.ws.info.emp/}empInfoRequest" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getEmployeeInfo", propOrder = { "request" })
public class GetEmployeeInfo {

    @XmlElement(name = "Request")
    protected EmpInfoRequest request;

    /**
     * Gets the value of the request property.
     *
     * @return
     *     possible object is
     *     {@link EmpInfoRequest }
     *
     */
    public EmpInfoRequest getRequest() {
        return request;
    }

    /**
     * Sets the value of the request property.
     *
     * @param value
     *     allowed object is
     *     {@link EmpInfoRequest }
     *
     */
    public void setRequest(EmpInfoRequest value) {
        this.request = value;
    }

}
