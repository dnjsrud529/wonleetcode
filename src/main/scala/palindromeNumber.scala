object palindromeNumber {
  //입력된 숫자의 자릿수를 리턴
  def getLength(num: Int, compare: Int, size: Int): Int = {
    var sizeRet = 0

    if(compare < 0)
      sizeRet = 10
    else if(num / compare == 0){
      sizeRet = size -1
    }
    else{
      sizeRet = getLength(num,compare*10,size+1)
    }

    sizeRet
  }

  //10의 num승을 반환
  def getTenX(num: Int): Int = {
    var ret = 1

    for(x <- 1 to num){
      ret = ret * 10
    }

    ret
  }

  def isPalindrome(x: Int): Boolean = {
    var ret = true

    //음수일 경우 무조건 false
    if(x < 0)
      ret = false
    else{
      val length = getLength(x,10,2)

      var array = new Array[Int](length)
      var temp = x
      var cnt = 0
      //숫자를 각 자릿수 별로 Array에 저장
      for(a <- length to 1 by -1){
        if((a-1) != 0){
          array(cnt) = temp / getTenX(a-1)
          cnt += 1
          temp = temp % getTenX(a-1)

        }else{
          array(cnt) = temp
        }
      }

      //시작과 끝을 비교하면서 결과 확인
      for(test <- 0 to length/2){
        if(array(test) != array(length-(1+test))){
          ret = false
        }
      }

    }

    ret
  }
}
