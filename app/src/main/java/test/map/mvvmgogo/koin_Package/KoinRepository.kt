package test.map.mvvmgogo.koin_Package

class KoinRepository {

    private val cities = listOf<String>("서울" , "부산", "인천")

    fun getCities() : List<String>{
        return cities
    }

    fun getCity(name:String) :String{
        return cities.get(cities.indexOf(name))
    }

    fun isExistCity(name:String) :Boolean {
        return cities.indexOf(name) > 0
    }
}