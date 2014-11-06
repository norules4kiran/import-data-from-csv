package test

import org.jivesoftware.smack.AbstractXMPPConnection
import org.jivesoftware.smack.ConnectionConfiguration
import org.jivesoftware.smack.SmackConfiguration
import org.jivesoftware.smack.tcp.XMPPTCPConnection
import org.jivesoftware.smackx.iqregister.AccountManager
import org.springframework.web.multipart.commons.CommonsMultipartFile

import javax.net.ssl.SSLSocketFactory

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


    def createAccount(){


        ConnectionConfiguration connConfig = new ConnectionConfiguration("example.com", 5222, "localhost");

        AbstractXMPPConnection connection = new XMPPTCPConnection(connConfig);
        connection.connect();
        AccountManager mAccount = AccountManager.getInstance(connection);
        if (mAccount.supportsAccountCreation()) {
            mAccount.createAccount("user2", "opened");
        }

        render "created"
    }

}
