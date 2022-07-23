package com.artnaseef.AMQ8971.testapp;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.Connection;
import javax.jms.JMSException;

public class TestApp {

    private static final Logger DEFAULT_LOGGER = LoggerFactory.getLogger(TestApp.class);

    private Logger log = DEFAULT_LOGGER;

    private ActiveMQConnectionFactory activeMQConnectionFactory;
    private Connection connection;

    private String brokerUrl;

    public String getBrokerUrl() {
        return brokerUrl;
    }

    public void setBrokerUrl(String brokerUrl) {
        this.brokerUrl = brokerUrl;
    }

    public void start() {
        try {
            this.activeMQConnectionFactory = new ActiveMQConnectionFactory(this.brokerUrl);
            this.connection = this.activeMQConnectionFactory.createConnection();
            connection.start();
            log.info("APPLICATION STARTED");
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void shutdown() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (JMSException jmsExc) {
                jmsExc.printStackTrace();
            }
        }
    }
}
