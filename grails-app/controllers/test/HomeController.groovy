package test

import org.springframework.web.multipart.commons.CommonsMultipartFile

class HomeController {
    static allowedMethods = [importContacts: "POST", update: "PUT", delete: "DELETE"]

    def importService
    def index() {

    }

    def importContacts(){
        def f = request.getFile('file')
        File file = new File("/tmp/file.csv")

        f.transferTo(file)


        file.eachCsvLine { tokens ->
            importService.addOrUpdate(new Contact(name:tokens[0],phone:tokens[1]))
        }
        file.delete()
        redirect(controller: "contact", action: "index")
    }

    def csv(){
        new File("/home/kiran/MyContacts.csv").eachCsvLine { tokens ->
            importService.addOrUpdate(new Contact(name:tokens[0],phone:tokens[1]))
        }
    }
}
