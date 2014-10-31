package test

class Contact {

    String name
    String phone


    static 	mapWith = "mongo"

    static constraints = {
        name nullable: false
        name unique: true
        phone nullable: true
    }
}
