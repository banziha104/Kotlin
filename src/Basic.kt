
fun main(args : Array<String>){
    val user = mUser("leeyoungjoon",1,"코")
    user.printNickName("본격적 호출")
    var obj : RefCheck? = null


}


class mUser{
    var nickName : String
    var age : Int
    var cor : String? =null
    init {
        printNickName("프린트 ")
    }

    constructor(_nickName: String, _age: Int, _cor : String){
        nickName = _nickName
        age = _age
        cor = _cor
    }

    fun printNickName(text : String){
        println(text)
    }

    fun myFun(str : Any?) = myFun2(str)

    fun myFun2(str : Any?) {
        printNickName("this is good")
    }


        companion object {
        fun comFun(str : String?){
            if(str?.toString() != null){
                print("동반객체 생성");
            }
        }
    }
    }

object Cao : Foo{
    override fun foo() {
       print("Pkk")
    }
}

interface Foo{
    fun foo()
}
