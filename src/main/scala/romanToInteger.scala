object romanToInteger {
  def romanToInt(s: String): Int = {
    val roman = Map(('I',1),('V',5),('X',10),('L',50),('C',100),('D',500),('M',1000))
    var ret = 0
    val charArray = s.toArray
    var intArray = new Array[Int](s.length+1)

    //받은 문자열을 각각 매핑된 정수 배열로 변환
    charArray.zipWithIndex.foreach{
      case(char,i) => {
        intArray(i) = roman(char)
      }
    }
    intArray(s.length) = -1

    var temp = 0
    var bef = 0

    //숫자를 하나씩 읽으며 다음 숫자와 이전 숫자를 비교하여 값을 구한 후 결과에 추가
    intArray.foreach(num =>{

      if(temp == 0){
        temp = num
      }
      else if(num == -1){
        ret += temp
      }
      else if(bef > num){
        ret = ret+temp
        temp = num
      }else if(bef == num){
        temp = temp+num
      }else{
        ret = ret + (num-temp)
        temp = 0
      }

      bef=num
    })


    ret

  }
}
