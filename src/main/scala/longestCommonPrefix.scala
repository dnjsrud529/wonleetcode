object longestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = {
    var ret = ""
    var strsSum = ""
    var count = 0
    var temp = ""
    var chk = true
    strs.foreach(s => {
      if(count == 0)
        strsSum = s
      else{
        strsSum = strsSum + (","+s)
      }
      count = count+1
    })


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
