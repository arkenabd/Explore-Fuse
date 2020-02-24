
package emp.info.ws.main;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the emp.info.ws.main package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 *
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EmployeeDataRequest_QNAME =
        new QName("http://main.ws.info.emp/", "EmployeeDataRequest");
    private final static QName _EmployeeDataResponse_QNAME =
        new QName("http://main.ws.info.emp/", "EmployeeDataResponse");
    private final static QName _GetEmployeeInfo_QNAME = new QName("http://main.ws.info.emp/", "getEmployeeInfo");
    private final static QName _GetEmployeeInfoResponse_QNAME =
        new QName("http://main.ws.info.emp/", "getEmployeeInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: emp.info.ws.main
     *
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EmpInfoRequest }
     *
     */
    public EmpInfoRequest createEmpInfoRequest() {
        return new EmpInfoRequest();
    }

    /**
     * Create an instance of {@link EmpInfoResult }
     *
     */
    public EmpInfoResult createEmpInfoResult() {
        return new EmpInfoResult();
    }

    /**
     * Create an instance of {@link GetEmployeeInfo }
     *
     */
    public GetEmployeeInfo createGetEmployeeInfo() {
        return new GetEmployeeInfo();
    }

    /**
     * Create an instance of {@link GetEmployeeInfoResponse }
     *
     */
    public GetEmployeeInfoResponse createGetEmployeeInfoResponse() {
        return new GetEmployeeInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpInfoRequest }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpInfoRequest }{@code >}
     */
    @XmlElementDecl(namespace = "http://main.ws.info.emp/", name = "EmployeeDataRequest")
    public JAXBElement<EmpInfoRequest> createEmployeeDataRequest(EmpInfoRequest value) {
        return new JAXBElement<EmpInfoRequest>(_EmployeeDataRequest_QNAME, EmpInfoRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmpInfoResult }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EmpInfoResult }{@code >}
     */
    @XmlElementDecl(namespace = "http://main.ws.info.emp/", name = "EmployeeDataResponse")
    public JAXBElement<EmpInfoResult> createEmployeeDataResponse(EmpInfoResult value) {
        return new JAXBElement<EmpInfoResult>(_EmployeeDataResponse_QNAME, EmpInfoResult.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeInfo }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmployeeInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://main.ws.info.emp/", name = "getEmployeeInfo")
    public JAXBElement<GetEmployeeInfo> createGetEmployeeInfo(GetEmployeeInfo value) {
        return new JAXBElement<GetEmployeeInfo>(_GetEmployeeInfo_QNAME, GetEmployeeInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetEmployeeInfoResponse }{@code >}
     *
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetEmployeeInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://main.ws.info.emp/", name = "getEmployeeInfoResponse")
    public JAXBElement<GetEmployeeInfoResponse> createGetEmployeeInfoResponse(GetEmployeeInfoResponse value) {
        return new JAXBElement<GetEmployeeInfoResponse>(_GetEmployeeInfoResponse_QNAME, GetEmployeeInfoResponse.class,
                                                        null, value);
    }

}
