package test.map.mvvmgogo.koin_Package

class Student(
    val course: SchoolCourse = SchoolCourse(), val friend: Friend = Friend(),
) {


    fun beSamrt() {
        course.study()
        friend.hangout()
    }
}


class SchoolCourse {
    fun study() {
        println("I am a studying")
    }
}

class Friend {
    fun hangout() {
        println("We're hanging out")
    }
}