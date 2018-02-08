import java.sql.Ref

var list = mutableListOf<RefCheck>()
var numList = mutableListOf<Int>()

fun main(args : Array<String>){
    for (i in 1..100){
        list.add(RefCheck(i))
    }
    var newList = list.filter(RefCheck::isMoreThree).map(RefCheck::toMapString)
    lin@ for( i in newList) {
        print(i)

        break@lin
    }

}


class RefCheck(var num : Int = 0){



    fun isMoreThree() : Boolean{
        return num > 3
    }
    fun toMapString() : String{
        return "$num + 입니다 /"
    }
}