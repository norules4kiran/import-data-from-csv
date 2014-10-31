package test

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Contact)
class ContactSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        def existingContact = new Contact(
                name: "kiran",
                phone: "9886562462")

        mockForConstraintsTests(Contact, [existingContact])

        // validation should fail if both properties are null
        def contact = new Contact()

        assert !contact.validate()
        assert "nullable" == contact.errors["name"].code

        // So let's demonstrate the unique and minSize constraints

        contact = new Contact(name: "kiran", kiran: "9052256052")
        assert !contact.validate()
        assert "unique" == contact.errors["name"].code

        // Validation should pass!
        contact = new Contact(name: "kumar", phone: "9052256052")
        assert contact.validate()
    }
}
