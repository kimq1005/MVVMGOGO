package test.map.mvvmgogo.koin_Package

class KoinUesCase(private val koinRepository: KoinRepository) {

    fun getCitites() : List<String>{
        return koinRepository.getCities()
    }

    fun getCity(name:String) : String{
        return  koinRepository.getCity(name)
    }

    fun isExistsCity(name:String) : Boolean{
        return koinRepository.isExistCity(name)
    }


}