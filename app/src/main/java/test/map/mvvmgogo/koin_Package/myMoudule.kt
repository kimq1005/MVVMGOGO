package test.map.mvvmgogo.koin_Package

import org.koin.dsl.module


var myModule = module {
    single<KoinRepository> { KoinRepository() }
    single<KoinUesCase> {  KoinUesCase(get()) }
}