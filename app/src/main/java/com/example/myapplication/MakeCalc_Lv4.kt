package com.example.myapplication

fun main() {
    while (true){
        try {
            println("0.종료 1.덧셈 2.뺄셈 3.곱셈 4.나눗셈")
            print("어떤 연산을 수행하겠습니까?(숫자로 입력해주세요.): ")
            var op = readLine()!!.toInt()  //수행할 연산 번호를 입력한다.
            if(op == 0){
                print("계산기를 종료합니다.")
                break
            }

            print("첫 번째 숫자를 입력해주세요: ")
            var num1 = readLine()!!.toInt() // 첫번째 숫자를 입력받는다.

            print("두 번째 숫자를 입력해주세요: ")
            var num2 = readLine()!!.toInt() // 두번째 숫자를 입력받는다.

            when(op){ //입력된 숫자에 따라 다른 연산 수행
                1 -> {
                    var addOp = AddOperation2(num1, num2) //덧셈 연산에 필요한 AddOperation 클래스만 생성
                    addOp.operation() // 연산 함수 실행
                }
                2 -> {
                    var subOp = SubstractOperation2(num1, num2) //뺄셈 연산에 필요한 SubstractOperation 클래스만 생성
                    subOp.operation() // 연산 함수 실행
                }
                3 -> {
                    var mulOp = MultiplyOperation2(num1, num2) //곱셈 연산에 필요한 MultiplyOperation 클래스만 생성
                    mulOp.operation() // 연산 함수 실행
                }
                4 -> {
                    var divOp = DivideOperation2(num1, num2) //나눗셈 연산에 필요한 DivideOperation 클래스만 생성
                    divOp.operation() // 연산 함수 실행
                }
            }
        }
        catch (e:java.lang.NumberFormatException){
            println("숫자를 입력하세요!")
        }
    }
}

interface AbstractOperation{ // 인터페이스
    fun operation()
}

open class Calculator4{ // open을 적어서 다른 클래스의 부모 클래스로 설정함
    var num1 = 0
    var num2 = 0

    constructor(_num1:Int, _num2:Int){
//        println("${_num1}을(를) 생성자로 넘겼어요")
//        println("${_num2}을(를) 생성자로 넘겼어요")

        num1 = _num1 // 이 클래스의 프로퍼티 num1에 파라미터로 전달된 n1을 할당
        num2 = _num2 // 이 클래스의 프로퍼티 num2에 파라미터로 전달된 n2를 할당
    }
}

class AddOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation { //덧셈을 수행할 클래스

    override fun operation(){ //오버라이딩 기법으로 부모 클래스의 메소드를 재설계
        println("연산 결과는 ${num1+num2}입니다.")
    }

}

class SubstractOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation { //뺄셈을 수행할 클래스
    override fun operation(){ //오버라이딩 기법으로 부모 클래스의 메소드를 재설계
        println("연산 결과는 ${num1-num2}입니다.")
    }

}

class MultiplyOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation { //곱셈을 수행할 클래스
    override fun operation(){ //오버라이딩 기법으로 부모 클래스의 메소드를 재설계
        println("연산 결과는 ${num1*num2}입니다.")
    }

}

class DivideOperation2(num1:Int, num2:Int) : Calculator4(num1, num2), AbstractOperation { //나눗셈을 수행할 클래스
    override fun operation(){ //오버라이딩 기법으로 부모 클래스의 메소드를 재설계
        println("연산 결과는 ${num1/num2.toDouble()}입니다.")
    }

}