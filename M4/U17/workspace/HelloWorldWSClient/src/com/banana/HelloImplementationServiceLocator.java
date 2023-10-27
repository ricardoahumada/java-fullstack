/**
 * HelloImplementationServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.banana;

public class HelloImplementationServiceLocator extends org.apache.axis.client.Service implements com.banana.HelloImplementationService {

    public HelloImplementationServiceLocator() {
    }


    public HelloImplementationServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public HelloImplementationServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for HelloImplementationPort
    private java.lang.String HelloImplementationPort_address = "http://localhost:8080//HelloWorldWS/HelloImplementationService";

    public java.lang.String getHelloImplementationPortAddress() {
        return HelloImplementationPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String HelloImplementationPortWSDDServiceName = "HelloImplementationPort";

    public java.lang.String getHelloImplementationPortWSDDServiceName() {
        return HelloImplementationPortWSDDServiceName;
    }

    public void setHelloImplementationPortWSDDServiceName(java.lang.String name) {
        HelloImplementationPortWSDDServiceName = name;
    }

    public com.banana.HelloInterface getHelloImplementationPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(HelloImplementationPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getHelloImplementationPort(endpoint);
    }

    public com.banana.HelloInterface getHelloImplementationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.banana.HelloImplementationServiceSoapBindingStub _stub = new com.banana.HelloImplementationServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getHelloImplementationPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setHelloImplementationPortEndpointAddress(java.lang.String address) {
        HelloImplementationPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.banana.HelloInterface.class.isAssignableFrom(serviceEndpointInterface)) {
                com.banana.HelloImplementationServiceSoapBindingStub _stub = new com.banana.HelloImplementationServiceSoapBindingStub(new java.net.URL(HelloImplementationPort_address), this);
                _stub.setPortName(getHelloImplementationPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("HelloImplementationPort".equals(inputPortName)) {
            return getHelloImplementationPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://banana.com/", "HelloImplementationService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://banana.com/", "HelloImplementationPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("HelloImplementationPort".equals(portName)) {
            setHelloImplementationPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
