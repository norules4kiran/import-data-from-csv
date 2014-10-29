package test

class Contact {

    String name
    String phone


    static 	mapWith = "mongo"

    static constraints = {
        name nullable: true
        phone nullable: true
    }
}
