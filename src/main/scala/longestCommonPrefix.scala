//14
object longestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = {
    var ret = ""
    var strsSum = ""
    var count = 0
    var temp = ""
    var chk = true
    //문자열 배열을 한 문자열로 변환
    strs.foreach(s => {
      if(count == 0)
        strsSum = s
      else{
        strsSum = strsSum + (","+s)
      }
      count = count+1
    })

    //첫번째 문자를 보면서 전체 문자열의 해당 문자가 몇번 들어가는지 확인
    strs(0).foreach(c =>{
      if(chk){
        temp = temp+c
        var leng = strsSum.length - strsSum.replace(","+temp,"").length
        if (leng / (temp.length + 1) == strs.length - 1)
          ret = ret + c
        else
          chk = false
      }
    })
    ret
  }
}
