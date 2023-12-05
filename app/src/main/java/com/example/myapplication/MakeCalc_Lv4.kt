package com.example.myapplication

fun main() {
    print("첫 번째 숫자를 입력해주세요: ")
    var num1 = readLine()!!.toInt()

    print("두 번째 숫자를 입력해주세요: ")
    var num2 = readLine()!!.toInt()

    println("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈")
    print("어떤 연산을 수행하겠습니까?(숫자로 입력해주세요.): ")
    var op = readLine()!!.toInt()  //연산 입력

    when(op){
        1 -> {
            var addOp = AddOperation2(num1, num2)
            addOp.operation()
        }
        2 -> {
            var subOp = SubstractOperation2(num1, num2)
            subOp.operation()
        }
        3 -> {
            var mulOp = MultiplyOperation2(num1, num2)
            mulOp.operation()
        }
        4 -> {
            var divOp = DivideOperation2(num1, num2)
            divOp.operation()
        }
    }

}

interface AbstractOperation{
    fun operation()
}

open class Calculator4{
    var num1 = 0
    var num2 = 0

    constructor(_num1:Int, _num2:Int){
        println("${_num1}을(를) 생성자로 넘겼어요")
        println("${_num2}을(를) 생성자로 넘겼어요")

        num1 = _num1
        num2 = _num2
    }
}

class AddOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation {

    override fun operation(){ //오버라이딩: 부모 클래스를 재설계하는 것
        println("연산 결과는 ${num1+num2}입니다.")
    }

}

class SubstractOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation {
    override fun operation(){
        println("연산 결과는 ${num1-num2}입니다.")
    }

}

class MultiplyOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation {
    override fun operation(){
        println("연산 결과는 ${num1*num2}입니다.")
    }

}

class DivideOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation {
    override fun operation(){
        println("연산 결과는 ${num1/num2.toDouble()}입니다.")
    }

}