package grails.plugins.raven

import grails.test.*
import grails.test.mixin.*
import grails.util.Holders

import org.apache.log4j.Priority
import org.apache.log4j.spi.LoggingEvent

class RavenClientTests extends GroovyTestCase {   
    
    def grailsApplication = Holders.getGrailsApplication()
    
    def RavenClient sut = grailsApplication.mainContext.getBean("ravenClient")
    
    protected void setUp() {
        super.setUp()
    }

    protected void tearDown() {
        super.tearDown()
    }

    def void testClient() {
        LoggingEvent event = new LoggingEvent("categoryClass", org.apache.log4j.Category.getInstance("Raven Test"), Priority.ERROR, "Message", new RuntimeException("Exception"));
        sut.captureEvent(event, null, null);        
    }
}
