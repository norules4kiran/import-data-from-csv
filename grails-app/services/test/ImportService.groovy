package test

import grails.transaction.Transactional

@Transactional
class ImportService {

    def addOrUpdate(Contact contact) {
        def existingContact = Contact.findByName(contact.name)

        if(existingContact){
            existingContact.properties = contact.properties
            existingContact.save(flush: true)
            return existingContact
        }else {
            return contact.save(flush: true)
        }

    }
}
