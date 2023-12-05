package com.example.myapplication

fun main() {

    print("첫 번째 숫자를 입력해주세요: ")
    var num1 = readLine()!!.toInt() // 첫번째 숫자를 입력받는다.

    print("두 번째 숫자를 입력해주세요: ")
    var num2 = readLine()!!.toInt() // 두번째 숫자를 입력받는다.

    println("1.덧셈 2.뺄셈 3.곱셈 4.나눗셈")
    print("어떤 연산을 수행하겠습니까?(숫자로 입력해주세요.): ")
    var op = readLine()!!.toInt()  //수행할 연산 번호를 입력한다.

    var calc = Calculator(num1, num2, op) // Calculator 클래스를 선언한다.
    print("연산 결과는 ${calc.operation()}입니다.") // 연산 결과를 출력한다.
}

class Calculator(n1: Int, n2: Int, k:Int){
    var num1 = 0
    var num2 = 0
    var op = 0
    var result : Double = 0.0

    init { // 클래스가 생성되었을 때 가장 먼저 호출됨
        this.num1 = n1 // 이 클래스의 프로퍼티 num1에 파라미터로 전달된 n1을 할당
        this.num2 = n2 // 이 클래스의 프로퍼티 num2에 파라미터로 전달된 n2를 할당
        this.op = k // 이 클래스의 프로퍼티 op에 파라미터로 전달된 k를 할당
    }

    fun operation() : Double{ //나눗셈 때문에 출력 타입은 Double로 구현
        when(op){ //입력된 숫자에 따라 다른 연산 수행
            1 -> result = num1+num2.toDouble() //덧셈
            2 -> result = num1-num2.toDouble() //뺄셈
            3 -> result = num1*num2.toDouble() //곱셈
            4 -> result = num1/num2.toDouble() //나눗셈
        }
        return result //연산 결과 반환
    }

}