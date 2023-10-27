/**
 * HelloImplementationService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.banana;

public interface HelloImplementationService extends javax.xml.rpc.Service {
    public java.lang.String getHelloImplementationPortAddress();

    public com.banana.HelloInterface getHelloImplementationPort() throws javax.xml.rpc.ServiceException;

    public com.banana.HelloInterface getHelloImplementationPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
