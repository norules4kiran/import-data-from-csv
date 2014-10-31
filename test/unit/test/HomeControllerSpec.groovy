package test

import grails.test.mixin.TestFor
import org.codehaus.groovy.grails.plugins.testing.GrailsMockMultipartFile
import org.springframework.mock.web.MockMultipartFile
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HomeController)
class HomeControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test bulk import contacts"() {
        /*when: "file is uploaded to import"
        def contentBytes = new File("/home/kiran/workspace/test/sample-file-to-upload.csv").getBytes()
        def file = new MockMultipartFile('file', 'sample-file-to-upload.csv', 'text/csv', contentBytes)
        request.addFile file
        controller.importContacts()

        then: "The model is correct"
        !model.contactInstanceList
        model.contactInstanceCount == 0*/
    }
}
